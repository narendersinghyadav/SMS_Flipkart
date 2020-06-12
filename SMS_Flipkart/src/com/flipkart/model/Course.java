package com.flipkart.model;

public class Course {
	private int courseId;
	private String courseName;
	private String courseSchedule;
	private int numberOfStudents;
	
	public Course(int courseId,String courseName,String courseSchedule,int numberofstudents) {
		this.courseId=courseId;
		this.courseName=courseName;
		this.courseSchedule=courseSchedule;
		this.numberOfStudents=numberofstudents;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSchedule() {
		return courseSchedule;
	}
	public void setCourseSchedule(String courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
}
