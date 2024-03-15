package com.barbershop.thebarbershop.controller.dto;

import com.barbershop.thebarbershop.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDTO {
    private Long id;
    private String nome;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.nome = employee.getNome();
    }
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public static List<EmployeeDTO> converter(List<Employee> employees) {
        return employees.stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }
}
