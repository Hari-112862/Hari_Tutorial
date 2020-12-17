/***
 * Project Name  : StudentProject
 */
package com.ust.training.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.ust.training.student.constant.ISqlQueryConstants;
import lombok.Data;

/**
 * Entity class for student
 * @author SACHIN AJITHKUMAR
 *
 */
@Container(containerName = ISqlQueryConstants.COLLECTION_NAME)
@Data
public class Student {
  
    @Id
    private String studentId;
    @NotNull
    @Size(min = 2, message="atleast 2 charecter")
    private String firstName;
    private String lastName;
    private String studentAddress;

 
    @PartitionKey
    private String studentDepartment;
    private Integer rollNumber; 
}