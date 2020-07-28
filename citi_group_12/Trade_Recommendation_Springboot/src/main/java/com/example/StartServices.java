package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan("com.example")
public class StartServices {
	 public static void main(String[] args) {
	        SpringApplication.run(StartServices.class,args);
	        
	    }
}
