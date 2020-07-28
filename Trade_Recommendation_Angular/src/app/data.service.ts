import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ Employee} from './data';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  private baseUrl = 'http://localhost:8080/getTop5companies?marketCap=';
  public  saveUrl;
  constructor(
    private http: HttpClient) { }

  /*getRecommendation(): Observable<any> {
    console.log("working");
    return this.http.get(`${this.baseUrl}`);
  }*/


  saveEmployee(e:Employee,name: String): Observable<any> {    
    console.log(e);
    console.log(name);
   // companyname=str.split(/[ ,]+/).filter(function(v){return v!==''}).join(',')
    return this.http.get(`http://localhost:8080/saveCompanyDetails?companyname=AAABBBCCC&symbols=${e.symbol}&name=${name}`);
    
  }

  getCompanyList(marketCap: Number): Observable<any> {
    console.log("working!!!");
    console.log(marketCap);
    return this.http.get(`${this.baseUrl}${marketCap}`);
  }

  getSavedData(): Observable<any>{
    console.log("save");
    return this.http.get(`http://localhost:8080/userDetails?name=Vinita`);
  }

  deleteCompany(symbol: String, name:String){
    console.log("DELETE");
    console.log(symbol);
    console.log(name);
    return this.http.get(`http://localhost:8080/deleteCompanyDetails?Symbol=${symbol}&name=${name}`);
  }
}

