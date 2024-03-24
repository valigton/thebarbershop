package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.SchedulingDTO;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.repository.EmployeeRepository;
import com.barbershop.thebarbershop.repository.SchedulingRepository;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    SchedulingRepository schedulingRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> schedulingById(@PathVariable Long id) {
        Scheduling scheduling = schedulingRepository.getSchedulingById(id);
        return ResponseEntity.ok(scheduling);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveScheduling(@RequestBody SchedulingDTO schedulingDTO) {
        if(schedulingDTO == null) {
            return null;
        }
        Scheduling scheduling = schedulingDTO.converter(employeeRepository, serviceRepository);
        schedulingRepository.save(scheduling);

        return ResponseEntity.ok().body("ok");
    }
 }
