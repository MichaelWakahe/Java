package com.michaelwakahe.lambda.example4;

/**
 * Java supports a second type of lambda expression in which the code on the 
 * right side of the lambda operator consists of a block of code that can 
 * contain more than one statement.
 * <p>
 * This type of lambda body is called a block body. Lambdas that have block 
 * bodies are sometimes referred to as block lambdas.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class BlockLambdaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// This block lambda computes the factorial of an int value.
		NumericFunc factorial = (n) -> {
			int result = 1;
			
			for(int i=1; i <= n; i++) {
				result = i * result;
			}
			
			return result;
		};
		
		System.out.println("The factoral of 3 is " + factorial.func(3));
		System.out.println("The factoral of 5 is " + factorial.func(5));
	}

}

