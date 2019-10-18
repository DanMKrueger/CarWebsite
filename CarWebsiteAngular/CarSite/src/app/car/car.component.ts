import { Component, OnInit, NgModule } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})



export class CarComponent implements OnInit {

  response: any;

  constructor(
    private carHttp: HttpClient
  ) { }

  ngOnInit() {
    this.carHttp.get('http://localhost:8080/car').subscribe((response) => {
      this.response = response[0];
      console.log(this.response);
    });

  }


}
