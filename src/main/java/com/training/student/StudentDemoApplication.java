/***
 * Projectname:Student project
 */

package com.training.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * class contain main method
 * 
 * @author Hari
 *
 */
@SpringBootApplication
@EnableSwagger2
@Slf4j
public class StudentDemoApplication implements WebMvcConfigurer {

  /**
   * Execution starts here
   * 
   * @param args
   */

  public static void main(String[] args) {

    try {
      log.debug("main method starts");
      SpringApplication.run(StudentDemoApplication.class, args);
    } catch (Exception e) {
      log.error("Exception:", e);
    }
  }

  /**
   * Docker Api method pointing to base package
   * 
   * @return
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.training.student.controller"))
        .paths(PathSelectors.any()).build();
  }

}
