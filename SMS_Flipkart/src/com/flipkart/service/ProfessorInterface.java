package com.flipkart.service;

import com.flipkart.model.Student;

//Functionality by professor
public interface ProfessorInterface {
	
	//View enrolled students in a particular course
	public void viewEnrolledStudents(int courseid);
	//Upload grades
	public void updateGrade(int grade,Student student,int courseid);
	//Choose course for teaching
	public void chooseCourse(String professorusername,int courseid);
	//View choosed courses for teaching
	public void viewSelectedCourse(String username);
}
