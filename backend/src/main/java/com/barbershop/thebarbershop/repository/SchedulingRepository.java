package com.barbershop.thebarbershop.repository;

import com.barbershop.thebarbershop.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    Scheduling getSchedulingById(Long id);
    List<Scheduling> getSchedulingByClientPhoneNumber(String clientPhoneNumber);
}
