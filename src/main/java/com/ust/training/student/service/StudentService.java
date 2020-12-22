/***
 * Project Name : StudentProject
 */

package com.ust.training.student.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.training.student.common.CriteriaSearchDTO;
import com.ust.training.student.common.StudentDTO;
import com.ust.training.student.dao.StudentDao;
import com.ust.training.student.exception.StudentServiceException;
import com.ust.training.student.model.Student;
import com.ust.training.student.repository.IStudentRepository;
import lombok.extern.slf4j.Slf4j;

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
  private IStudentRepository repository;

  @Autowired
  private StudentDao dao;

  /**
   * Saving Student and updating student
   * 
   * @param studentDto
   * @return Student object
   */
  public Student updateAndSaveStudent(StudentDTO studentDto) {

    log.debug("Starting saveStudent method");
    Student savedUser = null;
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
      log.error("Exception Occured in updateAndSaveStudent method:", exception);
      throw new StudentServiceException("Exception in Saving a Student", exception);

    }

  }

  /***
   * Getting already present student by id
   * 
   * @param id
   * @return SudentDTO object
   */
  public StudentDTO fetchStudent(String id) {

    log.debug("Starting fetchstudent method by id");
    StudentDTO studentDto = new StudentDTO();
    try {
      Student studentInfo = repository.findById(id).block();
      if (null == studentInfo) {
        log.debug("Ending fetchstudent method");
        return null;
      }
      BeanUtils.copyProperties(studentInfo, studentDto);
      log.debug("Ending fetchstudent method by id");
      return studentDto;
    } catch (Exception exception) {
      log.error("Exception occured in fetchStudent:", exception);
      throw new StudentServiceException("Exception in fetching student by id", exception);

    }

  }
  /***
   * Deleting already present student by id
   * 
   * @param id
   * @return String
   */
  public Student deleteStudent(String id) {
    log.info("Starting deletestudent method");
    Student FetchStudentById = null;
    try {
      FetchStudentById = repository.findById(id).block();
      if (null != FetchStudentById) {
        log.info("inside if");
        repository.delete(FetchStudentById).block();
      }
      log.info("ending deletestudent method");
      System.out.println("Delete thd status"+FetchStudentById);
      return FetchStudentById;
    } catch (Exception exception) {
      log.error("Exception occured in deleteStudent method:", exception);
      throw new StudentServiceException("Exception in DeleteStudent", exception);
    }
  }

  /***
   * Listing students based on Department and rollnumber using query
   * 
   * @param studentDTO Dto object of student
   * @return studentDto list
   */
  public List<Student> fetchStudentByCriteria(
      CriteriaSearchDTO studentDTO) {

    log.debug("Starting fetchStudentByQueryWithDepartmentAndRollnumber method in service");
    List<Student> students = null;
    try {
      students = dao.FetchStudentByStudentDepartmentAndRollnumber(studentDTO.getStudentDepartment(),
          studentDTO.getRollNumber());
    } catch (Exception exception) {
      log.error("Exception occured in fetchStudentByQueryWithDepartmentAndRollnumber method:",
          exception);
      throw new StudentServiceException("Exception in DeleteStudent", exception);
    }
    log.debug("Starting fetchStudentByQueryWithDepartmentAndRollnumber method in service");
    return students;

  }
}

