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
  loggedIn : boolean = false;
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  login(f: NgForm) {
    this.http.post('http://localhost:8080/login', [this.username, this.password])
      .subscribe((response) => {

        this.updateUser(response);

        if (this.user) {
          alert(this.user.first_name + " successfully logged in!");
          this.loggedIn = true;
        }
      })
  }
  updateUser(update) {
    this.user = update;
  }
}
