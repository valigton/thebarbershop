package com.barbershop.thebarbershop.controller;

import com.barbershop.thebarbershop.controller.dto.ServiceDTO;
import com.barbershop.thebarbershop.model.Service;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/list")
    @ResponseBody
    public List<ServiceDTO> listServices() {
        List<Service> services = serviceRepository.findAll();
        return ServiceDTO.converter(services);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getServiceById(@PathVariable Long id) {
        Service service = serviceRepository.getServiceById(id);
        return ResponseEntity.ok(service);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<ServiceDTO> getServiceByTitle(@RequestBody ServiceDTO serviceDTO) {
        List<Service> serviceList = new ArrayList<>();

        serviceList = serviceRepository.findByTitleContaining(serviceDTO.getTitle());
        return ServiceDTO.converter(serviceList);

    }
}
