package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.flipkart.model.Student;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.StudentOperation;

//Functionality performed by Professor
public class ProfessorClient {
	//Apache Logger
	private Logger logger =Logger.getLogger(ProfessorClient.class);
	Scanner scanner=new Scanner(System.in);
	ProfessorInterface professoroperation=new ProfessorOperation();

	//Main function
	public void main(String username,String password) {
		logger.info("****************************");
		logger.info("welcome to professor portal");
		logger.info("****************************");
		int choice;

		do {
			logger.info("Enter 0 for getting course list");
			logger.info("Enter 1 for getting list of enrolled students");
			logger.info("Enter 2 for selecting course for teaching");
			logger.info("Enter 3 for uploading grades");
			logger.info("Enter 4 to view your selected courses for teaching");
			logger.info("Enter 5 for logout");
			choice=scanner.nextInt();
			switch(choice){
			case 0:
				//View course list
				viewCourses();
				break;
			case 1:
				//View enrolled students by course id
				viewEnrolledStudent();
				break;
			case 2:
				//Choose course for teaching
				chooseCourse(username);
				break;
			case 3:
				//Professor can upload grades
				uploadGrade();
				break;
			case 4:
				//View courses selected for teaching
				selectedCourses(username);
				break;
			case 5:
				//Professor logout
				logger.info("Professor logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());
				break;
			}
		}while(choice!=5);
	}

	//View course list
	public void viewCourses() {
		logger.info("Viewing course list");
		StudentOperation studentoperation=new StudentOperation();
		studentoperation.viewCatalog();
	}

	//View enrolled students using course id
	public void viewEnrolledStudent() {

		logger.info("Viewing enrolled students list");
		logger.info("Enter courseid of which you want students:");
		int courseid=scanner.nextInt();
		professoroperation.viewEnrolledStudents(courseid);
	}

	//Choose course for teaching
	public void chooseCourse(String username) {	
		logger.info("Choose course for teaching");
		logger.info("Enter course id for teaching");
		int courseid = scanner.nextInt();
		professoroperation.chooseCourse(username,courseid);
	}

	//Professor can upload grades
	public void uploadGrade() {
		logger.info("Uploading grades");
		logger.info("Enter student username for grade updation");
		String student=scanner.next();
		logger.info("Enter course id ");
		int courseid = scanner.nextInt();
		logger.info("Enter grade ");
		int grade=scanner.nextInt();
		professoroperation.updateGrade(grade, new Student(student), courseid);
	}
	//View courses selected for teaching
	public void selectedCourses(String username) {
		logger.info("Here are your Courses");
		professoroperation.viewSelectedCourse(username);
	}
}
