package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.StudentOperation;

public class ProfessorClient {
	private Logger logger =Logger.getLogger(ProfessorClient.class);
	public void main(String username,String password) {
		// TODO Auto-generated method stub
		ProfessorInterface professoroperation=new ProfessorOperation();
		logger.info("welcome to professor portal");
		Scanner scanner=new Scanner(System.in);
		int choice;
		do {
			logger.info("enter 0 for getting course list");
			logger.info("enter 1 for getting list of enrolled students");
			logger.info("enter 2 for selecting course for teaching");
			logger.info("enter 3 for uploading grades");
			logger.info("enter 4 for logout");
			choice=scanner.nextInt();
			switch(choice){
			case 0:
				StudentOperation studentoperation=new StudentOperation();
				studentoperation.viewCatalog();
				break;
			case 1:
				logger.info("enter courseid of which you want students:");
				int courseid=scanner.nextInt();
				professoroperation.viewEnrolledStudents(courseid);
				break;
			case 2:
				logger.info("enter course id for teaching");
				courseid=scanner.nextInt();
				professoroperation.chooseCourse(username,courseid);
				break;
			case 3:
				logger.info("uploading grades");
				logger.info("enter student username for grade updation");
				String student=scanner.next();
				logger.info("enter course id ");
				courseid=scanner.nextInt();
				logger.info("enter grade ");
				int grade=scanner.nextInt();
				professoroperation.updateGrade(grade, new Student(student), courseid);
				break;
			case 4:
				logger.info("professor logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());
				break;
			}
		}while(choice!=4);
		}

}
