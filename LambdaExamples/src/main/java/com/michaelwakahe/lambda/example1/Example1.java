package com.michaelwakahe.lambda.example1;

/**
 * A simple example. Lambda expressions are also commonly referred to as closures.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		// Here, the lambda expression is simply a constant expression.
		MyNumber myNum = () -> 123.45;		
		System.out.println("The 1st expression: " + myNum.getValue());
		
		
		// Here, a more complex expression is used.
		myNum = () -> Math.random() * 100;
		System.out.println("A random value: " + myNum.getValue());
		System.out.println("Another random value: " + myNum.getValue());
		
		// A lambda expression must be compatible with the method
		// defined by the functional interface. Therefore, this won't work:
		//myNum = () -> "123.03"; // Error!
	}

}
