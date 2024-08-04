package com.barbershop.thebarbershop.repository;

import com.barbershop.thebarbershop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service getServiceById(Long id);
    Service getServiceByTitle(String title);

    List<Service> findByTitleContaining(String title);
}
