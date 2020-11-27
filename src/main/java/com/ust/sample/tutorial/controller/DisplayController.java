/**
 * Project Name  : Display
 * 
 */


package com.ust.sample.tutorial.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


import javax.ws.rs.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.sample.tutorial.controller.annotation.SwaggerToken;
import com.ust.sample.tutorial.model.Message;
import com.ust.sample.tutorial.model.Person;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * DisplayContoller Class contain post method and post method is used for returning Message class object
 * @author Hari
 *
 */
@RestController

@Slf4j

public class DisplayController {


	

/**
 * newMessage is a post method which is used for accepting the person object and returning the message 
 */

	@PostMapping("/hello")
	
	@SwaggerToken
	
	@ApiOperation(value = "Showing message", notes = "Returns 200 OK/204 NO_CONTENT",httpMethod = HttpMethod.POST)

	public ResponseEntity<Message> newMessage(@RequestBody Person person){

		log.info("Begining the Post operation");

		Message responseMessage = new Message();
		
		responseMessage.setWelcomeMessage("Hey "+person.getPersonName());
	
		log.info("Ending Post operation");
			
		return ResponseEntity.ok(responseMessage) ;
		
		
	}
	
}
