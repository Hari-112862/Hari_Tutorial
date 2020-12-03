/***
 * Project : Student Project
 */

package com.training.StudentDemo.repoimpl;

import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.StudentDemo.StudentDemoApplication;
import com.training.StudentDemo.Model.Student;
import com.training.StudentDemo.Repository.StudentRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***
 * This class contain logical implementation of delete,post and get mapping
 * methods
 * 
 * @author SACHIN AJITHKUMAR
 *
 */
@Service

@Slf4j
public class StudentDemoRepoImplementation {

	@Autowired
	private StudentRepository repository;

	/***
	 * Saving Student and updating student
	 * 
	 * @param user
	 * @return
	 */
	public String updateAndSaveStudent(Student user) {

		log.info("Starting saveStudent method");

		try {
			Student student = new Student();

			String postStatus = "saveValue";

			Flux<Student> list = repository.findAll();

			List<Student> list1 = list.collectList().block();

			Iterator<Student> it = list1.iterator();

			while (it.hasNext()) {

				Student student1 = it.next();

				if (user.getStudentId().equals(student1.getStudentId())) {

					repository.delete(student1).block();

					student.setStudentId(user.getStudentId());

					student.setFirstName(user.getFirstName());

					student.setLastName(user.getLastName());

					student.setStudentAddress(user.getStudentAddress());

					student.setRollNumber(user.getRollNumber());

					Mono<Student> saveUserMono = repository.save(student);

					Student savedUser = saveUserMono.block();

					postStatus = "Updated";

				}
			}

			if (postStatus.equalsIgnoreCase("saveValue")) {

				student.setStudentId(user.getStudentId());

				student.setFirstName(user.getFirstName());

				student.setLastName(user.getLastName());

				student.setStudentAddress(user.getStudentAddress());

				student.setRollNumber(user.getRollNumber());

				Mono<Student> saveUserMono = repository.save(student);

				Student savedUser = saveUserMono.block();

			}
		} 
		catch (Exception e) {

			log.error("Exception:", e);

		}

		log.info("Ending saveStudent method");

		return "Sucsses";

	}

	/***
	 * Getting already present student by id
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudent(String id) {
		
		log.info("Starting getstudent method");
	 
		try {

			Mono<Student> findByIdMono = repository.findById(id);

			Student findByIdUser = findByIdMono.block();

			log.info("Ending getstudent method");

			return findByIdUser;

		} catch (Exception e) {

			log.error("Exception:", e);
		}

		return null;
	}

	/***
	 * Deleting already present student by id
	 * 
	 * @param id
	 * @return
	 */

	public String deleteStudent(String id) {

		log.info("Starting deletestudent method");
		try {
		

		Mono<Student> findByIdMono = repository.findById(id);

		Student findByIdUser = findByIdMono.block();

		repository.delete(findByIdUser).block();

		log.info("Starting deletestudent method");
		}
		catch (Exception e) {
			
			log.error("Exception :",e);
		}
		

		return "Deleted";
	}

}
