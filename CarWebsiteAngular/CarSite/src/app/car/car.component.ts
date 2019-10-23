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
  isCollapsed = true;

  constructor(
    private carHttp: HttpClient,
    private router: Router,
    private data: DataService
  ) { }

  toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }


  ngOnInit() {
    // Updated ngOnInit
    this.data.currentMessage.subscribe( message => this.message = message);
    if(this.message == -1){
      this.router.navigateByUrl('/allcars');
    }
    console.log(this.message);
    this.carHttp.get('http://localhost:8080/car' + this.message).subscribe((response) => {
      this.response = response;
      console.log(this.response);
    });

  }
}
