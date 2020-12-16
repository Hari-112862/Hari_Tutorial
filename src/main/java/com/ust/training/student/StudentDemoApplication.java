/***
 * Projectname:Student project
 */

package com.ust.training.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ust.training.student.constant.IStudentPackageConstants;
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
    } catch (Exception exception) {
      log.error("Exception in Main:", exception);
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
        .apis(RequestHandlerSelectors.basePackage(IStudentPackageConstants.STUDENT_BASE_PACKAGE_CONTROLLER))
        .paths(PathSelectors.any()).build();
  }
  /***
   * Swagger url gerenation
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
      registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs");
      registry.addRedirectViewController("/documentation/configuration/ui", "/configuration/ui");
      registry.addRedirectViewController("/documentation/configuration/security", "/configuration/security");
      registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
      registry.addRedirectViewController("/documentation", "/documentation/swagger-ui.html");
      registry.addRedirectViewController("/documentation/", "/documentation/swagger-ui.html");
  }
  /***
   * Adding ResourceHandler
   * 
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/documentation/**").addResourceLocations("classpath:/META-INF/resources/");
  }


}
