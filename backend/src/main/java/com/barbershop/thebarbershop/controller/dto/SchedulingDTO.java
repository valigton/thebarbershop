package com.barbershop.thebarbershop.controller.dto;

import com.barbershop.thebarbershop.model.Scheduling;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulingDTO {
    private Long id;
    private String clientName;
    private String clientEmail;
    private Date date;
    private EmployeeDTO employee;
    private ServiceDTO service;

    public SchedulingDTO(Scheduling scheduling) {
        this.id = scheduling.getId();
        this.clientName = scheduling.getClientName();
        this.clientEmail = scheduling.getClientEmail();
        this.date = scheduling.getDate();
//        this.employee = scheduling.getEmployee();
//        this.service = scheduling.getService();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public EmployeeDTO getEmployee() { return employee; }

    public void setEmployee(EmployeeDTO employee) { this.employee = employee; }

    public ServiceDTO getService() { return service; }

    public void setService(ServiceDTO service) { this.service = service; }

    public static List<SchedulingDTO> converter(List<Scheduling> employees) {
        return employees.stream().map(SchedulingDTO::new).collect(Collectors.toList());
    }
}
