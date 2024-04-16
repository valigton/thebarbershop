package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.EmployeeDTO;
import com.barbershop.thebarbershop.controller.dto.SchedulingDTO;
import com.barbershop.thebarbershop.controller.dto.ServiceDTO;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.repository.EmployeeRepository;
import com.barbershop.thebarbershop.repository.SchedulingRepository;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import com.barbershop.thebarbershop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    SchedulingRepository schedulingRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @PostMapping("")
    @ResponseBody
    public List<SchedulingDTO> getScheduling(@RequestBody SchedulingDTO schedulingDTO) {
        List<SchedulingDTO> list = new ArrayList<>();

        List<Scheduling> schedulingList = schedulingRepository.getSchedulingByClientPhoneNumber(schedulingDTO.getClientPhoneNumber());

        if(schedulingList != null) {
            for (Scheduling scheduling : schedulingList) {
                SchedulingDTO dto = Utils.getSchedulingDTO(scheduling);
                list.add(dto);
            }
        }

        return list;
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
