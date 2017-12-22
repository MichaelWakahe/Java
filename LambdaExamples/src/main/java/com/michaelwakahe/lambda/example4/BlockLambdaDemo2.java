package com.michaelwakahe.lambda.example4;

/**
 * A block lambda example.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class BlockLambdaDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// This block lambda reverses the characters in a string.
		StringFunc reverse = (str) -> {
			String result = "";
			int i;
			
			for(i = str.length()-1; i >= 0; i--) {
				result = result + str.charAt(i);
			}
			
			return result;
		};
		
		System.out.println("Lambda reversed is " + reverse.func("Lambda"));
		
		System.out.println("Expression reversed is " + reverse.func("Expression"));
	}

}
