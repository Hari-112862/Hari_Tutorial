
/**
 * Project Name  : StudentProject

 * 
 */

package com.training.StudentDemo.Model;



import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.Data;


/***
 * Pojo class for student
 * @author SACHIN AJITHKUMAR
 *
 */
@Document(collection = "studentDb")
@Data
@Service
public class Student {

	
	
    @Id
    private String studentId;
    private String firstName;
    private String studentDepartment;
    private int rollNumber;
 
    @PartitionKey
    private String lastName;
    private String studentAddress;
  

  
}