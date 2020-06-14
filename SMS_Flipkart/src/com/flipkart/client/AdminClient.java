package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.CourseCatalog;

//	Functionality performed by admin

public class AdminClient {
	private Logger logger=Logger.getLogger(AdminClient.class);
	AdminOperation adminoperation=new AdminOperation();		
	Scanner scanner=new Scanner(System.in);
	//main function for  admin 
	public void main() {


		int choice;

		do {
			logger.info("************************");
			logger.info("Welcome to admin portal");
			logger.info("************************");
			logger.info("Press 0 for adding student");
			logger.info("Press 1 for adding professor");
			logger.info("Press 2 for adding admin");
			logger.info("Press 3 for update student");
			logger.info("Press 4 for update professor");
			logger.info("Press 5 for update admin");
			logger.info("Press 6 for delete student");
			logger.info("Press 7 for delete professor");
			logger.info("Press 8 for delete admin");
			logger.info("Press 9 to add course to catalog");
			logger.info("Press 10 to update course in catalog");
			logger.info("Press 11 to delete course from catalog");
			logger.info("Press 12 to view student details");
			logger.info("Press 13 to view Courses");
			logger.info("Press 14 to logout");

			choice=scanner.nextInt();
			switch(choice) {

			case 0:
				//add student
				addStudent();
				break;
			case 1:
				//Add professsor
				addProfessor();
				break;
			case 2:
				//Add admin
				addAdmin();
				break;
			case 3:
				//Update Student Info
				updateStudent();
				break;
			case 4:
				//Update Professor Info
				updateProfessor();
				break;
			case 5:
				//Update admin Info
				updateAdmin();
				break;
			case 6:
				//Delete student from database
				deleteStudent();
				break;
			case 7:
				//Delete Professor
				deleteProfessor();
				break;
			case 8:
				//Delete admin
				deleteAdmin();
				break;
			case 9:
				//Add courses to catalog
				addCourse();
				break;
			case 10:
				//Update course details
				updateCourse();
				break;
			case 11:
				//Delete course from catalog
				deleteCourse();
				break;
			case 12:
				//List all student
				viewAllStudents();
				break;
			case 13:
				//View Course
				viewAllCourses();
				break;
			case 14:
				//Admin logout
				logger.info("admin logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());
				break;
			}
		}while(choice!=14);
	}

	// Add student
	public void addStudent() {
		logger.info("Adding student");
		logger.info("Enter username for student");
		String username=scanner.next();
		logger.info("Enter password for student");
		String password=scanner.next();
		logger.info("Enter name of student");
		String name=scanner.next();
		logger.info("Enter address of student");
		String address=scanner.next();
		logger.info("Enter year of student");
		String year=scanner.next();
		logger.info("Enter mobilenumber of student");
		String mobilenumber=scanner.next();
		logger.info("Enter gender of student(m for male/f for female)");
		String gender=scanner.next();
		adminoperation.addStudent(new Student(username,password,name,address,year,mobilenumber,gender));
	}

	//Add professor
	public void addProfessor() {

		logger.info("Adding professor");
		logger.info("Enter username for professor");
		String username=scanner.next();
		logger.info("Enter password for professor");
		String password=scanner.next();
		logger.info("Enter name of professor");
		String name=scanner.next();
		logger.info("Enter address of professor");
		String address=scanner.next();
		logger.info("Enter mobilenumber of professor");
		String mobilenumber=scanner.next();
		adminoperation.addProfessor(new Professor(username,password,name,address,mobilenumber));
	}

	//Add admin
	public void addAdmin() {
		logger.info("Adding admin");
		logger.info("Enter username for admin");
		String username=scanner.next();
		logger.info("Enter password for admin");
		String password = scanner.next();
		logger.info("Enter name of admin");
		String name = scanner.next();
		logger.info("Enter address of admin");
		String address = scanner.next();
		logger.info("Enter mobilenumber of admin");
		String mobilenumber = scanner.next();
		adminoperation.addAdmin(new Admin(username,password,name,address,mobilenumber));
	}

	//Update Student Info
	public void updateStudent() {

		logger.info("Updating  student");
		logger.info("Enter username for student");
		String username = scanner.next();
		logger.info("Enter name of student");
		String name = scanner.next();
		logger.info("Enter address of student");
		String address = scanner.next();
		logger.info("Enter year of student");
		String year = scanner.next();
		logger.info("Enter mobilenumber of student");
		String mobilenumber = scanner.next();
		logger.info("Enter gender of student(m for male/f for female)");
		String gender = scanner.next();
		adminoperation.updateStudent(new Student(username,"",name,address,year,mobilenumber,gender));
	}

	//Update Professor Info
	public void updateProfessor() {

		logger.info("Updating professor");
		logger.info("Enter username for professor");
		String username = scanner.next();
		logger.info("Enter name of professor");
		String name = scanner.next();
		logger.info("Enter address of professor");
		String address = scanner.next();
		logger.info("Enter mobilenumber of professor");
		String mobilenumber = scanner.next();
		adminoperation.updateProfessor(new Professor(username,"",name,address,mobilenumber));
	}

	//Update admin Info
	public void updateAdmin() {

		logger.info("Updating admin");
		logger.info("Enter username for admin");
		String username = scanner.next();
		logger.info("Enter name of admin");
		String name = scanner.next();
		logger.info("Enter address of admin");
		String address = scanner.next();
		logger.info("Enter mobilenumber of admin");
		String mobilenumber = scanner.next();
		adminoperation.updateAdmin(new Admin(username,"",name,address,mobilenumber));
	}

	//Delete student from database
	public void deleteStudent() {
		logger.info("Deleting student");
		logger.info("Enter username of student");
		adminoperation.deleteStudent(new Student(scanner.next()));
	}

	//Delete Professor
	public void deleteProfessor() {

		logger.info("Deleting professor");
		logger.info("Enter username of professor");
		adminoperation.deleteProfessor(new Professor(scanner.next()));
	}

	//Delete admin
	public void deleteAdmin() {
		logger.info("Deleting admin");
		logger.info("Enter username of admin");
		adminoperation.deleteAdmin(new Admin(scanner.next()));
	}

	//Add courses to catalog
	public void addCourse() {
		logger.info("Add course to catalog");
		logger.info("Enter course id ");
		int courseid=scanner.nextInt();
		logger.info("Enter course name");
		String coursename=scanner.next();
		logger.info("Enter course schedule");
		String courseschedule=scanner.next();
		adminoperation.addCourseToDb(new Course(courseid,coursename,courseschedule,0));
	}

	//Update course details
	public void updateCourse() {
		logger.info("Update course to catalog");
		logger.info("Enter course id ");
		int courseid = scanner.nextInt();
		logger.info("Enter course name");
		String coursename = scanner.next();
		logger.info("Enter course schedule");
		String courseschedule = scanner.next();
		adminoperation.updateCourseInDb(new Course(courseid,coursename,courseschedule,0));
	}

	//Delete course from catalog
	public void deleteCourse() {
		logger.info("Deleteing course from catalog");
		logger.info("Enter courseid");
		int courseid = scanner.nextInt();
		adminoperation.deleteCourseFromDb(new Course(courseid,"","",0));
	}

	//List all student
	public void viewAllStudents() {
		logger.info("Listing students");
		adminoperation.listStudent();
	}

	//View Course
	public void viewAllCourses() {
		logger.info("View Course catalog");
		CourseCatalog coursecatalog=new CourseCatalog();
		coursecatalog.SearchValidCourse();
	}


}
