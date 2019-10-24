import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
isCollapsed = true;
response: any;
car: any;

  constructor(private router: Router, private http: HttpClient) {
   }


  ngOnInit() {

  }

  showForm(){
        this.isCollapsed = !this.isCollapsed;
  }

  submitAdd(form : NgForm) {
this.car =
[
form.value.make,
form.value.model,
form.value.year,
form.value.color,
form.value.description,
form.value.picture,
form.value.price
]

this.http.post('http://localhost:8080/addcar', this.car).subscribe((response) => {
      console.log(response);
    });
    console.log(form);
  }
}
