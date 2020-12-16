package com.ust.training.student.constant;

public interface ISqlQueryConstants {
  
 String BASE_QUERY                               = "select * from studentDb where 1=1  "; 
 String DEPARTMENT_CRITERIA                      = " and studentDb.studentDepartment=@studentDepartment" ;
 String  ROLL_NUMBER_CRITERIA                    = " and studentDb.rollNumber=@rollNumber";
 String DATABASE_PARAM_STUDENT_DEPARTMENT        ="@studentDepartment";
 String DATABASE_PARAM_STUDENT_ROLLNUMBERT       ="@rollNumber";
}
