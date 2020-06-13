package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface ProfessorDao {
	public List<Student> listEnrolledStudents(int courseid);
	public boolean addGrade(int grade,Student student,int courseid);
	public boolean chooseCourse(String professor,int courseid);
	public List<Course> viewSelectedCourses(String username);
}
