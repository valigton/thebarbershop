package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.EmployeeDTO;
import com.barbershop.thebarbershop.model.Employee;
import com.barbershop.thebarbershop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    @ResponseBody
    public List<EmployeeDTO> listEmployee() {
        List<Employee> list = employeeRepository.findAll();
        return EmployeeDTO.converter(list);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        return ResponseEntity.ok(new EmployeeDTO(employee));
    }

}
