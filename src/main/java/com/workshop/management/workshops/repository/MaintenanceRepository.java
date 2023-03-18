package com.workshop.management.workshops.repository;

import com.workshop.management.workshops.entity.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceJob, Integer> {


}

