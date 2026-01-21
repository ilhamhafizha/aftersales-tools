package com.aftersales.aftersalestools.repository;

import com.aftersales.aftersalestools.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository
        extends JpaRepository<Technician, Long> {
}

