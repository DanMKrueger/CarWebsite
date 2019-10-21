import { Component, OnInit } from '@angular/core';
import { Router, Data } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../data.service';

@Component({
  selector: 'app-requested-manufacturer',
  templateUrl: './requested-manufacturer.component.html',
  styleUrls: ['./requested-manufacturer.component.css']
})
export class RequestedManufacturerComponent implements OnInit {

  requestedManufacturer: any;
  allCars: any;

  constructor(private router: Router, private data: DataService, private http: HttpClient) { 
  }

  ngOnInit() {
    this.data.currentManufacturer.subscribe( message => this.requestedManufacturer = message);
    console.log(this.requestedManufacturer);

    this.http.get('http://localhost:8080/manufacturer' + this.requestedManufacturer) // http://localhost:8080/manufacturerJeep
    .subscribe((response) => {
      this.allCars = response;
      this.router.navigateByUrl('/requestedmanufacturer', {skipLocationChange: true});
      console.log(this.allCars)
    })
  }

  manufacturerClicked(id: number){
    console.log(id);
  }

}
