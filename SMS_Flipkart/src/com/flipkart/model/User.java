package com.flipkart.model;
//user class
public class User {
	public String username;
	public String password;
	public int role;
	
	public User(String username,String password,int role) {
		this.username=username;
		this.password=password;
		this.role=role;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	User(String username,String password){
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
