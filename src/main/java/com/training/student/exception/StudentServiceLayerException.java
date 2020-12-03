/***
 * Project Name  : StudentProject
 */

package com.training.student.exception;

/**
 * Exception handling class for StudentService
 * @author SACHIN AJITHKUMAR
 *
 */

public class StudentServiceLayerException extends RuntimeException {
	
	private static final long serialVersionUID = 2853146757927156650L;

	public StudentServiceLayerException(String message) {
		super(message);
	}

	public StudentServiceLayerException(String message, Throwable throwable) {
		super(message, throwable);

}

}