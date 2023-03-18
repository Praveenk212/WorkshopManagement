package com.workshop.management.ships.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ship")
public class ShipController {

  @Autowired
  public ShipController() {
  }

  /**
   * insert default training data.
   */
  @PostMapping(value = "/data")
  public ResponseEntity<Object> insertDefaultData(
  ) throws Exception {

    return new ResponseEntity<>("Default data inserted and Excel sheet filled", HttpStatus.OK);
  }

}
