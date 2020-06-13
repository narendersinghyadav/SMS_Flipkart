package com.flipkart.service;

import com.flipkart.model.Student;

public interface ProfessorInterface {
	public void viewEnrolledStudents(int courseid);
	public void updateGrade(int grade,Student student,int courseid);
	public void chooseCourse(String professorusername,int courseid);
	public void viewSelectedCourse(String username);
}
