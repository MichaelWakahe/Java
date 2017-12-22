package com.michaelwakahe.lambda.example2;

/**
 * Demonstrate a lambda expression that takes a parameter.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class LambdaDemo2 {

	public static void main(String args[]) {
		// A lambda expression that tests if a number is even.
		NumericTest isEven = (n) -> (n % 2) == 0;
		
		if(isEven.test(10)) System.out.println("10 is even");
		if(!isEven.test(9)) System.out.println("9 is not even");
		
		// Now, use a lambda expression that tests if a number
		// is non-negative. Note that the brackets are optional
		// on the left side of the lambda operator
		NumericTest isNonNeg = n -> n >= 0;  // can also be written as: (n) -> n >= 0
											 // can also be written as: (int n) -> n >= 0
		if(isNonNeg.test(1)) System.out.println("1 is non-negative");
		if(!isNonNeg.test(-1)) System.out.println("-1 is negative");
	}
}
