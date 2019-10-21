import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manufacturer-list',
  templateUrl: './manufacturer-list.component.html',
  styleUrls: ['./manufacturer-list.component.css']
})
export class ManufacturerListComponent implements OnInit {

  hovering : String;
  manufacturers : any;
  response : any;
  manuResponse: any;

  constructor(private http : HttpClient, private data: DataService, private router: Router) { }

  ngOnInit() {
   this.response = this.http.get('http://localhost:8080/getmanufacturers')
    .subscribe((response) => {
      this.manufacturers = response;
    })
  }

  manufacturerClicked(makeClicked: string){
    this.data.changeManufacturer(makeClicked);
    console.log(makeClicked);
    this.router.navigateByUrl('/requestedmanufacturer');
  }

}
