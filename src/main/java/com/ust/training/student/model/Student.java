/***
 * Project Name  : StudentProject
 */
package com.ust.training.student.model;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.ust.training.student.constant.IStudentDbConstants;
import lombok.Data;

/**
 * Entity class for student
 * @author SACHIN AJITHKUMAR
 *
 */
@Container(containerName = IStudentDbConstants.COLLECTION_NAME)
@Data
public class Student {	
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String studentAddress;

 
    @PartitionKey
    private String studentDepartment;
    private Integer rollNumber; 
}