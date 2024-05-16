import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeDTO } from '../dto/EmployeeDTO';
import { ServiceDTO } from '../dto/ServiceDTO';
import { SchedulingDTO } from '../dto/SchedulingDTO';


@Injectable({
  providedIn: 'root'
})
export class ApiServices {
  private url = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) { }

  getEmployeeList() {
    return this.http.get<Array<EmployeeDTO>>(`${this.url}/employee/list`)
  }

  getEmployeeById(id:number) {
    return this.http.get<Array<EmployeeDTO>>(`${this.url}/employee/${id}`)
  }

  getServiceList() {
    return this.http.get<Array<ServiceDTO>>(`${this.url}/service/list`)
  }

  getServiceById(id: string) {
    return this.http.get<ServiceDTO>(`${this.url}/service/${id}`)
  }

  getScheduling(dto: SchedulingDTO) {
    return this.http.post<Array<SchedulingDTO>>(`${this.url}/scheduling`, dto)
  }

  getSchedulingById(id:string|null) {
    return this.http.get<SchedulingDTO>(`${this.url}/scheduling/${id}`)
  }

  saveScheduling(dto: SchedulingDTO) {
    return this.http.post<SchedulingDTO>(`${this.url}/scheduling/save`, dto)
  }

  editScheduling(dto: SchedulingDTO) {
    return this.http.put<SchedulingDTO>(`${this.url}/scheduling/edit`, dto)
  }

  deleteScheduling(dto: SchedulingDTO){
    return this.http.delete<any>(`${this.url}/scheduling/delete`)
  }

}