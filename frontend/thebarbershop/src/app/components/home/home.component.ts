import { Component, OnInit } from '@angular/core';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { Router, RouterLinkActive, RouterModule } from '@angular/router';
 
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatDividerModule, MatButtonModule, RouterLinkActive, RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  constructor(
    private router: Router,
  ){}
  
  ngOnInit(): void { }

}
