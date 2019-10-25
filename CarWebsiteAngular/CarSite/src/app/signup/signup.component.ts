import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  fullString: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  addUser(f: NgForm){
    if(f.value.Password.length == 0 || f.value.Username.length == 0 || f.value.FirstName == 0 || f.value.LastName == 0){
      alert("Please enter all fields!");
    }else{
      this.fullString = "[" + f.value.Username + ","+f.value.Password + "," + f.value.FirstName + "," + f.value.LastName + "]"; 
      this.http.post('http://localhost:8080/signup', this.fullString, {responseType:'text'}).subscribe((response) => {
        alert(response);
      });
    }
  }

}
