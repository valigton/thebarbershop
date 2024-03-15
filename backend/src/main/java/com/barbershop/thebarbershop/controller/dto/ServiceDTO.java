package com.barbershop.thebarbershop.controller.dto;

import com.barbershop.thebarbershop.model.Employee;
import com.barbershop.thebarbershop.model.Service;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;

    public ServiceDTO(Service service) {
        this.id = service.getId();
        this.title = service.getTitle();
        this.description = service.getDescription();
        this.price = service.getPrice();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public static List<ServiceDTO> converter(List<Service> services) {
        return services.stream().map(ServiceDTO::new).collect(Collectors.toList());
    }
}
