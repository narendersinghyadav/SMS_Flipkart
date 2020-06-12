package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface AdminInterface {
	public void addStudent(Student student);
	public void deleteStudent(Student student);
	public void updateStudent(Student student);
	
	public void addProfessor(Professor professor);
	public void deleteProfessor(Professor professor);
	public void updateProfessor(Professor pprofessor);
	
	public void addAdmin(Admin professor);
	public void deleteAdmin(Admin professor);
	public void updateAdmin(Admin professor);
	
	public void addCourseToDb(Course course);
	public void deleteCourseFromDb(Course course);
	public void updateCourseInDb(Course course);
	
	public void listStudent(); 
	
	
}
