package com.workshop.management.customers.configuration;

import com.workshop.management.customers.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    Customer customerBean() {
        return new Customer();
    }


}