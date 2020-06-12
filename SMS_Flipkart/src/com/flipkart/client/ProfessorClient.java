package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ProfessorClient {
	private Logger logger =Logger.getLogger(ProfessorClient.class);
	public void main(String username,String password) {
		// TODO Auto-generated method stub
		
		logger.info("welcome to professor portal");
		Scanner scanner=new Scanner(System.in);
		logger.info("enter 0 for getting list of enrolled students");
		int choice=scanner.nextInt();
		do {
			switch(choice){
			case 0:
				break;
			}
		}while(choice!=4);
		}

}
