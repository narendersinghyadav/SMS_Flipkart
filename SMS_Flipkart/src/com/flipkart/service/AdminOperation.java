package com.flipkart.service;

import java.util.List;

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
		
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfessor(Professor pprofessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdmin(Admin professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(Admin professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdmin(Admin pprofessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourseToDb(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourseFromDb(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourseInDb(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listStudent() {
		// TODO Auto-generated method stub\\\\\
		List<Student> studentlist=admindao.fetchStudent();
		studentlist.forEach(list->logger.info(list.getUsername()+" "+list.getStudentname()));
		
	}

}
