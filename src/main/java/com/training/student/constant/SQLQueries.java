/***
 * Project : Student
 */


package com.training.student.constant;
/***
 * Query Constants
 * @author SACHIN AJITHKUMAR
 *
 */
public class SQLQueries {

	public static String BASE_QUERY = "select * from studentDb where 1=1  "; 
	public static String DEPARTMENT_CRITERIA = " and studentDb.studentDepartment=@studentDepartment" ;
	public static String  ROLL_NUMBER_CRITERIA = " and studentDb.rollNumber=@rollNumber";
	public static String DEPARTMENT_OR_CRITERIA = " or studentDb.studentDepartment=@studentDepartment" ;

}
 