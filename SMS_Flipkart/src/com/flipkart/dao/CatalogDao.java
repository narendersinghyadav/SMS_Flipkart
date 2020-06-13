package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;

public interface CatalogDao {
	public List<Course> getCatalog();
	public boolean updateNumberOfStudents(int courseid);
}
