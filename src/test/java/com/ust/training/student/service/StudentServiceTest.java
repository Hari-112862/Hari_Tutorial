/***
 * Project Name : Student
 */

package com.ust.training.student.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.ust.training.student.common.CriteriaSearchDTO;
import com.ust.training.student.common.StudentDTO;
import com.ust.training.student.dao.StudentDao;
import com.ust.training.student.exception.StudentServiceException;
import com.ust.training.student.model.Student;
import com.ust.training.student.repository.IStudentRepository;
import reactor.core.publisher.Mono;

@RunWith(JUnit4.class)
/***
 * Test class for student Service.
 * 
 * @author SACHIN AJITHKUMAR
 *
 */
public class StudentServiceTest {
  
  @Mock
  private IStudentRepository repository;
  @Mock
  private StudentDao dao;
  @InjectMocks
  private StudentService studentService;
  /***
   * Method need to execute at first before all test cases
   */
  @Before
  public void setup() throws Exception
  {
  MockitoAnnotations.initMocks(this);

  }
  
  /**
   * Test for {@link StudentService#fetchStudent)}} with no content as response
   * 
   * @throws Exception
   */

  
  @Test
  public void testGetStudentDetailsWithNull() {
    Mono<Student> st = Mono.empty();
    Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(st);
    StudentDTO student = studentService.fetchStudent("1");
    assertEquals(null,student);
  }
  
  /**
   * Test for {@link  StudentService#fetchStudent)}} with Success response
   * 
   * @throws Exception
   */

  
  @Test
  public void testGetStudentDetailsWithId() {
    Student student = new Student();
    student.setStudentId("1");
    Mono<Student> studentMono = Mono.just(student);
    Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(studentMono);
    StudentDTO studentDto = studentService.fetchStudent("1");
    assertNotNull(studentMono);
    assertEquals(studentDto.getStudentId(), "1");
  }
  
  /**
   * Test for {@link  StudentService#fetchStudent)}} with exception response
   * 
   * @throws Exception
   */

  
  @Test(expected = StudentServiceException.class)
  public void testGetStudentDetailsWithException() {
    Mockito.when(repository.findById(Mockito.any(String.class))).thenThrow(new IllegalArgumentException());
    studentService.fetchStudent("1");
  }
  
  /**
   * Test for {@link  StudentService#deleteStudent)}} with null response
   * 
   * @throws Exception
   */

  
  @Test
  public void testDeleteStudentByIdWithNull() {
    Mono<Student> studentMono = Mono.empty();
    Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(studentMono);
    Student student = studentService.deleteStudent("1");
    assertEquals(null,student);
    
    
  }
  

  /**
   * Test for {@link  StudentService#deleteStudent)}} with success response
   * 
   * @throws Exception
   */
  @Test
  public void testDeleteStudentByIdWithData() {
    Mono<Void> studentMono = Mono.empty();
    Student student = new Student();
    student.setStudentId("1");
    Mono<Student> studentM = Mono.just(student);
    Mockito.when(repository.findById(Mockito.any(String.class))).thenReturn(studentM);
    Mockito.when(repository.delete(Mockito.any(Student.class))).thenReturn(studentMono);
    Student studentReturn =studentService.deleteStudent("1");
    assertNotNull(studentReturn);  
    assertEquals(studentReturn.getStudentId(), "1");
  }
  

  /**
   * Test for {@link  StudentService#deleteStudent)}} with exception as response
   * 
   * @throws Exception
   */
  @Test(expected = StudentServiceException.class)
  public void testDeleteStudentIdWithException() {
    Mockito.when(repository.findById(Mockito.any(String.class))).thenThrow(new IllegalArgumentException());
    studentService.deleteStudent("1");
  }

  /**
   * Test for {@link  StudentService#fetchStudentByCriteria)}} with null response
   * 
   * @throws Exception
   */
  @Test
  public void testFetchStudentCriteriaWithNull() {
    
    CriteriaSearchDTO studentDTO = new CriteriaSearchDTO();
    studentDTO.setRollNumber(1);
    studentDTO.setStudentDepartment("Ind");
    Mockito.when(dao.FetchStudentByStudentDepartmentAndRollnumber(Mockito.any(String.class),Mockito.any(Integer.class))).thenReturn(null);
    List<Student> list=studentService.fetchStudentByCriteria(studentDTO);
    assertNull(list);
  }
  

  /**
   * Test for {@link  StudentService#fetchStudentByCriteria)}} with Success response
   * 
   * @throws Exception
   */
  @Test
  public void testFetchStudentCriteriaWithData()
  {
    List <Student> returnList = new ArrayList<Student>();
    Student studentObject = new Student();
    studentObject.setFirstName("Hari");
    returnList.add(studentObject);
    CriteriaSearchDTO studentDTO = new CriteriaSearchDTO();
    studentDTO.setRollNumber(1);
    studentDTO.setStudentDepartment("Ind");
    Mockito.when(dao.FetchStudentByStudentDepartmentAndRollnumber(Mockito.any(String.class),Mockito.any(Integer.class))).thenReturn(returnList);
    List<Student> list=studentService.fetchStudentByCriteria(studentDTO);
    assertNotNull(list); 
    assertEquals(list.get(0).getFirstName(),"Hari");
  }

  /**
   * Test for {@link  StudentService#fetchStudentByCriteria)}} with exception as  response
   * 
   * @throws Exception
   */
  
  @Test(expected = StudentServiceException.class)
  public void testFetchByCriteriaWithException() {
    
    CriteriaSearchDTO studentDTO = new CriteriaSearchDTO();
    studentDTO.setRollNumber(1);
    studentDTO.setStudentDepartment("Ind");
    Mockito.when(dao.FetchStudentByStudentDepartmentAndRollnumber(Mockito.any(String.class),Mockito.any(Integer.class))).thenThrow(new IllegalArgumentException());
    studentService.fetchStudentByCriteria(studentDTO);
  }
  
}