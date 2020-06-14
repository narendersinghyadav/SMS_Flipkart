package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;
import com.flipkart.service.StudentOperation;

//Functionality performed by Student
public class StudentClient {
	
	private Logger logger=Logger.getLogger(StudentClient.class);
	StudentOperation studentoperation=new StudentOperation();
	//Main function
	public void main(String username,String password) {
		
		logger.info("*************************");
		logger.info("Welecome to student login");
		logger.info("*************************");
		Student student=studentoperation.getStudentDetails(username, password);
		StudentOperation studentoperation=new StudentOperation();
		int choice;
		
		do {
			choice=getChoice();
			switch(choice) {
			case 0:
				//View all courses present in catalog
				studentoperation.viewCatalog();
				break;
			case 1:
				//Register course
				registerCourse(student);
				break;
			case 2:
				//View grades given by professor
				viewGrade(student);
				break;
			case 3:
				//View registered courses
				viewSelectedCourses(username);
				break;
			case 4:
				//Logout
				logger.info("Student logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());

				break;
			}
		}while(choice!=4);
	}
	
	//Enter choice
	public int getChoice() {
		Scanner scanner=new Scanner(System.in);
		logger.info("press 0 for view catalog");
		logger.info("press 1 for register course");
		logger.info("press 2 for view grades");
		logger.info("press 3 to view added courses");
		logger.info("press 4 for logout");
		return scanner.nextInt();
	}

	//Register course
	public void registerCourse(Student student) {
		Scanner scanner=new Scanner(System.in);
		logger.info("Press 0 for add courses");
		logger.info("Press 1 for update course");
		logger.info("Press 2 for pay fess");
		int choice=scanner.nextInt();

		switch(choice) {
		//add course for registration
		case 0:
			logger.info("Enter courseid1");
			int courseid1=scanner.nextInt();
			logger.info("Enter courseid2");
			int courseid2=scanner.nextInt();
			logger.info("Enter courseid3");
			int courseid3=scanner.nextInt();
			logger.info("Enter courseid4");
			int courseid4=scanner.nextInt();

			studentoperation.addCourses(student, courseid1, courseid2, courseid3, courseid4);
			break;
		//update courses during regisration
		case 1:
			logger.info("Enter courseid1");
			courseid1=scanner.nextInt();
			logger.info("Enter courseid2");
			courseid2=scanner.nextInt();
			logger.info("Enter courseid3");
			courseid3=scanner.nextInt();
			logger.info("Enter courseid4");
			courseid4=scanner.nextInt();
			studentoperation.changeCourse(student, courseid1, courseid2, courseid3, courseid4);           
			break;
		//fees payment
		case 2:
			logger.info("Fees payment started");
			studentoperation.payFees();
		}
	}

	//view grades given by professor
	public void viewGrade(Student student) {
		studentoperation.viewGrade(student);
	}
	
	//View selected courses by student
	private void viewSelectedCourses(String username) {
		// TODO Auto-generated method stub
		studentoperation.viewSelectedCourses(username);
	}

}
