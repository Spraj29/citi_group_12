import { Component, OnInit } from '@angular/core';
import { user } from './../user'
import { Router } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';
import {DataService } from './../data.service';
import { loginOutput } from './../loginOutput';
import { Observable } from "rxjs";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  u: user;
  message: String;
  username;
  password;
  constructor(private DataService: DataService,
    private router: Router) {}
    
  ngOnInit(){

  }
  loginUser(Name: String, Password: String){
    // console.log(Name);
     this.u=new user(Name,Password);
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
      
      console.log(this.message);
     
  }


}
