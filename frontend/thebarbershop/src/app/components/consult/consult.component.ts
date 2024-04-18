import { TextFieldModule } from '@angular/cdk/text-field';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { SchedulingDTO } from '../../dto/SchedulingDTO';
import { ApiServices } from '../../service/ApiServices';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-consult',
  standalone: true,
  imports: [MatFormFieldModule, TextFieldModule, CommonModule, ReactiveFormsModule,MatInputModule, MatTableModule, MatButtonModule, MatIconModule, RouterModule],
  templateUrl: './consult.component.html',
  styleUrl: './consult.component.css'
})
export class ConsultComponent {
  public postObject: SchedulingDTO = new SchedulingDTO();
  displayedColumns: string[] = ['nome', 'serviço', 'profissional', 'data', 'horario', 'edit', 'delete'];
  dataSource:SchedulingDTO[] = [];

  form = new FormGroup({
    phone: new FormControl()
  });

  constructor(
    private apiService: ApiServices,
    private router: Router
  ){}

  ngOnInit(){}

  consultar() {
    let formValue = this.form.value;
    this.postObject.clientPhoneNumber = formValue.phone;

    this.apiService.getScheduling(this.postObject).subscribe((res) => {
      this.dataSource = res;
    });
  }

  editarAgendamento(id:number) {
    this.router.navigateByUrl('/agendamento/'+ id);
  }

  deletarAgendamento(id:number){
    console.log(id);
  }
}
