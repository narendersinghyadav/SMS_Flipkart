package com.flipkart.service;

import com.flipkart.model.Admin;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

//Admin functionality interface
public interface AdminInterface {
	//Add/Delete/Update student
	public void addStudent(Student student);
	public void deleteStudent(Student student);
	public void updateStudent(Student student);

	///Add/Delete/Update Professor
	public void addProfessor(Professor professor);
	public void deleteProfessor(Professor professor);
	public void updateProfessor(Professor pprofessor);

	//Add/Delete/Update admin
	public void addAdmin(Admin professor);
	public void deleteAdmin(Admin professor);
	public void updateAdmin(Admin professor);

	//Add/Delete/update courses in catalog
	public void addCourseToDb(Course course);
	public void deleteCourseFromDb(Course course);
	public void updateCourseInDb(Course course);

	//List of all students
	public void listStudent(); 


}
