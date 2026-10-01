package com.donatrack.logistica.application.port.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donatrack.logistica.domain.model.Camion;
    
@Repository
public interface CamionRepository
        extends JpaRepository<Camion, Long> {
}

