import { TextFieldModule } from '@angular/cdk/text-field';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { SchedulingDTO } from '../../dto/SchedulingDTO';
import { ApiServices } from '../../service/ApiServices';
import { MatInputModule } from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import { DataSource } from '@angular/cdk/collections';

@Component({
  selector: 'app-consult',
  standalone: true,
  imports: [MatFormFieldModule, TextFieldModule, CommonModule, ReactiveFormsModule,MatInputModule, MatTableModule],
  templateUrl: './consult.component.html',
  styleUrl: './consult.component.css'
})
export class ConsultComponent {
  public postObject: SchedulingDTO = new SchedulingDTO();
  displayedColumns: string[] = ['nome', 'serviço', 'profissional', 'data', 'horario'];
  dataSource:SchedulingDTO[] = [];

  form = new FormGroup({
    phone: new FormControl()
  });

  constructor(
    private apiService: ApiServices,
  ){}

  ngOnInit(){}

  consultar() {
    let formValue = this.form.value;
    this.postObject.clientPhoneNumber = formValue.phone;

    this.apiService.getScheduling(this.postObject).subscribe((res) => {
      this.dataSource = res;
      console.log(this.dataSource);
    });
  }
}
