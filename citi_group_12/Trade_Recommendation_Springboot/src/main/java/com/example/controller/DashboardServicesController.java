package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Company;
import com.example.services.Dashboardservices;
import com.example.services.loginservice;
import com.google.gson.Gson;

@CrossOrigin(origins = {"http://localhost:4200","http://anotherdomain:8090"})
@RestController
public class DashboardServicesController {
	
	@Autowired
	loginservice ls;
	@Autowired
	Dashboardservices ds;
	@GetMapping("/login")
	public String login(@RequestParam(value = "name", defaultValue = "World") String name,@RequestParam(value = "password", defaultValue = "World") String password) {
		System.out.println(name);
		System.out.println(password);
		return ls.ValidateUser(name, password);
		
}
	@GetMapping("/userDetails")
		@CrossOrigin(origins = {"http://localhost:4200","http://anotherdomain:8090"})

	public List<Company> userDetails(@RequestParam(value = "name", defaultValue = "World")String name ) {
		
		
		List<Company> list=new ArrayList<Company>();
		System.out.println(name);
		list=ds.getCompanyDetails(name);
		
		return list;
	}
		@GetMapping("/getTop5companies")
	
		@CrossOrigin(origins = "*", allowedHeaders = "*")

		public List<Company> getTop5companies(@RequestParam(value = "marketCap", defaultValue = "0000")long marketCap ) throws Exception {
			
			
			List<Company> list=new ArrayList<Company>();
			System.out.println(marketCap);
			list=ds.getTopFiveCompanies(marketCap);
			
			return list;
		}
		
			@GetMapping("/saveCompanyDetails")
				@CrossOrigin(origins = "*", allowedHeaders = "*")
             public void saveCompanyDetails(@RequestParam(value = "symbols")String  symbols,@RequestParam(value = "name")String  name,@RequestParam(value = "marketcap")Long  marketcap,@RequestParam(value = "forwardeps")Double  forwardeps,@RequestParam(value = "Companyname")String  Companyname ) throws Exception {
				
				
				Company c=new Company();
				c.setCompanyName(Companyname);
				c.setSymbol(symbols);
				c.setForwardEps(forwardeps);
				c.setMarketCap(marketcap);
				
				
				ds.saveCompanyDetails(c,name);
				}

			
			@GetMapping("/deleteCompanyDetails")
			@CrossOrigin(origins = "*", allowedHeaders = "*")
			public void deleteCompanyDetails(@RequestParam(value = "Symbol", defaultValue = "World")String Symbol, @RequestParam(value = "name", defaultValue = "World")String name) throws Exception {
					//Company c=new Company();
					ds.deleteCompanyDetails(Symbol,name);
				}
	
		
}