/***
 * Project : Student
 */
package com.training.student.mapper;

import org.springframework.stereotype.Component;
import com.training.student.model.Student;
/***
 * Mapping class of student
 * @author SACHIN AJITHKUMAR
 *
 */
@Component
public class StudentMapper {
/***
 * MApping method
 * @param student
 * @return Student Object
 */
	public Student mapStudentDetail(Student student) {
		Student studentObject = student;
		return studentObject;
	}

}
