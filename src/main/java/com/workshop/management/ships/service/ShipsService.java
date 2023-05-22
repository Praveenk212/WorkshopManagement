package com.workshop.management.ships.service;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipsService {

  String message;

  @Autowired
  private CustomerRepository customerRepository;


  public ShipsService(CustomerRepository customerRepository) {
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
