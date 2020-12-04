/***
 * Project Name : StudentProject
 */

package com.training.student.controller;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.student.annotation.SwaggerToken;
import com.training.student.common.StudentDTO;
import com.training.student.model.Student;
import com.training.student.service.StudentService;

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
  @PostMapping("/student")
  @SwaggerToken
  @ApiOperation(value = "Save and Update a Student ", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.POST)

  public ResponseEntity<Student> addUser(@RequestBody StudentDTO studentDto) {

    log.debug("Begining the Post operation");
    Student student = studentService.updateAndSaveStudent(studentDto);
    if (student != null) {
      log.debug("Status:201  Response:", studentDto);
      log.debug("Ending the Post operation");
      return ResponseEntity.ok(student);
    } else {
      log.debug("Status:204  Response:", studentDto);
      log.debug("Ending the Post operation because of no value");
      return ResponseEntity.noContent().build();

    }

  }

  /***
   * Delete method which is deleting existing student
   * 
   * @param id
   * @return String
   */

  @DeleteMapping("/student/{id}")
  @SwaggerToken
  @ApiOperation(value = "Delete an existing Student", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.DELETE)

  public String deleteUser(@PathVariable String id) {

    log.debug("Begining the Delete operation");
    log.debug("Ending the Delete operation");
    return studentService.deleteStudent(id);
  }

  /***
   * This method getting already present student by id
   * 
   * @param id
   * @return ResposeEntity of Student Dto
   */

  @GetMapping("/student/{id}")

  @SwaggerToken
  @ApiOperation(value = "Fetching a Student ", notes = "Returns 200 OK/204 NO_CONTENT",
      httpMethod = HttpMethod.GET)

  public ResponseEntity<StudentDTO> getStudent(@PathVariable String id) {

    log.debug("Begining the Get operation");
    StudentDTO studentDto = studentService.getStudent(id);
    if (studentDto != null) {
      log.debug("Status:201  Response:", studentDto);
      return ResponseEntity.ok(studentDto);
    } else {
      log.debug("Ending the Get operation");
      log.debug("Status:204  Response:", studentDto);
      return ResponseEntity.noContent().build();
    }
  }

}
