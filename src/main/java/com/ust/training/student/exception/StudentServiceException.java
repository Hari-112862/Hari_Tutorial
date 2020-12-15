/***
 * Project Name  : StudentProject
 */

package com.ust.training.student.exception;

/**
 * Exception handling class for StudentService
 * @author SACHIN AJITHKUMAR
 *
 */
public class StudentServiceException extends RuntimeException {
	private static final long serialVersionUID = 2853146757927156650L;
/**
 * 
 * one parameter constructor for exception
 */
	public StudentServiceException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * Two parameter constructor for exception
	 */
	public StudentServiceException(String message, Throwable throwable) {
		super(message, throwable);
}
}