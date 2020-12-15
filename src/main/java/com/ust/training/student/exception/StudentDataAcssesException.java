/***
 * Project : Student
 */
package com.ust.training.student.exception;

/***
 * Exception for Dao
 * @author SACHIN AJITHKUMAR
 *
 */
public class StudentDataAcssesException extends  RuntimeException {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   * one parameter constructor for exception
   */  
      public StudentDataAcssesException(String message) {
          super(message);
      }
      
      /**
       * 
       * Two parameter constructor for exception
       */
      public StudentDataAcssesException(String message, Throwable throwable) {
          super(message, throwable);
  }
}
