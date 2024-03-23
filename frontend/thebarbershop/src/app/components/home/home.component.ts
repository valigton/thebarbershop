import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';

import { EmployeeDTO } from '../../dto/EmployeeDTO';
import { ApiServices } from '../../service/ApiServices';
import { ServiceDTO } from '../../dto/ServiceDTO';
import { SchedulingDTO } from '../../dto/SchedulingDTO';

 
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatFormFieldModule, MatSelectModule, CommonModule, MatDatepickerModule, MatInputModule, MatIconModule, MatDividerModule, MatButtonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  public employeeList:Array<EmployeeDTO> = [];
  public serviceList:Array<ServiceDTO> = [];
  public postObject: SchedulingDTO = new SchedulingDTO();
  public employeeDTO: EmployeeDTO = new EmployeeDTO;
  public serviceDTO: ServiceDTO = new ServiceDTO;
  selectedEmployee:string = "";
  selectedService:string = "";
  selectedDate:Date = new Date();
  
  constructor(
    private apiService: ApiServices,
    private router: Router
  ){}

  ngOnInit() {
    this.apiService.getEmployeeList().subscribe((response: Array<EmployeeDTO>) => {
      this.employeeList = response;
    });

    this.apiService.getServiceList().subscribe((response: Array<ServiceDTO>) => {
      console.log(response)
      this.serviceList = response;
    });
  }

  agendar() {
    this.employeeDTO.id = parseInt(this.selectedEmployee); 
    this.serviceDTO.id = parseInt(this.selectedService);
    this.postObject.employee = this.employeeDTO;
    this.postObject.service = this.serviceDTO;
    this.postObject.date = this.selectedDate;

    this.apiService.saveScheduling(this.postObject).subscribe((response) =>{
      console.log(response);
    });

  }
}
