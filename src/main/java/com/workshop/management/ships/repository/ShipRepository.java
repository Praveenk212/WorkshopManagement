package com.workshop.management.ships.repository;

import com.workshop.management.ships.entity.Ship;
import com.workshop.management.workshops.entity.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {


}

