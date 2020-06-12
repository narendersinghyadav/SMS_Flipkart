package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.exception.IncorrectPasswordException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.User;
import com.flipkart.service.CheckIdentity;
import com.flipkart.service.CourseCatalog;

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
			int role=checkidentity.checkIdentity(username, password);
			if(role==1) {
				logger.info("admin is logged in");
				
			}
			else if(role==2) {
				logger.info("professor is logged in");
			}
			else {
				logger.info("studnet is logged in");
				
			}
		} catch (IncorrectPasswordException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}
}
