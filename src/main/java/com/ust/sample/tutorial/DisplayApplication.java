/**
 * Project Name  : Display
 * 
 */


package com.ust.sample.tutorial;

import org.slf4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




/**
 * 
 * class contain main metthod
 * @author Hari
 *
 */

@SpringBootApplication

@EnableSwagger2

@Slf4j
public class DisplayApplication {

	
	/**
	 * Execution starts here
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
		
		SpringApplication.run(DisplayApplication.class, args);
		log.info("Inside Main");
		
		}
		catch (Exception e) {
			log.error("Exception:", e);
		}

	}
	
/**
 * Docker Api method pointing to base package
 * @return
 */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.ust.sample.tutorial.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
		
	
}
