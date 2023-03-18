package com.workshop.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main Application Class.
 */
@SpringBootApplication
public class Application {

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
