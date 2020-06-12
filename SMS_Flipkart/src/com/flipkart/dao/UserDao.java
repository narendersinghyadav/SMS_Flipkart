package com.flipkart.dao;

import com.flipkart.model.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public User getPasswordByUsername(String username);
}
