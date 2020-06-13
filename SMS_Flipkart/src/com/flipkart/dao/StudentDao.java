package com.flipkart.dao;


import com.flipkart.model.Student;

public interface StudentDao {
	public Student getStudentInfo(String username,String password);
	public boolean addCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public boolean updateCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public Student listGrade(Student student);
	public void payFees(Student student);
}
