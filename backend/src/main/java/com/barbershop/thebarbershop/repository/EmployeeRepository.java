package com.barbershop.thebarbershop.repository;

import com.barbershop.thebarbershop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
