/**
 * Project Name  : StudentProject


 * 
 */



package com.training.StudentDemo.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.azure.data.cosmos.PartitionKey;
import com.training.StudentDemo.StudentDemoApplication;
import com.training.StudentDemo.Model.Student;
import com.training.StudentDemo.Repository.StudentRepository;
import com.training.StudentDemo.common.StudentDto;
import com.training.StudentDemo.repoimpl.StudentDemoRepoImplementation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

@Slf4j

/***
 * This class is used for calling allStudentDemorepoimplementation  implementation methods
 * @author SACHIN AJITHKUMAR
 *
 */


public class StudentService {
	
	
	@Autowired
	StudentDemoRepoImplementation studentDemoRepoImplementation ;

	

/***
 * Calling StudentDemorepoimplementation class savestudent method for saving and update the student
 * @param studentDto
 * @return
 */
	public String saveAndUpdateStudent (StudentDto studentDto) {
	
		log.info("Starting save and update method");
		
		Student student = new Student();
		
		BeanUtils.copyProperties(studentDto,student);

		log.info("Ending save and update method");
		
		return  studentDemoRepoImplementation.updateAndSaveStudent(student);
		
	}

	/***
	 * Calling StudentDemorepoimplementation  class getstudent method for getting already presenting student
	 * @param id
	 * @return
	 */
	
	public Student getParticularStudent(String id) {

		log.info("Starting  getParticularStudentmethod");

		log.info("Ending  getParticularStudent method");
		
		return  studentDemoRepoImplementation.getStudent(id);
	}
	
	/***
	 * Calling StudentDemorepoimplementation  class deletestudent method for delete by id
	 * @param id
	 * @return
	 */

	public String deleteParticularStudent(String id) {
		
		log.info("Starting   deleteParticularStudent method");
		
		log.info("Ending   deleteParticularStudent method");
		
		return  studentDemoRepoImplementation.deleteStudent(id);
	}

}
