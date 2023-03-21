package com.workshop.management.customers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  String message;

  @Autowired
  private CustomerRepository customerRepository;


  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;

  }

  public String getMessage(String message)
  {
    return message;
  }



  public void saveCustomer(Customer customer)
  {
    customerRepository.save(customer);
  }

}
