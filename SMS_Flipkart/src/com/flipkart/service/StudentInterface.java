package com.flipkart.service;

public interface StudentInterface {
	public void addCourses(int courseid1,int courseid2,int courseid3,int courseid4);
	public void changeCourse(int courseid1,int courseid2,int courseid3,int courseid4);
	public void viewCatalog();
	public void chooseCourseSchedule(int courseid,String schedule);
	public void viewGrade();
	public void payFees();
	
}
