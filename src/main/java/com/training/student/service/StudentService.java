/***
 * Project Name : StudentProject
 */

package com.training.student.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.student.common.SearchByDTO;
import com.training.student.common.StudentDTO;
import com.training.student.dao.StudentDao;
import com.training.student.exception.StudentServiceLayerException;
import com.training.student.model.Student;
import com.training.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


/**
 * This class is used for doing operations like save delete and get by id all ara=e calling from
 * controller
 * 
 * @author SACHIN AJITHKUMAR
 *
 */


@Slf4j
@Service
public class StudentService {

  @Autowired
  private StudentRepository repository;

  @Autowired
  private StudentDao dao;

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
      if (null != studenInDb) {
        repository.delete(studenInDb).block();
      }
      student.setStudentId(studentDto.getStudentId());
      student.setFirstName(studentDto.getFirstName());
      student.setLastName(studentDto.getLastName());
      student.setStudentAddress(studentDto.getStudentAddress());
      student.setRollNumber(studentDto.getRollNumber());
      student.setStudentDepartment(studentDto.getStudentDepartment());
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
      if (null == studentInfo) {
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
      if (null != findByIdStudent) {
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

  /***
   * Listing students based on Department and rollnumber using query
   * 
   * @param studentDTO Dto object of student
   * @return studentDto list
   */
  public List<Student> fetchStudentByQueryWithDepartmentAndRollnumber(SearchByDTO studentDTO) {

    List<Student> students = null;
    log.debug("Starting deletestudent method");
    try {

      students = dao.FetchStudentByStudentDepartmentAndRollnumber(studentDTO.getStudentDepartment(),
          studentDTO.getRollNumber());
      System.out.println(students);
      if (students.isEmpty()) {
        Flux<Student> allStudents = repository.findAll();
        students = allStudents.toStream().collect(Collectors.toList());
      }
      else {
        log.debug("ending deletestudent method");
      }
    } catch (Exception exception) {
      log.error("Exception :", exception);
    throw new StudentServiceLayerException("Exception in DeleteStudent", exception);
    }
    return students;

  }
}

