/***
 * Project Name : StudentProject
 */

package com.training.student.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.training.student.common.StudentDTO;
import com.training.student.exception.StudentServiceLayerException;
import com.training.student.model.Student;
import com.training.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


/**
 * This class is used for doing operations like save delete and get by id all ara=e calling from
 * controller
 * 
 * @author SACHIN AJITHKUMAR
 *
 */

@Service
@Slf4j
@Component
public class StudentService {

  @Autowired
  private StudentRepository repository;

  /**
   * Saving Student and updating student
   * 
   * @param studentDto
   * @return Student object
   */
  public Student updateAndSaveStudent(StudentDTO studentDto) {

    Student savedUser = null;
    log.debug("Starting saveStudent method");

    try {
      Student student = new Student();
      Student studenInDb = repository.findById(studentDto.getStudentId()).block();
      if (null !=studenInDb) {
        repository.delete(studenInDb).block();
      }
        student.setStudentId(studentDto.getStudentId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setStudentAddress(studentDto.getStudentAddress());
        student.setRollNumber(studentDto.getRollNumber());
        savedUser = repository.save(student).block();
      log.debug("Ending saveStudent method");
      return savedUser;
    } catch (Exception exception) {
      log.error("Exception:", exception);
      throw new StudentServiceLayerException("Exception in Saving a Student", exception);

    }

  }

  /***
   * Getting already present student by id
   * 
   * @param id
   * @return SudentDTO object
   */
  public StudentDTO getStudent(String id) {

    StudentDTO studentDto = new StudentDTO();
    log.debug("Starting getstudent method");
    try {
      Student studentInfo = repository.findById(id).block();
      if (null==studentInfo) {
        log.debug("Ending getstudent method");
        return null;
      }
      log.debug("Ending getstudent method");
      BeanUtils.copyProperties(studentInfo, studentDto);
      return studentDto;
    } catch (Exception exception) {
      log.error("Exception:", exception);
      throw new StudentServiceLayerException("Exception in fetching student by id", exception);

    }

  }

  /***
   * Deleting already present student by id
   * 
   * @param id
   * @return String
   */

  public String deleteStudent(String id) {

    log.debug("Starting deletestudent method");
    try {
      Student findByIdStudent = repository.findById(id).block();
      if(null != findByIdStudent) {
      repository.delete(findByIdStudent).block();
      log.debug("ending deletestudent method");
      return "Deleted";
      }
      return null;
    } catch (Exception exception) {
      log.error("Exception :", exception);
      throw new StudentServiceLayerException("Exception in DeleteStudent", exception);

    }

  }

}
