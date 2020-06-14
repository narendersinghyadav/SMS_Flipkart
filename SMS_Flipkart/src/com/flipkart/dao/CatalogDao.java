package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;

//CatalogDao interface
public interface CatalogDao {
	//List all courses
	public List<Course> getCatalog();
	//Increase number of students in catalog  by 1
	public boolean increaseNumberOfStudents(int courseid);
	//Decrease number of students in catalog by 1
	public boolean decreaseNumberOfStudents(int courseid);
}
