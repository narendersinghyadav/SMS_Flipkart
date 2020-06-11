package com.flipkart.exception;

public class UserNotFoundException extends Exception{
	String username;
	public UserNotFoundException(String username){
		this.username=username;
	}
	public String getMessage() {
		return username+" not found";
	}
}
