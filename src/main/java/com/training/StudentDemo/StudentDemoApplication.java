
/**
 * Project Name  : StudentProject

 * 
 */





package com.training.StudentDemo;



import org.reactivestreams.Publisher;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import com.azure.data.cosmos.PartitionKey;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

/**
 * 
 * class contain main method
 * @author Hari
 *
 */
@SpringBootApplication

@EnableSwagger2

@Slf4j
public class StudentDemoApplication {


	
	/**
	 * Execution starts here
	 * @param args
	 */

    public static void main(String[] args) {
    
    	try {
        
    		SpringApplication.run(StudentDemoApplication.class, args);
    	
    	}
    	
    	catch(Exception e) {
    	
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
              
    				.apis(RequestHandlerSelectors.basePackage("com.training.StudentDemo.controller"))              
              
    				.paths(PathSelectors.any())                          
        
    				.build();                                           
        }
 
}