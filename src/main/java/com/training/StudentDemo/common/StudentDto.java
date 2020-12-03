
/**
 * Project Name  : StudentProject

 * 
 */


package com.training.StudentDemo.common;

import org.springframework.data.annotation.Id;


import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import com.training.StudentDemo.Model.Student;

import lombok.Data;

/***
 * Temporary class for pojo 
 * @author SACHIN AJITHKUMAR
 *
 */

@Data
public class StudentDto {
	
	  @Id
	    private String studentId;
	    private String firstName;
	    private String studentDepartment;
	    private int rollNumber;
	 
	    @PartitionKey
	    private String lastName;
	    private String studentAddress;
	  


}
