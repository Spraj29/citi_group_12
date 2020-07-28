package com.example;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class CreateCompanyDetails {

    public static void main(String[] args) {

        try (Connection conn=DriverManager.getConnection(  
        		"jdbc:oracle:thin:@localhost:1521:xe","system","root"); 
             //Statement statement = conn.createStatement();
        	 Statement statement1 = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

           statement1.execute(SQL_TABLE_CREATE1);

            // start transaction block
            conn.setAutoCommit(false); // default true

            // Run list of insert commands
            psInsert.setBigDecimal(1, new BigDecimal(1));
            psInsert.setString(2, "Prajakta");
            psInsert.setString(3, "1111");
            psInsert.execute();

            psInsert.setBigDecimal(1, new BigDecimal(2));
            psInsert.setString(2, "Saloni");
            psInsert.setString(3, "2222");
            psInsert.execute();
            
            psInsert.setBigDecimal(1, new BigDecimal(3));
            psInsert.setString(2, "Shivani");
            psInsert.setString(3, "3333");
            psInsert.execute();
            
            psInsert.setBigDecimal(1, new BigDecimal(4));
            psInsert.setString(2, "Vedangi");
            psInsert.setString(3, "4444");
            psInsert.execute();
            
            psInsert.setBigDecimal(1, new BigDecimal(5));
            psInsert.setString(2, "Vinita");
            psInsert.setString(3, "5555");
            psInsert.execute();
            
            
            
            

           
            conn.commit();

            // good practice to set it back to default true
            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static final String SQL_INSERT = "INSERT INTO UserDetails (USerID,Name, Password) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE UserDetails SET Name=? WHERE Password=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE UserDetails"
            + "("
            + " UserID  numeric,"	
            + " Name varchar(100),"
            + " Password varchar(100)"
           + ")";
    
    private static final String SQL_TABLE_CREATE1 = "CREATE TABLE CompanyDetails"
            + "("
            + " Company_ID  numeric,"
            + " Name varchar(100),"
            + " Company_Name varchar(100),"
            + " Symbols varchar(100),"
            + " Market_Cap numeric,"
            + " Forward_PE decimal,"
            + " Book_Value decimal,"
            + " Price_to_Book decimal,"
            + " Trailing_Eps decimal,"
            + " Forward_Eps decimal,"
            + " pegRatio decimal,"
            + " lastDividendValue decimal,"
            + " regularMarketPrice decimal"
           + ")";
    

  // private static final String SQL_TABLE_DROP = "DROP TABLE UserDetails";

}