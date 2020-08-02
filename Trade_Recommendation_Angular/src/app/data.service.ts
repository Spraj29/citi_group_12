import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ Company } from './data';
import { loginOutput } from './loginOutput';
//import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private baseUrl = 'http://localhost:8080/getTop5companies?marketCap=';
  public  saveUrl;
  
  private messageSource = new BehaviorSubject('User');
  currentMessage = this.messageSource.asObservable();
  constructor(
    private http: HttpClient) { }
  

    changeMessage(message: string) {
      console.log(this.messageSource);
      this.messageSource.next(message)
      console.log(this.messageSource);}

  loginUser(username: String, password: String): Observable<loginOutput>{
   // console.log("login");
    return this.http.get<loginOutput>(`http://localhost:8080/login?name=${username}&password=${password}`);
  }

  saveCompany (c:Company ,name: String): Observable<any> {    
   // console.log(c);
    console.log(name);
    return this.http.get(`http://localhost:8080/saveCompanyDetails?symbols=${c.symbol}&name=${name}&forwardeps=${c.forwardEps}&marketcap=${c.marketCap}&Companyname=${c.companyName}&forwardpe=${c.forwardPE}`);
    
  }

  getCompanyList(marketCap: Number): Observable<any> {
   // console.log("fetching company details");
    console.log(marketCap);
    return this.http.get(`${this.baseUrl}${marketCap}`);
  }

  getSavedData(Name: string): Observable<any>{
    console.log("saved data");
    return this.http.get(`http://localhost:8080/userDetails?name=${Name}`);
  }

  deleteCompany(symbol: String, name:String): Observable<any>{
    console.log("DELETE");
    console.log(symbol);
    console.log(name);
    return this.http.get(`http://localhost:8080/deleteCompanyDetails?Symbol=${symbol}&name=${name}`);
  }

}

