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
		logger.info("press 2 for change schedule");
		logger.info("press 3 for view grades");
		logger.info("press 4 for logout");
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
			logger.info("enter courseid1,courseid2,courseid3,courseid4");
			int courseid1=scanner.nextInt();
			int courseid2=scanner.nextInt();
			int courseid3=scanner.nextInt();
			int courseid4=scanner.nextInt();
			
			studentoperation.addCourses(student, courseid1, courseid2, courseid3, courseid4);
			break;
		case 1:
			logger.info("enter courseid1,courseid2,courseid3,courseid4");
			 courseid1=scanner.nextInt();
			 courseid2=scanner.nextInt();
			 courseid3=scanner.nextInt();
			courseid4=scanner.nextInt();
			studentoperation.changeCourse(student, courseid1, courseid2, courseid3, courseid4);           
			break;
		case 2:
			logger.info("fees payment started");
			studentoperation.payFees();
		}
	}
	
	public void changeSchedule(Student student) {
		Scanner scanner=new Scanner(System.in);
		logger.info("enter courseid of which you want to change schedule");
		int courseid=scanner.nextInt();
		logger.info("enter schedule ");
		String schedule=scanner.next();
		studentoperation.chooseCourseSchedule(student, courseid, schedule);
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
				changeSchedule(student);
				break;
			case 3:
				viewGrade(student);
				break;
			case 4:
				logger.info("Student logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());
				
				break;
		}
	}while(choice!=4);
	}
}
