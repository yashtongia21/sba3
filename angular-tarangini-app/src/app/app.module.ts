import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { ListPlansComponent } from './components/list-plans/list-plans.component';
import { AddNewUserComponent } from './components/add-new-user/add-new-user.component';



const paths: Routes = [
  { path: 'listPlans', component: ListPlansComponent },
  { path: 'addUser/:id', component: AddNewUserComponent },
 
];

@NgModule({
  declarations: [
    AppComponent,
    ListPlansComponent,
    AddNewUserComponent
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
