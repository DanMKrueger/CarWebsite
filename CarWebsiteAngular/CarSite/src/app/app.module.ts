import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ManufacturerListComponent } from './manufacturer-list/manufacturer-list.component';
import { CarComponent } from './car/car.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ManufacturerListComponent,
    CarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
