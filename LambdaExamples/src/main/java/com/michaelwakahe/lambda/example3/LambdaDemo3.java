package com.michaelwakahe.lambda.example3;

/**
 * Demonstrate a lambda expression that takes two parameters.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class LambdaDemo3 {

	public static void main(String args[]) {
		// This lambda expression determines if one number is
		// a factor of another.
		NumericTest2 isFactor = (n, d) -> (n % d) == 0;
		
		if(isFactor.test(10, 2)) {
			System.out.println("2 is a factor of 10");
		}
		
		if(!isFactor.test(10, 3)) {
			System.out.println("3 is not a factor of 10");
		}
	}
}
