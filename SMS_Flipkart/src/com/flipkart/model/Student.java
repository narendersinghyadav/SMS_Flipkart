package com.flipkart.model;
//Student class
public class Student extends User{
	private int studentId;
	private String studentName;
	private String studentAddress;
	private String studentYear;
	private String studentMobilenumber;
	private int course1grade;
	private int course2grade;
	private int course3grade;
	private int course4grade;
	
	public Student(String username,String password,int studentId,String studentName,String studentAddress,String studentYear,String studentMobilenumber) {
		super(username,password);
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentAddress=studentAddress;
		this.studentYear=studentYear;
		this.studentMobilenumber=studentMobilenumber;
	}
	
	public int getCourse1grade() {
		return course1grade;
	}
	public void setCourse1grade(int course1grade) {
		this.course1grade = course1grade;
	}
	public int getCourse2grade() {
		return course2grade;
	}
	public void setCourse2grade(int course2grade) {
		this.course2grade = course2grade;
	}
	public int getCourse3grade() {
		return course3grade;
	}
	public void setCourse3grade(int course3grade) {
		this.course3grade = course3grade;
	}
	public int getCourse4grade() {
		return course4grade;
	}
	public void setCourse4grade(int course4grade) {
		this.course4grade = course4grade;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentName;
	}
	public void setStudentname(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentaddress() {
		return studentAddress;
	}
	public void setStudentaddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentyear() {
		return studentYear;
	}
	public void setStudentyear(String studentYear) {
		this.studentYear = studentYear;
	}
	public String getStudentmobilenumber() {
		return studentMobilenumber;
	}
	public void setStudentmobilenumber(String studentMobilenumber) {
		this.studentMobilenumber = studentMobilenumber;
	}
	
}
