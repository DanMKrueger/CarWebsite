import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  active : String = "home";

  constructor(private router: Router, private loginService :LoginService) { }

  ngOnInit() {
  }

  signupClicked(){
    this.router.navigateByUrl('/signup');
  }

  contactClick(){this.router.navigateByUrl('/contact');}

  setActive(tab : String){this.active = tab;}
}
