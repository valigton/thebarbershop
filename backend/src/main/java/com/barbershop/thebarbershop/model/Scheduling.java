package com.barbershop.thebarbershop.model;

import com.barbershop.thebarbershop.repository.EmployeeRepository;
import com.barbershop.thebarbershop.repository.ServiceRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Entity
@Table(schema = "SCHEDULING")
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String clientEmail;
    private String clientPhoneNumber;
    private Date date;
    @JdbcTypeCode(SqlTypes.JSON)
    @JsonProperty("employee")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @JdbcTypeCode(SqlTypes.JSON)
    @JsonProperty("service")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    public Scheduling() { }

    public Scheduling(String clientName, String clientEmail, String clientPhoneNumber, Date date, Employee employee, Service service) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.date = date;
        this.employee = employee;
        this.service = service;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public String getClientPhoneNumber() { return clientPhoneNumber; }

    public void setClientPhoneNumber(String clientPhoneNumber) { this.clientPhoneNumber = clientPhoneNumber; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public Service getService() { return service; }

    public void setService(Service service) { this.service = service; }
}
