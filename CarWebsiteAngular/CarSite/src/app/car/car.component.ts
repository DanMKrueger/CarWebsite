import { Component, OnInit, NgModule, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AllCarsComponent } from '../all-cars/all-cars.component';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})



export class CarComponent implements OnInit {

  response: any;
  message: number;

  constructor(
    private carHttp: HttpClient,
    private router: Router,
    private data: DataService
  ) { }

  ngOnInit() {
    this.carHttp.get('http://localhost:8080/car').subscribe((response) => {
      this.response = response[13];
      console.log(this.response);
    });

  }
}
