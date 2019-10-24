import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: String;
  password: String;
  user: any;
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  login(f: NgForm) {
    this.http.post('http://localhost:8080/login', [this.username, this.password])
      .subscribe((response) => {

        this.updateUser(response);
        
        if (this.user) {
          console.log(this.user.first_name);
          alert(this.user + "successfully logged in!");
        }
      })


  }
  updateUser(update) {
    this.user = update;
  }



}
