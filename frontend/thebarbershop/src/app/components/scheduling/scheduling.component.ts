import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { TextFieldModule } from '@angular/cdk/text-field';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

import { EmployeeDTO } from '../../dto/EmployeeDTO';
import { ApiServices } from '../../service/ApiServices';
import { ServiceDTO } from '../../dto/ServiceDTO';
import { SchedulingDTO } from '../../dto/SchedulingDTO';

@Component({
  selector: 'app-scheduling',
  standalone: true,
  imports: [
    MatFormFieldModule, 
    MatSelectModule, 
    CommonModule, 
    MatDatepickerModule, 
    MatInputModule, 
    MatIconModule, 
    MatDividerModule, 
    MatButtonModule, 
    TextFieldModule,
    ReactiveFormsModule
  ],
  templateUrl: './scheduling.component.html',
  styleUrl: './scheduling.component.css'
})
export class SchedulingComponent {

  public employeeList:Array<EmployeeDTO> = [];
  public serviceList:Array<ServiceDTO> = [];
  public postObject: SchedulingDTO = new SchedulingDTO();
  public currentObject: SchedulingDTO = new SchedulingDTO();
  public employeeDTO: EmployeeDTO = new EmployeeDTO;
  public serviceDTO: ServiceDTO = new ServiceDTO;
  selectedEmployee:number|undefined = 0;
  selectedService:number|undefined = 0;
  edit: boolean = false;
  id: string|null = "";

  form = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    email: new FormControl(),
    phone: new FormControl(),
    data: new FormControl(),
  });
  
  constructor(
    private apiService: ApiServices,
    private route: ActivatedRoute
  ){}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');

    this.apiService.getEmployeeList().subscribe((response: Array<EmployeeDTO>) => {
      this.employeeList = response;
    });

    this.apiService.getServiceList().subscribe((response: Array<ServiceDTO>) => {
      this.serviceList = response;
    });

    if(this.id != null) {
      this.edit = true;
    } else {
      this.edit = false;
    }

    if(this.edit){
      this.apiService.getSchedulingById(this.id).subscribe((res) => {
        this.currentObject = res;
        this.objectToForm(this.currentObject);
      });
    }
  }

  agendar() {
    let formValue = this.form.value;

    this.employeeDTO.id = this.selectedEmployee; 
    this.serviceDTO.id = this.selectedService;
    
    this.postObject.id = formValue.id != null ? formValue.id : null;
    this.postObject.clientName = formValue.name;
    this.postObject.clientEmail = formValue.email;
    this.postObject.clientPhoneNumber = formValue.phone;
    this.postObject.employee = this.employeeDTO;
    this.postObject.service = this.serviceDTO;
    this.postObject.date = formValue.data;   

    this.apiService.saveScheduling(this.postObject).subscribe((response) =>{
      console.log(response);
    });
  }

  objectToForm(obj: SchedulingDTO) {    
    this.form.controls['id'].setValue(obj.id);
    this.form.controls['name'].setValue(obj.clientName);
    this.form.controls['phone'].setValue(obj.clientPhoneNumber);
    this.form.controls['data'].setValue(obj.date);
    this.form.controls['email'].setValue(obj.clientEmail);
    this.selectedEmployee = obj.employee?.id;
    this.selectedService = obj.service?.id;
  }

}
