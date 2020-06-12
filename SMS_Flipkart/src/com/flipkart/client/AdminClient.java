package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.service.AdminOperation;

public class AdminClient {
	private Logger logger=Logger.getLogger(AdminClient.class);
	public void main(String username,String password) {
		// TODO Auto-generated method stub
		logger.info("welcome to admin");
		logger.info("press 0 for adding student");
		logger.info("press 1 for adding professor");
		logger.info("press 2 for adding admin");
		logger.info("press 3 for update student");
		logger.info("press 4 for update professor");
		logger.info("press 5 for update admin");
		logger.info("press 6 for delete student");
		logger.info("press 7 for delete professor");
		logger.info("press 8 for delete admin");
		logger.info("press 9 to add course to catalog");
		logger.info("press 10 to update course in catalog");
		logger.info("press 11 to delete course from catalog");
		logger.info("press 12 to view student details");
		logger.info("press 13 to logout");
		Scanner scanner=new Scanner(System.in);
		//AdminInterfa
		int choice;
		do {
			choice=scanner.nextInt();
			switch(choice) {
			case 0:
				//AdminOpe
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				AdminOperation adminoperation=new AdminOperation();
				adminoperation.listStudent();
				break;
			}
		}while(choice!=13);
	}

}
