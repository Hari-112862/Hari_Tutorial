/***
 * Project Name : StudentProject
 */

package com.ust.training.student.controller;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.training.student.annotation.SwaggerToken;
import com.ust.training.student.common.CriteriaSearchDTO;
import com.ust.training.student.common.StudentDTO;
import com.ust.training.student.model.Student;
import com.ust.training.student.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/***
 * Controller class contains all post delete and get mapping methods
 * 
 * @author SACHIN AJITHKUMAR
 *
 */
@RestController
@Slf4j
public class StudentController {

  @Autowired
  StudentService studentService;


  /***
   * post method which is addingStudent
   * 
   * @param studentDto
   * @return ResponseEntity of Student
   */
  @PostMapping("/save")
  @SwaggerToken
  @ApiOperation(value = "Save and Update a Student ", notes = "Returns 201 Created/204 NO_CONTENT",
      httpMethod = HttpMethod.POST)

  public ResponseEntity<Student> saveStudent(@Validated @RequestBody StudentDTO studentDto) {
    log.debug("Begining the Post  operation saveStudent");
    Student student = studentService.updateAndSaveStudent(studentDto);
    if (null != student) {
      log.info("Status:201  Response:", studentDto);
      log.debug("Ending the Post operation saveStudent no value");
      return ResponseEntity.ok(student);
    } else {
      log.info("Status:204  Response:");
      log.debug("Ending the Post operation saveStudent no value");
      return ResponseEntity.noContent().build();
    }
  }

  /***
   * Delete method which is deleting existing student
   * 
   * @param id
   * @return String
   */

  @DeleteMapping("/{id}")
  @SwaggerToken
  @ApiOperation(value = "Delete an existing Student", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.DELETE)

  public ResponseEntity<String> deleteStudent(@PathVariable String id) {
    log.debug("Begining the Delete operation deleteUser");
    Student student=null;
    String statusMessage = null;
    student = studentService.deleteStudent(id);
    if (null != student) {
      log.info("Status:200  Response:");
      statusMessage="Deleted";
      log.debug("Ending the Delete operation deleteUser");
      return ResponseEntity.ok(statusMessage);
    }
    log.info("Status:204  Response:");
    log.debug("Ending the Delete operation deleteUser");
    return ResponseEntity.noContent().build();
  }

  /***
   * This method getting already present student by id
   * 
   * @param id
   * @return ResposeEntity of Student Dto
   */

  @GetMapping("/{id}")
  @SwaggerToken
  @ApiOperation(value = "Fetching a Student ", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.GET)
  public ResponseEntity<StudentDTO> fetchStudent(@PathVariable String id) {

    log.debug("Begining the fetch by id operation");
    StudentDTO studentDto = studentService.fetchStudent(id);
    if (null != studentDto) {
      log.info("Status:200  Response:", studentDto);
      log.debug("Ending the  fetch by id operation");
      return ResponseEntity.ok(studentDto);
    } else {
      log.info("Status:204  Response:");
      log.debug("Ending the fetch by id operation");
      return ResponseEntity.noContent().build();
    }
  }

  /***
   * Post method for mapping to the service method for search by department and rollnumber using
   * query
   * 
   * @param searchByDTO Object
   * @return students List return as StudentDtos
   */
  @PostMapping("/search")
  @SwaggerToken
  @ApiOperation(value = "Search by Department name and rollnumber ", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.POST)

  public ResponseEntity<List<Student>> fetchStudentByCriteria(
      @RequestBody CriteriaSearchDTO searchByCriteria) {
    log.debug("Begining of the post operation  searchStudentByDepartmentRollNumber method");
    List<Student> student =
        studentService.fetchStudentByCriteria(searchByCriteria);
    if (!CollectionUtils.isEmpty(student)) {
      log.info("Status:200  Response:", student);
      log.debug("Ending the searchStudentByDepartmentRollNumber operation");
      return ResponseEntity.ok(student);
    } else {
      log.info("Status:204  Response:");
      log.debug("Ending the Post searchStudentByDepartmentRollNumber operation");
      return ResponseEntity.noContent().build();
    }
  }

}


