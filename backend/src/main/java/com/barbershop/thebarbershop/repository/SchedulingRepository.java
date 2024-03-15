package com.barbershop.thebarbershop.repository;

import com.barbershop.thebarbershop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    Scheduling getSchedulingById(Long id);
}
