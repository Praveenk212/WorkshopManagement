package com.workshop.management.customers.configuration;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.ships.entity.Ship;
import com.workshop.management.workshops.entity.MaintenanceJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    Customer customerBean() {
        return new Customer();
    }

    @Bean
    Ship shipBean() {
        return new Ship();
    }

    @Bean
    MaintenanceJob maintenanceJobBean() {
        return new MaintenanceJob();
    }

}