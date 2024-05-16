package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.EmployeeDTO;
import com.barbershop.thebarbershop.controller.dto.SchedulingDTO;
import com.barbershop.thebarbershop.controller.dto.ServiceDTO;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.repository.EmployeeRepository;
import com.barbershop.thebarbershop.repository.SchedulingRepository;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import com.barbershop.thebarbershop.util.Utils;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
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

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> schedulingById(@PathVariable Long id) {
        Scheduling scheduling = schedulingRepository.getSchedulingById(id);

        SchedulingDTO dto = Utils.getSchedulingDTO(scheduling);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOrUpdateScheduling(@RequestBody SchedulingDTO schedulingDTO) throws JsonMappingException {
        if(schedulingDTO == null) {
            return null;
        }

        Scheduling scheduling = schedulingRepository.getSchedulingById(schedulingDTO.getId());

        if(scheduling != null && scheduling.getId() != null) {
            //update object
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.updateValue(scheduling, schedulingDTO);
            schedulingRepository.save(scheduling);
        } else {
            //save object
            scheduling = schedulingDTO.converter(employeeRepository, serviceRepository);
            schedulingRepository.save(scheduling);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteScheduling(@RequestBody SchedulingDTO schedulingDTO) {
        if(schedulingDTO == null) {
            return null;
        }

        Scheduling scheduling = schedulingRepository.getSchedulingById(schedulingDTO.getId());
        if(scheduling != null){
            schedulingRepository.deleteById(scheduling.getId());
        }

        return ResponseEntity.ok().build();
    }
 }
