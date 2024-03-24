package com.barbershop.thebarbershop.controller.dto;

import com.barbershop.thebarbershop.model.Employee;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.model.Service;
import com.barbershop.thebarbershop.repository.EmployeeRepository;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import com.barbershop.thebarbershop.util.Utils;

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

    public Scheduling converter(EmployeeRepository employeeRepository, ServiceRepository serviceRepository) {
        Employee employeeVO = employeeRepository.getEmployeeById(employee.getId());
        Service serviceVO = serviceRepository.getServiceById(service.getId());

        return new Scheduling(clientName, clientEmail, date, employeeVO, serviceVO);
    }
}
