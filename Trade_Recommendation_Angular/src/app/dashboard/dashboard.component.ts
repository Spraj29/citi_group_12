import { Component, OnInit } from '@angular/core';
import { DataService } from "./../data.service";
import { Company } from "./../data";
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { user } from "./../user";
import { loginOutput } from '../loginOutput';
//import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-dashboard',
  templateUrl:'./dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  message:string;
  //u: user = new user('Vinita','5555');
  u:user;
  companies: Observable<Company[]>;
  companys: Observable<Company[]>;
  multiplier: number = 1000000;

  constructor(private DataService: DataService,
   // private login: LoginComponent, 
    private router: Router) {}
    
   ngOnInit(){
    //this.login.currentMessage.subscribe(message => this.message = message)
    this.DataService.currentMessage.subscribe(
      (message: any) => {
        this.message=message;
        console.log(this.message);         
      },
      error => console.log(error));

    
    console.log(this.message);
      this.u=new user(this.message, "4567");
     console.log(this.u.Name);
     //console.log("Reload");
     if(this.u.Name=== ' '){
       this.router.navigate(['/login']);
     }
     this.companies=this.DataService.getSavedData(this.u.Name);
    
   }
  
   selectMarketCap (event: any) {
    this.multiplier = event.target.value;
  }
  

  getCompanyList(marketCap: number)  {
    alert("Fetching recommendations for you...");
    console.log("List");
    console.log(this.multiplier);
    this.companys = this.DataService.getCompanyList(marketCap*(this.multiplier));
    console.log("list back");
  }
  


    async saveCompany(e: Company, name: String) {
      //console.log("save")
      this.DataService.saveCompany(e,name)
        .subscribe(
          (data: any) => {
            console.log(data);         
          },
          error => console.log(error));

          await this.delay(500);
          this.companies=this.DataService.getSavedData(this.u.Name);

          
    }

    async deleteCompany(symbol: string, name: String){
      console.log("Delete");
      console.log(symbol,name)
     // this.DataService.deleteCompany(symbol,name);
      this.DataService.deleteCompany(symbol,name)
     .subscribe(
       (data: any) => {
         console.log(data);         
       },
       error => console.log(error));

      console.log("deletedone");
    //  this.reload();
    await this.delay(500);
          this.companies=this.DataService.getSavedData(this.u.Name);
    }

    logout(){
      console.log("logout");
      this.u.Name='';
      this.u.Password='';
      this.router.navigate(['/login']);
    }

//    exit() { location.reload(); } 
    delay(ms: number) {
      return new Promise( resolve => setTimeout(resolve, ms) );
      }
  
      //<button [routerLink]="['/dashboard']" (click)="exit()" style="float: right ;"> <i class="fa fa-refresh"></i> </button>
}
