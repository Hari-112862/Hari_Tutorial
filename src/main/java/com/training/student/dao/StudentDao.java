/***
 * Project Student
 */


package com.training.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.training.student.constant.SQLQueries;
import com.training.student.mapper.StudentMapper;
import com.training.student.model.Student;

/***
 * Dao class for student this class do the dao operations.
 * 
 * @author SACHIN AJITHKUMAR
 *
 */
@Component
public class StudentDao {


  @Autowired
  private StudentMapper mapper;
  @Autowired
  private CosmosClientBuilder cosmosClientBuilder;
  @Value("${azure.cosmosdb.database}")
  private String databaseName;
  private String collectionName = "studentDb";

  /***
   * This method accepts 2 parameters for the query query execution happeing here.
   * 
   * @param studentDepartment
   * @param rollNumber
   * @return List of Students
   */
  public List<Student> FetchStudentByStudentDepartmentAndRollnumber(String studentDepartment,
      Integer rollNumber) {
    SqlQuerySpec querySpec = new SqlQuerySpec();
    String query = null;
    if (studentDepartment.isEmpty() || 0 == rollNumber) {
      query = SQLQueries.BASE_QUERY.concat(SQLQueries.ROLL_NUMBER_CRITERIA)
          .concat(SQLQueries.DEPARTMENT_OR_CRITERIA);
    } else {
      query = SQLQueries.BASE_QUERY.concat(SQLQueries.DEPARTMENT_CRITERIA)
          .concat(SQLQueries.ROLL_NUMBER_CRITERIA);
    }

    querySpec.setQueryText(query);
    SqlParameter department = new SqlParameter("@studentDepartment", studentDepartment);
    SqlParameter rollNumberparam = new SqlParameter("@rollNumber", rollNumber);
    List<SqlParameter> paramList = new ArrayList<>();
    paramList.add(department);
    paramList.add(rollNumberparam);
    querySpec.setParameters(paramList);

    List<Student> studentList = cosmosClientBuilder.buildClient().getDatabase(databaseName)
        .getContainer(collectionName).queryItems(querySpec, getQueryOptions(), Student.class)
        .stream().collect(Collectors.toList());;

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


