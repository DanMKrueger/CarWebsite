import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  authenticate(username : any, password : any)
  {
      this.http.post('http://localhost:8080/login', [username, password])
      .subscribe((response) => {
        
        if (response) 
        {
          sessionStorage.setItem('username', username)
          alert(username + " successfully logged in!");
          return true;
        }
        else
        {
          alert("Invalid credentials!");
        return false;
        }
      })
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

  currentUser(){return sessionStorage.getItem('username');}

  logOut() {
    sessionStorage.removeItem('username')
  }
}
