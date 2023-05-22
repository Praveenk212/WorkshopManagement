package com.workshop.management.workshops.service;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopsService {

  String message;

  @Autowired
  private CustomerRepository customerRepository;


  public WorkshopsService(CustomerRepository customerRepository) {
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
