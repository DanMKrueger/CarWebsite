import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ManufacturerListComponent } from './manufacturer-list/manufacturer-list.component';
import { CarComponent } from './car/car.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { AllCarsComponent } from './all-cars/all-cars.component';
import { DataService } from './data.service';
import { RequestedManufacturerComponent } from './requested-manufacturer/requested-manufacturer.component';
import { LoginComponent } from './login/login.component'
import { AdminComponent } from './admin/admin.component';
import { AddComponent } from './add/add.component'
import { LoginService } from './login/login.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ManufacturerListComponent,
    CarComponent,
    ContactComponent,
    HomeComponent,
    AllCarsComponent,
    RequestedManufacturerComponent,
    LoginComponent,
    AdminComponent,
    AddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClientModule, DataService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
