package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface ProfessorDao {
	public List<Integer> listEnrolledStudents(int courseid);
	public boolean addGrade(int grade,Student student,int courseid);
	public boolean chooseCourse(String professor,int courseid);
}
