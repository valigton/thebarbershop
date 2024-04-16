import { Component, OnInit } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import { Router, RouterLinkActive } from '@angular/router';
 
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatIconModule, MatDividerModule, MatButtonModule, RouterLinkActive],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  constructor(
    private router: Router,
  ){}
  
  ngOnInit(): void { }

}
