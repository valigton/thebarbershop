package com.barbershop.thebarbershop.util;

import com.barbershop.thebarbershop.controller.dto.EmployeeDTO;
import com.barbershop.thebarbershop.controller.dto.SchedulingDTO;
import com.barbershop.thebarbershop.controller.dto.ServiceDTO;
import com.barbershop.thebarbershop.model.Employee;
import com.barbershop.thebarbershop.model.Scheduling;
import com.barbershop.thebarbershop.model.Service;

public class Utils {
    public static EmployeeDTO toEmployee(Employee employee) {
        return new EmployeeDTO(employee);
    }

    public static ServiceDTO toService(Service service){
        return new ServiceDTO(service);
    }

    public static SchedulingDTO getSchedulingDTO(Scheduling scheduling) {
        SchedulingDTO dto = new SchedulingDTO();
        dto.setId(scheduling.getId());
        dto.setClientName(scheduling.getClientName());
        dto.setClientEmail(scheduling.getClientEmail());
        dto.setDate(scheduling.getDate());

        EmployeeDTO employeeDTO = new EmployeeDTO(scheduling.getEmployee());
        dto.setEmployee(employeeDTO);

        ServiceDTO serviceDTO = new ServiceDTO(scheduling.getService());
        dto.setService(serviceDTO);
        return dto;
    }
}
