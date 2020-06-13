package com.flipkart.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public class AdminOperation implements AdminInterface{
	private Logger logger=Logger.getLogger(AdminOperation.class);
	AdminDao admindao=new AdminDaoImpl();
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		if(admindao.insertStudent(student)) {
			logger.info(student.getUsername()+" added successfully");
		}
		else {
			logger.error(student.getUsername()+" not added successfully");
		}
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		if(admindao.dropStudent(student)) {
			logger.info(student.getUsername()+" deleted successfully");
		}
		else {
			logger.error("error in deletion");
		}
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		if(admindao.updateStudent(student)) {
			logger.info(student.getUsername()+" updated successfully");
		}
		else {
			logger.info(student.getUsername()+" not updated");
		}
		
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		if(admindao.insertProfessor(professor)) {
			logger.info(professor.getUsername()+" added successfully");
		}
		else {
			logger.error(professor.getUsername()+" not added successfully");
		}
	}

	@Override
	public void deleteProfessor(Professor professor) {
		// TODO Auto-generated method stub
		if(admindao.dropProfessor(professor)) {
			logger.info(professor.getUsername()+" deleted successfully");
		}
		else {
			logger.error(professor.getUsername()+" not deleted successfully");
		}
	}

	@Override
	public void updateProfessor(Professor professor) {
		// TODO Auto-generated method stub
		if(admindao.updateProfessor(professor)) {
			logger.info(professor.getUsername()+" updated successfully");
		}
		else {
			logger.error(professor.getUsername()+" not updated successfully");
		}
	}

	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admindao.insertAdmin(admin)) {
			logger.info(admin.getUsername()+" added successfully");
		}
		else {
			logger.error(admin.getUsername()+" not added successfully");
		}
	}

	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admindao.dropAdmin(admin)) {
			logger.info(admin.getUsername()+" deleted successfully");
		}
		else {
			logger.error(admin.getUsername()+" not deleted successfully");
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		if(admindao.updateAdmin(admin)) {
			logger.info(admin.getUsername()+" updated successfully");
		}
		else {
			logger.error(admin.getUsername()+" not updated successfully");
		}
	}

	@Override
	public void addCourseToDb(Course course) {
		// TODO Auto-generated method stub
		if(admindao.insertCourseToDb(course)) {
			logger.info(course.getCourseName()+" course added successfully");
		}
		else {
			logger.error(course.getCourseName()+"course not added successfully");
		}
	}

	@Override
	public void deleteCourseFromDb(Course course) {
		// TODO Auto-generated method stub
		if(admindao.dropCourseFromDb(course)) {
			logger.info(course.getCourseName()+" course deleted successfully");
		}
		else {
			logger.error(course.getCourseName()+"course not deleted successfully");
		}
	}

	@Override
	public void updateCourseInDb(Course course) {
		// TODO Auto-generated method stub
		if(admindao.updateCourseInDb(course)) {
			logger.info(course.getCourseName()+" updated successfully");
		}
		else {
			logger.error(course.getCourseName()+" not updated successfully");
		}
	}

	@Override
	public void listStudent() {
		// TODO Auto-generated method stub\\\\\
		List<Student> studentlist=admindao.fetchStudent();
		logger.info(String.format("username    name    address  year   mobilenumber"));
		
		List<Student> studentfemale=studentlist.stream().filter(student->student.getGender().equalsIgnoreCase("f")).flatMap(
		student->Stream.of(new Student(student.getUsername(),""," Ms."+student.getStudentname(),student.getStudentaddress(),student.getStudentyear(),student.getStudentmobilenumber(),student.getGender())))
		.collect(Collectors.toList());
		studentfemale.forEach(list->logger.info(list.getUsername()+" "+list.getStudentname()+" "+list.getStudentaddress()+" "+list.getStudentyear()+" "+list.getStudentmobilenumber()));
		
		List<Student> studentmale=studentlist.stream().filter(student->student.getGender().equalsIgnoreCase("m")).flatMap(
				student->Stream.of(new Student(student.getUsername(),""," Mr."+student.getStudentname(),student.getStudentaddress(),student.getStudentyear(),student.getStudentmobilenumber(),student.getGender())))
				.collect(Collectors.toList());
				studentmale.forEach(list->logger.info(list.getUsername()+" "+list.getStudentname()+" "+list.getStudentaddress()+" "+list.getStudentyear()+" "+list.getStudentmobilenumber()));
	}

}
