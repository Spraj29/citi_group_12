import { Component, OnInit } from '@angular/core';
import { DataService } from "./data.service";
import { Employee } from "./data";
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { user } from "./user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Trade Recommendation System';
  u: user = new user('Vinita','5555');
  companies: Observable<Employee[]>;
  employees: Observable<Employee[]>;
  constructor(private DataService: DataService,
    private router: Router) {}
    
   ngOnInit(){
     console.log("Init");
      this.companies=this.DataService.getSavedData();
   }
    getCompanyList(marketCap: Number)  {
      console.log("List");
      this.employees = this.DataService.getCompanyList(marketCap);
      console.log("list back");
    }

    saveEmployee(e: Employee, name: String) {
      console.log("save")
      this.DataService.saveEmployee(e,name)
        .subscribe(
          (data: any) => {
            console.log(data);         
          },
          error => console.log(error));

    }

    deleteCompany(symbol: string, name: String){
      console.log("Delete");
      console.log(symbol,name)
      this.DataService.deleteCompany(symbol,name);
      console.log("deletedone");
    }
  
}
