import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ManufacturerListComponent } from './manufacturer-list/manufacturer-list.component';
import { CarComponent } from './car/car.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { AllCarsComponent } from './all-cars/all-cars.component';
import { DataService } from './data.service';
import { RequestedManufacturerComponent } from './requested-manufacturer/requested-manufacturer.component'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ManufacturerListComponent,
    CarComponent,
    ContactComponent,
    HomeComponent,
    AllCarsComponent,
    RequestedManufacturerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
    ],
  providers: [HttpClientModule, DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
