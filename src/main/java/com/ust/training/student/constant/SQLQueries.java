/***
 * Project : Student
 */


package com.ust.training.student.constant;
/***
 * Query Constants
 * @author SACHIN AJITHKUMAR
 *
 */
public class SQLQueries {

  /***
   * Default constructor
   */
  private SQLQueries() {
    
  }
	public static String BASE_QUERY               = "select * from studentDb where 1=1  "; 
	public static String DEPARTMENT_CRITERIA      = " and studentDb.studentDepartment=@studentDepartment" ;
	public static String  ROLL_NUMBER_CRITERIA    = " and studentDb.rollNumber=@rollNumber";
	public static final String DATABASE_PARAM_STUDENT_DEPARTMENT  ="@studentDepartment";
    public static final String DATABASE_PARAM_STUDENT_ROLLNUMBERT ="@rollNumber";
}
 