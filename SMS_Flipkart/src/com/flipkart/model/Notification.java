package com.flipkart.model;

import org.apache.log4j.Logger;

public class Notification {
	private Logger logger =Logger.getLogger(Notification.class);
	
	private String message;
	public Notification( String message) {
		this.message = message;
	}
	public void displayMessage() {
		logger.info(message);
	}
}
