package com.raml.sample.exceptions;

/**
 * A General Exception class. Can be used , if a generic exception needs to be handled
 * @author Jay
 *
 */
public class CustomerAPIException extends Exception {

	public CustomerAPIException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
