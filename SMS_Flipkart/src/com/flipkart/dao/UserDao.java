package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.User;

public interface UserDao {
	public User getPasswordByUsername(String username);
	public List<Course> getCatalog();
}
