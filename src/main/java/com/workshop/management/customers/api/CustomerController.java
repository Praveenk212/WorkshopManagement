package com.workshop.management.customers.api;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workshop")
public class CustomerController {

  @Autowired
  CustomerService customerService;
  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  /**
   * insert default training data.
   */
  @PutMapping(value = "/data")
  public ResponseEntity<Object> insertDefaultData(Customer customer
  ) throws Exception {
    customerService.saveCustomer(customer);
    return new ResponseEntity<>("Default data inserted and Excel sheet filled", HttpStatus.OK);
  }

}
