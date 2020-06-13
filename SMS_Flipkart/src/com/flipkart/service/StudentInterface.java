package com.flipkart.service;

import com.flipkart.model.Student;

public interface StudentInterface {
	public void addCourses(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public void changeCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public void viewCatalog();
	public void viewGrade(Student student);
	public void payFees();
	public Student getStudentDetails(String username,String password);
}
