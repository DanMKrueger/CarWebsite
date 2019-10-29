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
          Validators.compose([Validators.required, Validators.pattern('^(0[1-9]|1[0-2])/\([0-9]{2})$')])),
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

    this.carHttp.get('http://localhost:8080/car' + this.message).subscribe((response) => {
      this.response = response;
    });

  }

  onSubmit(buyNowForm) {
    console.log(buyNowForm);
    if (buyNowForm.controls.firstName.status === 'INVALID') {
      var x = document.getElementById('firstName');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('firstName');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.lastName.status === 'INVALID') {
      var x= document.getElementById('lastName');
      x.classList.add('redBorder');
    } else {
      var x= document.getElementById('lastName');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.email.status === 'INVALID') {
      var x = document.getElementById('email');
      x.classList.add('redBorder');
    } else{
      var x = document.getElementById('email');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.creditCard.status === 'INVALID') {
      var x= document.getElementById('creditCard');
      x.classList.add('redBorder');
    }else{
      var x= document.getElementById('creditCard');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.cvv.status === 'INVALID') {
      var x= document.getElementById('cvv');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('cvv');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.creditCardDate.status === 'INVALID') {
      var x= document.getElementById('creditCardDate');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('creditCardDate');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.address.status === 'INVALID') {
      var x= document.getElementById('address');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('address');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.city.status === 'INVALID') {
      var x= document.getElementById('city');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('city');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.state.status === 'INVALID') {
      var x= document.getElementById('state');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('state');
      x.classList.remove('redBorder');
    }

    if (buyNowForm.controls.zip.status === 'INVALID') {
      var x= document.getElementById('zip');
      x.classList.add('redBorder');
    } else{
      var x= document.getElementById('zip');
      x.classList.remove('redBorder');
    }


    if(this.buyNowForm.status === "VALID"){
      alert('Thank you for your purchase!');
      this.router.navigateByUrl('/home');
    }else{
      var x = document.getElementById('alertDiv');
      x.classList.add("alert");
      x.classList.add("alert-danger");
      x.innerHTML = "Please correct highlighted field(s)!";
    }

  }

}
