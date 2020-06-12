package com.flipkart.service;

import com.flipkart.model.Student;

public interface ProfessorInterface {
	public void viewEnrolledStudents(int courseid);
	public void updateGrade(int grade,Student student);
	public void chooseCourse(int courseid);
}
