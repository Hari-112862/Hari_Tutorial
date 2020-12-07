/***
 * Projectname:Student project
 */

package com.training.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.training.student.constant.StudentConstants;
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
public class StudentDemoApplication {

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
        .apis(RequestHandlerSelectors.basePackage(StudentConstants.STUDENT_BASE_PACKAGE))
        .paths(PathSelectors.any()).build();
  }

}
