/***
 * Project Name : Student
 */

package com.ust.training.student.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.training.student.common.CriteriaSearchDTO;
import com.ust.training.student.common.StudentDTO;
import com.ust.training.student.model.Student;
import com.ust.training.student.service.StudentService;
@RunWith(JUnit4.class)
/***
 * Test class for student controller.
 * @author SACHIN AJITHKUMAR
 *
 */
public class StudentControllerTest {

  @Mock
  StudentService studentService; 
  @InjectMocks
  StudentController studentController;
  String request=null;
  StudentDTO studentDTORequest = new StudentDTO();
  Student studentResponse=new Student(); 
  CriteriaSearchDTO criteriaSearchDTO = new CriteriaSearchDTO();
  ObjectMapper mapper = new ObjectMapper();
  RequestBuilder requestBuilder =null;
  MvcResult result=null;
  List<Student> students =new ArrayList<Student>();
  MockMvc mockMvc;

  /***
   * Method need to execute at first before all test cases
   */
@BeforeClass
public static void beforZeClass() {
  System.out.println("BEFORE");
}
  
/***
 * Method which is executing just before each test cases
 */
@Before
  public void setup()
  {
  MockitoAnnotations.initMocks(this);
  mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    System.out.println("before");
  }

/**
 * Test for {@link StudentController#saveStudent(StudentDTO)}} with no content as response
 * @throws Exception
 */

@Test

public void testSavetudentWithNoContent() throws Exception {
  studentDTORequest.setFirstName("Hari");
  studentDTORequest.setStudentId("1");
  request  = mapper.writeValueAsString(studentDTORequest);
  Mockito.when(studentService.updateAndSaveStudent(Mockito.any(StudentDTO.class))).thenReturn(null);
  requestBuilder = MockMvcRequestBuilders.post("/save").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);
  result = mockMvc.perform(requestBuilder).andReturn();
  assertEquals(result.getResponse().getStatus(),204);
}

/**
 *  Test for {@link StudentController#saveStudent(StudentDTO)}} with Success response
 * @throws Exception
 */

  @Test
  
  public void testSavetudentWithSuccess() throws Exception {
  studentResponse.setFirstName("Hari");  
  studentResponse.setStudentId("1"); 
  studentDTORequest.setFirstName("Hari");
  studentDTORequest.setStudentId("1");
  request = mapper.writeValueAsString(studentDTORequest);
  Mockito.when(studentService.updateAndSaveStudent(Mockito.any(StudentDTO.class))).thenReturn(studentResponse);
  requestBuilder =MockMvcRequestBuilders.post("/save").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);
  result = mockMvc.perform(requestBuilder).andReturn();
  assertEquals(result.getResponse().getStatus(),200);

  }
  /**
   * Test for {@link StudentController#deleteStudent(String)}} with no content
   * @throws Exception
   */
  
  @Test
  public void testDeleteStudentDetailsWithNoContent() throws Exception{
    request = "1";
    Mockito.when(studentService.deleteStudent(Mockito.any(String.class))).thenReturn(null);
    requestBuilder = MockMvcRequestBuilders.delete("/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),204);
  }
  /**
   * Test for {@link StudentController#deleteStudent(String)}} with Success response
   * @throws Exception
   */
  @Test
  public void testDeleteStudentDetailsWithSuccess() throws Exception{
    studentResponse.setFirstName("Hari");
    studentResponse.setRollNumber(1);
    request = "1";
    Mockito.when(studentService.deleteStudent(Mockito.any(String.class))).thenReturn(studentResponse);
    requestBuilder = MockMvcRequestBuilders.delete("/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),200);
  }
 
  /**
   * Test for {@link StudentController#fetchStudent(String)}} with no content
   * @throws Exception
   */
  @Test
  public void testGetStudentDetailsWithNoContent() throws Exception{
    request = "1";
    Mockito.when(studentService.fetchStudent(Mockito.any(String.class))).thenReturn(null);
    requestBuilder =MockMvcRequestBuilders.get("/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request); 
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),204);
  }
  /**
   * Test for {@link StudentController#fetchStudent(String)}} with Success response
   * @throws Exception
   */
  @Test
  public void testGetStudentDetailsWithSuccess() throws Exception{
    studentDTORequest.setFirstName("Hari");
    studentDTORequest.setRollNumber(1);
    request = "1";
    Mockito.when(studentService.fetchStudent(Mockito.any(String.class))).thenReturn(studentDTORequest);
    requestBuilder =MockMvcRequestBuilders.get("/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request); 
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),200);
  }
  /**
   * Test for {@link StudentController#fetchStudentByCriteria(CriteriaSearchDTO)}} with no Content
   * @throws Exception
   */
  @Test
  public void testSearchStudentByCriteriaWithNoContent() throws Exception{
    criteriaSearchDTO.setRollNumber(1);
    criteriaSearchDTO.setStudentDepartment("cs");
    request=mapper.writeValueAsString(criteriaSearchDTO);
    Mockito.when(studentService.fetchStudentByCriteria(Mockito.any(CriteriaSearchDTO .class))).thenReturn(null);
    requestBuilder =MockMvcRequestBuilders.post("/search").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);  
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),204);
  }
  /**
   * Test for {@link StudentController#fetchStudentByCriteria(CriteriaSearchDTO)}} with Success response
   * @throws Exception
   */
  @Test
  public void testSearchStudentByCriteriaWithSuccess() throws Exception{
    criteriaSearchDTO.setRollNumber(1);
    criteriaSearchDTO.setStudentDepartment("cs"); 
    students.add(studentResponse);
    request=mapper.writeValueAsString(criteriaSearchDTO);
    Mockito.when(studentService.fetchStudentByCriteria(Mockito.any(CriteriaSearchDTO.class))).thenReturn(students);
    requestBuilder =MockMvcRequestBuilders.post("/search").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(request);  
    result = mockMvc.perform(requestBuilder).andReturn();
    assertEquals(result.getResponse().getStatus(),200);
  }
 


}
