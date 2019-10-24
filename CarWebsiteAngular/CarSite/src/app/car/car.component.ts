import { Component, OnInit, NgModule, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AllCarsComponent } from '../all-cars/all-cars.component';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})



export class CarComponent implements OnInit  {

  buyNowForm: FormGroup;
  response: any;
  message: number;
  isCollapsed = true;
  email: string | boolean;

  constructor(
    private carHttp: HttpClient,
    private router: Router,
    private data: DataService,
    private formBuilder: FormBuilder
  ) {
    this.buyNowForm = formBuilder.group({
      firstName: new FormControl('',
          Validators.compose([Validators.required, Validators.minLength(3)])),
      lastName: new FormControl('',
          Validators.compose([Validators.required, Validators.minLength(2)])),
      email: new FormControl('',
          Validators.compose([Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')])),
      creditCard: new FormControl('',
          Validators.compose([Validators.required, Validators.maxLength(16), Validators.minLength(16)])),
      cvv: new FormControl('',
          Validators.compose([Validators.required, Validators.maxLength(4), Validators.minLength(3)])),
      creditCardDate: new FormControl('',
          Validators.compose([Validators.required, Validators.pattern('^(0[1-9]|1[0-2])\/([0-9]{2})$')])),
      address: new FormControl('',
          Validators.compose([Validators.required])),
      city: new FormControl('',
          Validators.compose([Validators.required])),
      state: new FormControl('',
          Validators.compose([Validators.required])),
      zip: new FormControl('',
          Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(5)]))
    });
    console.log(this.buyNowForm);

  }


  toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
  }

  log(x) {
    console.log(x);
  }


  ngOnInit() {
    // Updated ngOnInit
    this.data.currentMessage.subscribe( message => this.message = message);
    if (this.message == -1) {
      this.router.navigateByUrl('/allcars');
    }
    console.log(this.message);
    this.carHttp.get('http://localhost:8080/car' + this.message).subscribe((response) => {
      this.response = response;
      console.log(this.response);
    });

  }

  onSubmit(buyNowForm) {
    console.log(buyNowForm);

    if (buyNowForm.controls.firstName.status === 'INVALID') {
      // var x = document.getElementById("alertDiv");
      // var y = document.createElement("div");
      // y.className = "alert alert-danger";
      // y.innerHTML = "Incorrect First Name!";
      // x.appendChild(y);
      var x= document.getElementById("firstName");
      x.classList.add("redBorder");
    }
    else if (buyNowForm.controls.lastName.status === 'INVALID') {
      alert('Please enter a valid last name you idiot!');
    }
    else{
      alert("Thank you for your purchase!")
      this.router.navigateByUrl("/home");
    }

  }




}
