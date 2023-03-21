package com.workshop.management.ships.entity;

import com.workshop.management.customers.entity.Customer;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ship", schema = "workshop")
public class Ship implements Serializable {

  @Column(name = "owner_id")
  @Id
  private Integer ownerId;

  @Column(name = "imonumber")
  private String imonumber;

  @Column(name = "brand")
  private String brand;

  @Column(name = "type")
  private String type;


  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "owner_id", referencedColumnName = "customer_id")
  private Customer customer;


}