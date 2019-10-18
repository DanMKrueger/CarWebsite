import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { AppComponent } from './app.component';


const routes: Routes = [

  { path: 'contact', component: ContactComponent },
  { path: 'home', component: AppComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
