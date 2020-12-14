/***
 * Project Name  : StudentProject
 */
package com.training.student.model;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;


/**
 * Entity class for student
 * @author SACHIN AJITHKUMAR
 *
 */
@Container(containerName = "studentDb")
@Data
public class Student {

	
	
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String studentAddress;

 
    @com.azure.spring.data.cosmos.core.mapping.PartitionKey
 
    private String studentDepartment;
    private int rollNumber;
  

  
}