package com.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.entity.Company;
import com.example.entity.UserDetails;
import com.example.utilities.Recommendation;

@Service
public class Dashboardservices {
	@Autowired
    JdbcTemplate jdbcTemplate;

public List<Company> getCompanyDetails(String name) {
	System.out.println(name);
    String sql = "SELECT * FROM CompanyDetails where NAME='"+name+"'";
    System.out.println(sql);
    return jdbcTemplate.query(
            sql,
            (rs, rowNum) ->
                    new Company(
                            
                    		   rs.getString("SYMBOLS"),
                               rs.getLong("MARKET_CAP") ,
                               rs.getDouble("FORWARD_PE"),
                               rs.getDouble("BOOK_VALUE"),
                               rs.getDouble("PRICE_TO_BOOK"),
                               rs.getDouble("TRAILING_EPS"), 
                               rs.getDouble("FORWARD_EPS"),
                               rs.getDouble("PEGRATIO"), 
                               rs.getDouble("LASTDIVIDENDVALUE"), 
                               rs.getString("COMPANY_NAME"),
                               rs.getDouble("REGULARMARKETPRICE")
                    )
    );
   // return null;
   
}


public List<Company> getTopFiveCompanies(long marketCap) throws Exception{
	System.out.println(marketCap);
	   Recommendation r=new Recommendation();
	   return r.getTopFiveCompany(marketCap); 
}

public void saveCompanyDetails(Company companyDetails,String name) throws Exception
{
	
	String sql = "INSERT into CompanyDetails values(1,'"+name+"','"+companyDetails.getCompanyName()+"','"+companyDetails.getSymbol()+"',"+companyDetails.getMarketCap()+","+companyDetails.getForwardPE()+","+companyDetails.getBookValue()+","+companyDetails.getPriceToBook()+","+companyDetails.getTrailingEps()+","+companyDetails.getForwardEps()+","+companyDetails.getPegRatio()+","+companyDetails.getLastDividendValue()+","+companyDetails.getRegularMarketPrice()+")";
	System.out.println(sql);
	Connection conn=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
            Statement statement = conn.createStatement();
       	 //Statement statement1 = conn.createStatement();
            PreparedStatement psInsert = conn.prepareStatement(sql);
            psInsert.execute();
         
}

public void deleteCompanyDetails(String Symbol,String name) throws Exception
{
	
	String sql = "Delete from companyDetails where SYMBOLS = '"+Symbol+"'AND NAME='"+name+"'";
	System.out.println(sql);
	Connection conn=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
            Statement statement = conn.createStatement();
       	 //Statement statement1 = conn.createStatement();
            PreparedStatement psInsert = conn.prepareStatement(sql);
            psInsert.executeUpdate(sql);
         
}

}
