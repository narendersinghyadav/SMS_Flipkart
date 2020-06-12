package com.flipkart.dao;


import com.flipkart.model.Student;

public interface StudentDao {
	public boolean addCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public boolean updateCourse(Student student,int courseid1,int courseid2,int courseid3,int courseid4);
	public boolean updateCourseSchedule(Student student,String course1schedule,String course2schedule,String course3schedule,String course4schedule);
	public Student listGrade(Student student);
	public void payFees(Student student);
}
