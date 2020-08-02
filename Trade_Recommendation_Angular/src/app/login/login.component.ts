import { Component, OnInit } from '@angular/core';
import { user } from './../user'
import { Router } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';
import {DataService } from './../data.service';
import { loginOutput } from './../loginOutput';
import { Observable } from "rxjs";
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
//import { Component, OnInit } from '@angular/core';
//import { DataService } from "../data.service";

// @Injectable({
//   providedIn: 'root'
//  })
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  Message:string;
  u: user= new user('','');
  // private messageSource = new BehaviorSubject('default message');
  // currentMessage = this.messageSource.asObservable();
  message: String;
  username;
  password;
  constructor(private DataService: DataService,
    private router: Router) {}
    
  ngOnInit(){
   // this.DataService.currentMessage.subscribe(Message => this.Message = Message)
  }

  // changeMessage(message: string) {
  //   console.log(this.messageSource);
  //   this.messageSource.next(message)
  //   console.log(this.messageSource);}

  loginUser(Name: string, Password: String){
    //console.log(Name);
    this.DataService.changeMessage(Name);
    this.DataService.loginUser(Name,Password).subscribe(
      (data: loginOutput) => {
        this.message= data.message;
        console.log(this.message);   
        if(this.message === "Success"){
          this.router.navigate(['/dashboard']);
         }
        else{
          alert('Invalid Credentials');
        }      
      },
      error => console.log(error));
      
     // console.log(this.message);
     //this.changeMessage(Name);
     
     
  }


}
