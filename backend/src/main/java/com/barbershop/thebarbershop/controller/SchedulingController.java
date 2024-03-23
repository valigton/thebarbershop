package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.SchedulingDTO;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    SchedulingRepository schedulingRepository;

    @GetMapping("/list")
    @ResponseBody
    public List<SchedulingDTO> schedulingList() {
        List<Scheduling> schedulings = schedulingRepository.findAll();
        return SchedulingDTO.converter(schedulings);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> schedulingById(@PathVariable Long id) {
        Scheduling scheduling = schedulingRepository.getSchedulingById(id);
        return ResponseEntity.ok(scheduling);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> saveScheduling(SchedulingDTO schedulingDTO) {
        Date date = schedulingDTO.getDate();
        return ResponseEntity.ok().body("ok");
    }
 }
