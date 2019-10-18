import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-manufacturer-list',
  templateUrl: './manufacturer-list.component.html',
  styleUrls: ['./manufacturer-list.component.css']
})
export class ManufacturerListComponent implements OnInit {

  manufacturers : any;
  response : any;
  constructor(private http : HttpClient) { }

  ngOnInit() {
   this.response = this.http.get('http://localhost:8080/getmanufacturers')
    .subscribe((response) => {
      this.manufacturers = response;
      /* for (let i = 0; i < array.length; i++) {
        const element = array[i];
        
      }*/

      console.log(this.manufacturers[0].image)
    })
  }

}
