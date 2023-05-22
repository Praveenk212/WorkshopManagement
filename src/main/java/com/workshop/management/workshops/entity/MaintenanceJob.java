package com.workshop.management.workshops.entity;

import com.workshop.management.ships.entity.Ship;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@Table(name = "maintenance_job")
public class MaintenanceJob implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "start_time")
  private Date startTime;

  @Column(name = "end_time")
  private Date endTime;

  @Column(name = "description",columnDefinition = "TEXT")
  private String description;

  @Column(name = "actual_start_time")
  private Date actualStartTime;

  @Column(name = "actual_end_time")
  private Date actualEndTime;

  @Column(name = "notes")
  private String notes;

  @Column(name = "status")
  private String status;

  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "ownerId", referencedColumnName = "owner_id")
  private Ship ship;

  public MaintenanceJob(Date startTime, Date endTime, String description, Date actualStartTime, Date actualEndTime, String notes, String status) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.description = description;
    this.actualStartTime = actualStartTime;
    this.actualEndTime = actualEndTime;
    this.notes = notes;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getActualStartTime() {
    return actualStartTime;
  }

  public void setActualStartTime(Date actualStartTime) {
    this.actualStartTime = actualStartTime;
  }

  public Date getActualEndTime() {
    return actualEndTime;
  }

  public void setActualEndTime(Date actualEndTime) {
    this.actualEndTime = actualEndTime;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getShip() {
    if(this.ship!=null)
      return ship.getOwnerId();
    else
      return null;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public MaintenanceJob() {
  }
}