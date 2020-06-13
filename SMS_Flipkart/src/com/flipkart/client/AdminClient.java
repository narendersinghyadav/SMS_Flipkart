package com.flipkart.client;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.service.AdminOperation;

public class AdminClient {
	private Logger logger=Logger.getLogger(AdminClient.class);
	public void main() {
		// TODO Auto-generated method stub
		AdminOperation adminoperation=new AdminOperation();
		
		Scanner scanner=new Scanner(System.in);
		//AdminInterfa
		int choice;
		do {
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
			
			choice=scanner.nextInt();
			switch(choice) {
			case 0:
				logger.info("adding student");
				logger.info("enter username for student");
				String username=scanner.next();
				logger.info("enter password for student");
				String password=scanner.next();
				logger.info("enter name of student");
				String name=scanner.next();
				logger.info("enter address of student");
				String address=scanner.next();
				logger.info("enter year of student");
				String year=scanner.next();
				logger.info("enter mobilenumber of student");
				String mobilenumber=scanner.next();
				logger.info("enter gender of student");
				String gender=scanner.next();
				adminoperation.addStudent(new Student(username,password,name,address,year,mobilenumber,gender));
				break;
			case 1:
				logger.info("adding professor");
				logger.info("enter username for professor");
				username=scanner.next();
				logger.info("enter password for professor");
				password=scanner.next();
				logger.info("enter name of professor");
				name=scanner.next();
				logger.info("enter address of professor");
				address=scanner.next();
				logger.info("enter mobilenumber of professor");
				 mobilenumber=scanner.next();
				adminoperation.addProfessor(new Professor(username,password,name,address,mobilenumber));
				break;
			case 2:
				logger.info("adding admin");
				logger.info("enter username for admin");
				username=scanner.next();
				logger.info("enter password for admin");
				password=scanner.next();
				logger.info("enter name of admin");
				name=scanner.next();
				logger.info("enter address of admin");
				address=scanner.next();
				logger.info("enter mobilenumber of admin");
				 mobilenumber=scanner.next();
				adminoperation.addAdmin(new Admin(username,password,name,address,mobilenumber));
				break;
			case 3:
				logger.info("updating  student");
				logger.info("enter username for student");
				username=scanner.next();
				logger.info("enter name of student");
				 name=scanner.next();
				logger.info("enter address of student");
				 address=scanner.next();
				logger.info("enter year of student");
				 year=scanner.next();
				logger.info("enter mobilenumber of student");
				 mobilenumber=scanner.next();
				logger.info("enter gender of student");
				 gender=scanner.next();
				adminoperation.updateStudent(new Student(username,"",name,address,year,mobilenumber,gender));
				break;
			case 4:
				logger.info("updating professor");
				logger.info("enter username for professor");
				username=scanner.next();
				logger.info("enter name of professor");
				name=scanner.next();
				logger.info("enter address of professor");
				address=scanner.next();
				logger.info("enter mobilenumber of professor");
				 mobilenumber=scanner.next();
				adminoperation.updateProfessor(new Professor(username,"",name,address,mobilenumber));
				break;
			case 5:
				logger.info("updating admin");
				logger.info("enter username for admin");
				username=scanner.next();
				logger.info("enter name of admin");
				name=scanner.next();
				logger.info("enter address of admin");
				address=scanner.next();
				logger.info("enter mobilenumber of admin");
				 mobilenumber=scanner.next();
				adminoperation.updateAdmin(new Admin(username,"",name,address,mobilenumber));
				break;
			case 6:
				logger.info("deleting student");
				logger.info("enter username of student");
				adminoperation.deleteStudent(new Student(scanner.next()));
				break;
			case 7:
				logger.info("deleting professor");
				logger.info("enter username of professor");
				adminoperation.deleteProfessor(new Professor(scanner.next()));
				break;
			case 8:
				logger.info("deleting admin");
				logger.info("enter username of admin");
				adminoperation.deleteAdmin(new Admin(scanner.next()));
				break;
			case 9:
				logger.info("add course to catalog");
				logger.info("enter course id ");
				int courseid=scanner.nextInt();
				logger.info("enter course name");
				String coursename=scanner.next();
				logger.info("enter course schedule");
				String courseschedule=scanner.next();
				adminoperation.addCourseToDb(new Course(courseid,coursename,courseschedule,0));
				break;
			case 10:
				logger.info("update course to catalog");
				logger.info("enter course id ");
				courseid=scanner.nextInt();
				logger.info("enter course name");
				coursename=scanner.next();
				logger.info("enter course schedule");
				courseschedule=scanner.next();
				adminoperation.updateCourseInDb(new Course(courseid,coursename,courseschedule,0));
				break;
			case 11:
				logger.info("deleteing course from catalog");
				logger.info("enter courseid");
				courseid=scanner.nextInt();
				adminoperation.deleteCourseFromDb(new Course(courseid,"","",0));
				break;
			case 12:
				adminoperation.listStudent();
				break;
			case 13:
				logger.info("admin logging out");
				logger.info(LocalDateTime.now()+"/"+LocalDateTime.now().getDayOfWeek());
				break;
			}
		}while(choice!=13);
	}

}
