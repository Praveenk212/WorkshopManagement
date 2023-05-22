package com.workshop.management.ships.entity;

import com.workshop.management.customers.entity.Customer;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "ship")
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


  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "owner_id", referencedColumnName = "customer_id")
  private Customer customer;

  public Ship(String imonumber, String brand, String type) {
    this.imonumber = imonumber;
    this.brand = brand;
    this.type = type;
  }

  public Integer getOwnerId() {
    return ownerId;
  }

  public String getImonumber() {
    return imonumber;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public Integer getCustomer() {
    if(this.customer!=null)
      return customer.getCustomerId();
    else
      return null;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public void setImonumber(String imonumber) {
    this.imonumber = imonumber;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Ship() {
  }
}