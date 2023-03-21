package com.workshop.management;

import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main Application Class.
 */
@SpringBootApplication
@CssImport(value = "./styles/center.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css")
public class Application extends SpringBootServletInitializer {

  /**
   * Starts the application.
   *
   * @param args program arguments.
   */
  public static void main(final String[] args) {
    SpringApplication springApplication = new SpringApplication(Application.class);
    springApplication.run(args);
  }

}
