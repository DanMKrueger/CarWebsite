import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username : String;
  
  constructor(private loginService : LoginService) { }

  ngOnInit() {
  }

  login(f: NgForm) {
    this.loginService.authenticate(f.value.username, f.value.password);
    this.username = f.value.username;
  }

  logout(){this.loginService.logOut()}
}
