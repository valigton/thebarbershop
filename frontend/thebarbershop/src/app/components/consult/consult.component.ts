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
import { InputMaskModule, createMask } from '@ngneat/input-mask';
import { DialogInfoComponent } from '../dialog-info/dialog-info.component';
import { MatDialog } from '@angular/material/dialog';
import { DialogDeleteComponent } from './dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-consult',
  standalone: true,
  imports: [MatFormFieldModule, TextFieldModule, CommonModule, ReactiveFormsModule,MatInputModule, MatTableModule, MatButtonModule, MatIconModule, RouterModule, InputMaskModule],
  templateUrl: './consult.component.html',
  styleUrl: './consult.component.css'
})
export class ConsultComponent {
  public postObject: SchedulingDTO = new SchedulingDTO();
  displayedColumns: string[] = ['nome', 'serviço', 'profissional', 'data', 'horario', 'edit', 'delete'];
  dataSource:SchedulingDTO[] = [];

  phoneInputMask = createMask('([99])99999-9999');

  form = new FormGroup({
    phone: new FormControl()
  });

  constructor(
    private apiService: ApiServices,
    private router: Router,
    public dialog: MatDialog
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

  deletarAgendamento(id: any) {
    this.dialog.open(DialogDeleteComponent, {
      width: '250px'
    }).afterClosed().subscribe((res) => {
      if(res) {
        this.apiService.deleteScheduling(id).subscribe((response) => {
          this.consultar();
         });
      }
    });
  }
}
