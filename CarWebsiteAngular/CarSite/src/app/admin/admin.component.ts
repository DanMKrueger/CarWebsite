import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  response: any;
  allCars: any;
  conf: any;

  constructor(private router: Router, private http: HttpClient) {
   }

  ngOnInit() {
    this.response = prompt("Please enter the password:", "admin");
    if(this.response != "admin"){
      window.stop();
      this.router.navigateByUrl('/home');
    }else{
      this.http.get('http://localhost:8080/car').subscribe((response) => {
        console.log(response);
        this.allCars = response;
      });
    }
  }

  editClicked(id: number){
    console.log("Clicked edit on car: " + id);
  }

  deleteClicked(id: number){
    this.conf = confirm("Are you sure you want to delete?");
    if(this.conf){
      console.log("Deleting car: " + id);
      this.http.delete('http://localhost:8080/removecar' + id).subscribe((response) => {
        //console.log(response);
      });
      //setTimeout(() => window.location.reload(), 1000);
      setTimeout(() => this.http.get('http://localhost:8080/car').subscribe((response) => {
        console.log(response);
        this.allCars = response;
      }), 1000);
    }else{
      console.log("Backed out of delete");
    }
  }
}