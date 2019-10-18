import { NgModule, ɵAPP_ROOT } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { AppComponent } from './app.component';
import { AppModule } from './app.module';
import { HomeComponent } from './home/home.component';
import { CarComponent } from './car/car.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch:'full' },
  { path: 'contact', component: ContactComponent },
  { path: 'home', component: HomeComponent },
  { path: 'car', component: CarComponent }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
