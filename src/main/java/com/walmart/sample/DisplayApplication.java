/**
 * Project Name  : Display
 * 
 */


package com.walmart.sample;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Execution Starts  here in the main method 
 * @author Hari
 *
 */

@SpringBootApplication
public class DisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayApplication.class, args);
		System.out.println("Hi");
	}

}
