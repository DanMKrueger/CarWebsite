import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-all-cars',
  templateUrl: './all-cars.component.html',
  styleUrls: ['./all-cars.component.css']
})
export class AllCarsComponent implements OnInit {

  response: any;

  constructor(private allcarsHttp: HttpClient) { 
    
  }

  ngOnInit() {
    this.allcarsHttp.get('http://localhost:8080/car').subscribe((response) => {
      this.response = response;
      console.log(this.response);
    });
  }

}
