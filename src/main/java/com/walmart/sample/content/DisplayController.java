/**
 * Project Name  : Display
 * 
 */


package com.walmart.sample.content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.sample.model.Message;
import com.walmart.sample.model.Person;

/**
 * DisplayContoller Class contain post method and post method is used for returning Message class object
 * @author Hari
 *
 */
@RestController
public class DisplayController {

private static Logger logger = LoggerFactory.getLogger(DisplayController.class);
	

/**
 * newMessage is a post method which is used for accepting the person object and returning the message 
 */

	@PostMapping("/hello")
	public Message newMessage(@RequestBody Person person){

		logger.debug("Begining the Post operation");

		Message responseMessage = new Message();
		
		responseMessage.setMessage("Hey "+person.getName());
		
		logger.debug("Ending Post operation");
		
		return responseMessage ;
		
		
	}
	
}
