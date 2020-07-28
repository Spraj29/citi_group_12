package com.example.entity;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//@Entity
public class UserDetails {
	//@Id
	//@GeneratedValue
	private Integer User_Id;
	private String Name;
	private String Password;
	public UserDetails() {
		
	}
	public UserDetails(Integer user_Id, String name, String password) {
		super();
		User_Id = user_Id;
		Name = name;
		Password = password;
	}
	public Integer getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(Integer user_Id) {
		User_Id = user_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "UserDetails [User_Id=" + User_Id + ", Name=" + Name + ", Password=" + Password + "]";
	}

}
