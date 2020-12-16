/***
 * Project Student
 */


package com.ust.training.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.ust.training.student.constant.ISqlQueryConstants;
import com.ust.training.student.constant.IStudentDbConstants;
import com.ust.training.student.exception.StudentDataAcssesException;
import com.ust.training.student.model.Student;
import lombok.extern.slf4j.Slf4j;

/***
 * Dao class for student this class do the dao operations.
 * 
 * @author SACHIN AJITHKUMAR
 *
 */
@Component
@Slf4j
public class StudentDao {

  @Autowired
  private CosmosClientBuilder cosmosClientBuilder;
  @Value(IStudentDbConstants.DATABASE_NAME)
  private String databaseName;

  /***
   * This method accepts 2 parameters for the query query execution happeing here.
   * 
   * @param studentDepartment
   * @param rollNumber
   * @return List of Students
   */
  public List<Student> FetchStudentByStudentDepartmentAndRollnumber(String studentDepartment,
      Integer rollNumber) {
    log.debug("Fetching student by department and rollnumber starts");
    List<Student> studentList = null;
    try {

      SqlQuerySpec querySpec = new SqlQuerySpec();
      SqlParameter department =
          new SqlParameter(ISqlQueryConstants.DATABASE_PARAM_STUDENT_DEPARTMENT, studentDepartment);
      SqlParameter rollNumberparam =
          new SqlParameter(ISqlQueryConstants.DATABASE_PARAM_STUDENT_ROLLNUMBERT, rollNumber);
      List<SqlParameter> paramList = new ArrayList<>();
      String query = ISqlQueryConstants.BASE_QUERY;
      if (null != rollNumber) {
        query = query.concat(ISqlQueryConstants.ROLL_NUMBER_CRITERIA);
        paramList.add(rollNumberparam);
      }
      if (!StringUtils.isEmpty(studentDepartment)) {
        query = query.concat(ISqlQueryConstants.DEPARTMENT_CRITERIA);
        paramList.add(department);
      }
      querySpec.setQueryText(query);
      querySpec.setParameters(paramList);
      studentList = cosmosClientBuilder.buildClient().getDatabase(databaseName)
          .getContainer(IStudentDbConstants.COLLECTION_NAME).queryItems(querySpec, getQueryOptions(), Student.class)
          .stream().collect(Collectors.toList());
    } catch (Exception exception) {
      log.error(
          "Exception occured in fetchStudentByQueryWithDepartmentAndRollnumber method in dao:",
          exception);
      throw new StudentDataAcssesException("Exception in DeleteStudent", exception);
    }
    log.debug("Fetching student by department and rollnumber ends");
    return studentList;

  }

  /***
   * Its for Query option
   * 
   * @return the CosmosQueryOptions
   */
  private CosmosQueryRequestOptions getQueryOptions() {
    CosmosQueryRequestOptions options = new CosmosQueryRequestOptions();
    options.setQueryMetricsEnabled(Boolean.FALSE);
    return options;
  }

}


