//import { EmployeeDetailsComponent } from './../employee-details/employee-details.component';
import { Observable } from "rxjs";
import { DataService } from "./../data.service";
import { Employee } from "./../data";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-saved-data",
  templateUrl: "./saved-data.component.html",
  styleUrls: ["./saved-data.component.css"]
})
export class SavedComponent implements OnInit {
  employees: Observable<Employee[]>;

  constructor(private DataService: DataService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    console.log("working!!!!!!");
   // this.employees = this.DataService.getCompanyList();
  }

 /* saveEmployee() {
    console.log("save")
    this.DataService.saveEmployee()
      .subscribe(
        (data: any) => {
          console.log(data);
        
        },
        error => console.log(error));
  }
*/
}
