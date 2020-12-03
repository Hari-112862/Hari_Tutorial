/**
 * Project Name  : StudentProject


 * 
 */


package com.training.StudentDemo.controller;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.StudentDemo.*;
import com.training.StudentDemo.Model.Student;
import com.training.StudentDemo.annotation.SwaggerToken;
import com.training.StudentDemo.common.StudentDto;
import com.training.StudentDemo.service.StudentService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



/***
 * Controller class contains all post delete and get mapping methods
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
 * @param studentDto
 * @return
 */
	@PostMapping("/student")

	@SwaggerToken

	@ApiOperation(value = "Insert", notes = "Returns 200 OK/204 NO_CONTENT", httpMethod = HttpMethod.POST)

	public String addUser(@RequestBody StudentDto studentDto) {

		log.info("Begining the Post operation");
		

		log.info("Ending the Post operation");
		
		

		return studentService.saveAndUpdateStudent(studentDto);
	}

	/***
	 * Delete method which is deleting existing student
	 * @param id
	 * @return
	 */
	
	
	@DeleteMapping("/student/{id}")
	@SwaggerToken
	@ApiOperation(value = "Delete", notes = "Returns 200 OK/204 NO_CONTENT", httpMethod = HttpMethod.DELETE)

	public String deleteUser(@PathVariable String id) {
		
	    log.info("Begining the Delete operation");
		

		log.info("Ending the Delete operation");
		
		return studentService.deleteParticularStudent(id);
	}

	
	/***
	 * This method getting already present student by id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/student/{id}")

	@SwaggerToken
	@ApiOperation(value = "Get by id", notes = "Returns 200 OK/204 NO_CONTENT", httpMethod = HttpMethod.GET)

	public Student getStudent(@PathVariable String id) {
		
	    log.info("Begining the Get operation");
		

		log.info("Ending the Get operation");
		

		return studentService.getParticularStudent(id);
	}

}
