package com.michaelwakahe.lambda.example5;

/**
 * Use a generic functional interface with lambda expressions.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class GenericFunctionalInterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Use a String-based version of SomeFunc.
		SomeFunc<String> reverse = (str) -> {
			String result = "";
			int i;
			for(i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		
		System.out.println("Lambda reversed is " + reverse.func("Lambda"));		
		System.out.println("Expression reversed is " + reverse.func("Expression"));
		
		
		// Now, use an Integer-based version of SomeFunc.
		SomeFunc<Integer> factorial = (n) -> {
			int result = 1;
			for(int i=1; i <= n; i++)
				result = i * result;
			return result;
		};
		
		System.out.println("The factoral of 3 is " + factorial.func(3));
		System.out.println("The factoral of 5 is " + factorial.func(5));
	}

}
