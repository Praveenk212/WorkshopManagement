package com.workshop.management.customers.model;

import com.workshop.management.ships.entity.Ship;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Customer implements Serializable {

  private Integer customerId;

  private String name;

  private String address;

  private String postalCode;

  private String city;

  private String telephoneNumber;

  private String emailAddress;

}