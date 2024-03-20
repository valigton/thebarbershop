import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from '../../dto/EmployeeDTO';
import { ApiServices } from '../../service/ApiServices';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  public employeeList: Array<EmployeeDTO> = [];

  constructor(
    private apiService: ApiServices,
    private router: Router
  ){}

  ngOnInit() {
    this.apiService.getEmployeeList().subscribe((response: Array<EmployeeDTO>) => {
      this.employeeList = response;
    });

    console.log(this.employeeList);
  }
    
}
