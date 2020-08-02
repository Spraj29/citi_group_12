import { Component, OnInit } from '@angular/core';
import { DataService } from "./../data.service";
import { Company } from "./../data";
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { user } from "./../user";

@Component({
  selector: 'app-dashboard',
  templateUrl:'./dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  u: user = new user('Vinita','5555');
  companies: Observable<Company[]>;
  companys: Observable<Company[]>;
  multiplier: number = 1000000;

  constructor(private DataService: DataService,
    private router: Router) {}
    
   ngOnInit(){
     console.log(this.u.Name);
     //console.log("Reload");
     this.companies=this.DataService.getSavedData();
    
   }
  
   selectMarketCap (event: any) {
    this.multiplier = event.target.value;
  }
  

  getCompanyList(marketCap: number)  {
    console.log("List");
    console.log(this.multiplier);
    this.companys = this.DataService.getCompanyList(marketCap*(this.multiplier));
    console.log("list back");
  }
  


    saveCompany(e: Company, name: String) {
      //console.log("save")
      this.DataService.saveCompany(e,name)
        .subscribe(
          (data: any) => {
            console.log(data);         
          },
          error => console.log(error));
          
    }

    deleteCompany(symbol: string, name: String){
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
    }

    logout(){
      console.log("logout");
      this.u.Name='';
      this.u.Password='';
      this.router.navigate(['/login']);
    }

    exit() { location.reload(); } 

}
