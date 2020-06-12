package com.flipkart.dao;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface AdminDao {
	public boolean insertStudent(Student student);
	public boolean dropStudent(Student student);
	public boolean updateStudent(Student student);
	
	public boolean insertProfessor(Professor professor);
	public boolean dropProfessor(Professor professor);
	public boolean updateProfessor(Professor pprofessor);
	
	public boolean insertAdmin(Admin professor);
	public boolean dropAdmin(Admin professor);
	public boolean updateAdmin(Admin pprofessor);
	
	public boolean insertCourseToDb(Course course);
	public boolean dropCourseFromDb(Course course);
	public boolean updateCourseInDb(Course course);
}
