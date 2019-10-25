import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  authenticate(username : any, password : any) {
    
      this.http.post('http://localhost:8080/login', [username, password])
      .subscribe((response) => {
        
        if (response) 
        {
          sessionStorage.setItem('username', response.toString())
          alert(username + " successfully logged in!");
          return true;
        }
        else{return false;}
      })
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
