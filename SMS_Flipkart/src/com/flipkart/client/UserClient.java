package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.constant.RoleConstants;
import com.flipkart.exception.IncorrectPasswordException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.CheckIdentity;

// Functionality related to user
public class UserClient {
	private static Logger logger=Logger.getLogger(UserClient.class);
	
	//common login portal
	public static void main(String args[]) {
		String username;
		String password;
		Scanner scanner=new Scanner(System.in);
		while(true) {
			logger.info("**************");
			logger.info("Login Portal");
			logger.info("**************");
			logger.info("enter username");
			username=scanner.next();
			logger.info("enter password");
			password=scanner.next();
			CheckIdentity checkidentity=new CheckIdentity();
			LocalDateTime localtime=LocalDateTime.now();
			///checking identity
			try {
				int role=checkidentity.checkIdentity(username, password);
				switch(role){
				case RoleConstants.ADMIN:
					logger.info("Admin is logged in");
					logger.info(localtime+"/"+localtime.getDayOfWeek());
					AdminClient adminclient=new AdminClient();
					adminclient.main();
					break;
				case RoleConstants.PROFESSOR:
					logger.info("Professor is logged in");
					logger.info(localtime+"/"+localtime.getDayOfWeek());
					ProfessorClient professorclient=new ProfessorClient();
					professorclient.main(username,password);
					break;
				case RoleConstants.STUDENT:
					logger.info("Studnet is logged in");
					logger.info(localtime+"/"+localtime.getDayOfWeek());
					StudentClient studentclient=new StudentClient();
					studentclient.main(username,password);
					break;
				}
			} catch (IncorrectPasswordException | UserNotFoundException e) {
				logger.error(e.getMessage());
			}
		}

	}

}
