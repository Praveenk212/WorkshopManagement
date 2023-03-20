package com.workshop.management;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.ships.entity.Ship;
import com.workshop.management.workshops.entity.MaintenanceJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Main Application Class.
 */
@SpringBootApplication
@Import({Customer.class, Ship.class, MaintenanceJob.class})
public class Application extends SpringBootServletInitializer {


  @Bean
  public Customer customerBean() {
    return new Customer();
  }

  @Bean
  public Ship shipBean() {
    return new Ship();
  }

  @Bean
  public MaintenanceJob maintenanceJobBean() {
    return new MaintenanceJob();
  }

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
