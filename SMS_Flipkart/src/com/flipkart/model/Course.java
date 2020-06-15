package com.flipkart.model;

//Course class model
public class Course {
	
	//Properties
	private int courseId;
	private String courseName;
	private String courseSchedule;
	private int numberOfStudents;
	private int fees;
	
	//Constructor
	public Course(int courseId,String courseName,String courseSchedule,int numberofstudents,int fees) {
		this.courseId=courseId;
		this.courseName=courseName;
		this.courseSchedule=courseSchedule;
		this.numberOfStudents=numberofstudents;
		this.fees=fees;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	//Getter and Setter
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
