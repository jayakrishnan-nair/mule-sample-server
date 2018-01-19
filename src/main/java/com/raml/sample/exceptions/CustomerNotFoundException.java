package com.raml.sample.exceptions;

/**
 * Exception class for handling searches, updates and deletes where customer does not exists
 * @author Jay
 *
 */
public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
