package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.exception.IncorrectPasswordException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.service.CheckIdentity;
import com.flipkart.service.CourseCatalog;
import com.flipkart.service.StudentOperation;

public class UserClient {
	private static Logger logger=Logger.getLogger(UserClient.class);
	
	public static void main(String args[]) {
		String username;
		String password;
		//input
		Scanner scanner=new Scanner(System.in);
		while(true) {
		logger.info("Login portal");
		logger.info("enter username and password");
		username=scanner.next();
		password=scanner.next();
		CheckIdentity checkidentity=new CheckIdentity();
		LocalDateTime localtime=LocalDateTime.now();
		///checking identity
		try {
			int role=checkidentity.checkIdentity(username, password);
			switch(role){
			case 1:
				logger.info("admin is logged in");
				logger.info(localtime+"/"+localtime.getDayOfWeek());
				AdminClient adminclient=new AdminClient();
				adminclient.main(username,password);
				break;
			case 2:
				logger.info("professor is logged in");
				logger.info(localtime+"/"+localtime.getDayOfWeek());
				ProfessorClient professorclient=new ProfessorClient();
				professorclient.main(username,password);
			case 3:
				logger.info("studnet is logged in");
				logger.info(localtime+"/"+localtime.getDayOfWeek());
				StudentClient studentclient=new StudentClient();
				studentclient.main(username,password);
				break;
			}
		} catch (IncorrectPasswordException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}finally {
			scanner.close();
		}
	}
	}
}
