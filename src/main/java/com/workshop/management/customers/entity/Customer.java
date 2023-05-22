package com.workshop.management.customers.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "customers")
public class Customer implements Serializable {

  public Customer() {
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "name")
  private String name;

  public Customer( String name, String address, String postalCode, String city, String telephoneNumber, String emailAddress) {
    this.name = name;
    this.address = address;
    this.postalCode = postalCode;
    this.city = city;
    this.telephoneNumber = telephoneNumber;
    this.emailAddress = emailAddress;
  }

  @Column(name = "address",columnDefinition = "TEXT")
  private String address;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "city")
  private String city;

  @Column(name = "telephone_number")
  private String telephoneNumber;

  @Column(name = "email_address")
  private String emailAddress;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", postalCode='" + postalCode + '\'' +
            ", city='" + city + '\'' +
            ", telephoneNumber='" + telephoneNumber + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            '}';
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}