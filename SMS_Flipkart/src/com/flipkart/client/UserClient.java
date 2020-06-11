package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.exception.IncorrectPasswordException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.CheckIdentity;

public class UserClient {
	private static Logger logger=Logger.getLogger(UserClient.class);
	public static void main(String args[]) {
		String username;
		String password;
		//input
		Scanner scanner=new Scanner(System.in);
		logger.info("enter username and password");
		username=scanner.next();
		password=scanner.next();
		CheckIdentity checkidentity=new CheckIdentity();
		
		///checking identity
		try {
			checkidentity.checkIdentity(username, password);
		} catch (IncorrectPasswordException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}
}
