package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.IncorrectPasswordException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.User;

public class CheckIdentity {


	UserDaoImpl userdao=new UserDaoImpl();
	Logger logger=Logger.getLogger(CheckIdentity.class);

	public int checkIdentity(String username,String password) throws IncorrectPasswordException, UserNotFoundException {
		User user=userdao.getPasswordByUsername(username);
		if(user.getPassword().equals("")) {
			throw new UserNotFoundException(username);
		}
		else if(user.getPassword().equals(password)) {
			return user.getRole();
		}
		else {
			throw new IncorrectPasswordException(username);

		}

	}
}
