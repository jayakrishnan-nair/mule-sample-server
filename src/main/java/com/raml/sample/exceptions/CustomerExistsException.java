package com.raml.sample.exceptions;

/**
 * Exception class for handling scenarios, where a new customer is being added  with an existing id.
 * @author Jay
 *
 */
public class CustomerExistsException extends Exception {

	public CustomerExistsException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
