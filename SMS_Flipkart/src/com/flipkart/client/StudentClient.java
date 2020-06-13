package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;
import com.flipkart.service.StudentOperation;

public class StudentClient {
	private Logger logger=Logger.getLogger(StudentClient.class);

	StudentOperation studentoperation=new StudentOperation();
	public int getChoice() {
		Scanner scanner=new Scanner(System.in);
		logger.info("press 0 for view catalog");
		logger.info("press 1 for register course");
		logger.info("press 2 for view grades");
		logger.info("press 3 for logout");
		return scanner.nextInt();
	}

	public void registerCourse(Student student) {
		Scanner scanner=new Scanner(System.in);
		logger.info("press 0 for add courses");
		logger.info("press 1 for update course");
		logger.info("press 2 for pay fess");
		int choice=scanner.nextInt();

		switch(choice) {
		case 0:
			logger.info("enter courseid1");
			int courseid1=scanner.nextInt();
			logger.info("enter courseid2");
			int courseid2=scanner.nextInt();
			logger.info("enter courseid3");
			int courseid3=scanner.nextInt();
			logger.info("enter courseid4");
			int courseid4=scanner.nextInt();

			studentoperation.addCourses(student, courseid1, courseid2, courseid3, courseid4);
			break;
		case 1:
			logger.info("enter courseid1");
			courseid1=scanner.nextInt();
			logger.info("enter courseid2");
			courseid2=scanner.nextInt();
			logger.info("enter courseid3");
			courseid3=scanner.nextInt();
			logger.info("enter courseid4");
			courseid4=scanner.nextInt();
			studentoperation.changeCourse(student, courseid1, courseid2, courseid3, courseid4);           
			break;
		case 2:
			logger.info("fees payment started");
			studentoperation.payFees();
		}
	}

	public void viewGrade(Student student) {
		studentoperation.viewGrade(student);
	}
	public void main(String username,String password) {
		logger.info("Welecome to student login");
		Student student=studentoperation.getStudentDetails(username, password);
		StudentOperation studentoperation=new StudentOperation();
		int choice;
		do {
			choice=getChoice();
			switch(choice) {
			case 0:
				studentoperation.viewCatalog();
				break;
			case 1:
				registerCourse(student);
				break;
			case 2:
				viewGrade(student);
				break;
			case 3:
				logger.info("Student logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());

				break;
			}
		}while(choice!=3);
	}
}
