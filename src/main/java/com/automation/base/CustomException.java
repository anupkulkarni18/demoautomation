package com.automation.base;

import org.apache.log4j.Logger;

/**
 * Handle the custom exceptions
 * 
 * @author bharatp Date: 29 June 2017
 */
public class CustomException extends Exception {
	
	final static Logger LOGGER = Logger.getLogger(CustomException.class.getName());
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
}
