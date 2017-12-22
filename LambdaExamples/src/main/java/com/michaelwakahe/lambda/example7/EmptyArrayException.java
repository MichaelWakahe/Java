package com.michaelwakahe.lambda.example7;

/**
 * A custom exception
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class EmptyArrayException extends Exception {

	/**
	 * 
	 */
	public EmptyArrayException() {
		super("Array Empty");
	}
}
