import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ApiServices } from '../../service/ApiServices';
import { Router, RouterModule } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ServiceDTO } from '../../dto/ServiceDTO';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-consult-service',
  standalone: true,
  imports: [
    MatFormFieldModule, 
    TextFieldModule, 
    CommonModule, 
    ReactiveFormsModule, 
    MatInputModule, 
    MatTableModule, 
    MatButtonModule, 
    MatIconModule
  ],
  templateUrl: './consult-service.component.html',
  styleUrl: './consult-service.component.css'
})
export class ConsultServiceComponent {
  public postObject: ServiceDTO = new ServiceDTO();
  displayedColumns: string[] = ['serviço', 'preco'];
  dataSource:ServiceDTO[] = [];

  form = new FormGroup({
    title: new FormControl()
  });

  constructor(
    private apiService: ApiServices,
    private router: Router,
    public dialog: MatDialog
  ){}

  ngOnInit(){}

  consultar() {
    let formValue = this.form.value;
    this.postObject.title = formValue.title;

    this.apiService.getServiceByName(this.postObject).subscribe((res) => {
      this.dataSource = res;
      console.log(this.dataSource)
    });
  }

}
