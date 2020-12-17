/***
 * Project Name  : StudentProject
 */

package com.ust.training.student.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.Data;

/***
 *class for Student DTO 
 * @author SACHIN AJITHKUMAR
 *
 */
@EntityScan
@Data
public class StudentDTO {

	    private String studentId;
	    private String firstName;
	    private String studentDepartment;
	    private Integer rollNumber;
	    private String lastName;
	    private String studentAddress;
}
