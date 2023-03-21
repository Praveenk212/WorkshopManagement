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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_job", schema = "workshop")
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

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
  private Ship ship;

}