package com.flipkart.model;

import org.apache.log4j.Logger;

//Notification class
public class Notification {
	private Logger logger =Logger.getLogger(Notification.class);

	private String message;
	public Notification( String message) {
		this.message = message;
	}
	//Display notification message
	public void displayMessage() {
		logger.info(message);
	}
}
