import { Component, OnInit, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-all-cars',
  templateUrl: './all-cars.component.html',
  styleUrls: ['./all-cars.component.css']
})

export class AllCarsComponent implements OnInit {

  response: any;
  responsetwo: any;
  id: number;

  constructor(private allcarsHttp: HttpClient) { 
    
  }

  ngOnInit() {
    this.allcarsHttp.get('http://localhost:8080/car').subscribe((response) => {
      this.response = response;
      console.log(this.response);
    });
  }

  clickFunction(id){
    this.id = id;
    this.allcarsHttp.get('http://localhost:8080/car' + this.id, {responseType: 'text'}).subscribe((response) => {
      this.responsetwo = JSON.parse(response);
      console.log(this.responsetwo);
      console.log(this.responsetwo.id);
    });
  }

}
