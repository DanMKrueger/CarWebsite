import { Component, OnInit, NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from '../data.service'

@Component({
  selector: 'app-all-cars',
  templateUrl: './all-cars.component.html',
  styleUrls: ['./all-cars.component.css']
})

export class AllCarsComponent implements OnInit {

  message: number;

  response: any;
  responsetwo: any;
  id: number;

  constructor(private allcarsHttp: HttpClient, private router: Router, private data: DataService) {

  }

  ngOnInit() {
    this.allcarsHttp.get('http://localhost:8080/car').subscribe((response) => {
      this.response = response;
      console.log(this.response);
    });
  }

  buttonClicked(id: number){
    this.message = id;
    this.data.changeMessage(this.message);
    // this.allcarsHttp.get('http://localhost:8080/car' + this.id, {responseType: 'text'}).subscribe((response) => {
    //   this.responsetwo = JSON.parse(response);
    //   this.router.navigateByUrl('/car');
    // });
    this.router.navigateByUrl('/car');
  }


}
