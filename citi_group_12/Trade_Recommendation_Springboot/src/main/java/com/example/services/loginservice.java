package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.entity.UserDetails;

@Service

public class loginservice {
	@Autowired
    JdbcTemplate jdbcTemplate;
	public String ValidateUser(String Username,String Password)
	{
		List<UserDetails> users=new ArrayList<UserDetails>();
		users=GetUSerDetails();
		for(UserDetails user:users)
		{
			if(user.getName().equals(Username)&& user.getPassword().equals(Password))
			{
				return "Success";
			}
					
		}
		
		return "Failure";
		
	}
	List<UserDetails> GetUSerDetails() {

	    String sql = "SELECT * FROM UserDetails";

	    return jdbcTemplate.query(
	            sql,
	            (rs, rowNum) ->
	                    new UserDetails(
	                            1,rs.getString("NAME"),
	                            rs.getString("PASSWORD")
	                           // rs.getInt("age")
	                            //rs.getTimestamp("created_date").toLocalDateTime()
	                    )
	    );
	}
}
