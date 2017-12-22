package com.michaelwakahe.lambda.example7;

/**
 * Throw an exception from a lambda expression.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class LambdaExceptionDemo {

	
	/**
	 * @param args
	 * @throws EmptyArrayException
	 */
	public static void main(String args[]) throws EmptyArrayException {
		double[] values = { 1.0, 2.0, 3.0, 4.0 };
		
		// This block lambda computes the average of an array of doubles.
		DoubleNumericArrayFunc average = (n) -> {
			double sum = 0;
			if(n.length == 0)
				throw new EmptyArrayException();
			
			for(int i=0; i < n.length; i++)
				sum += n[i];
			return sum / n.length;
		};
		
		
		System.out.println("The average is " + average.func(values));
		
		// This causes an exception to be thrown.
		System.out.println("The average is " + average.func(new double[0]));
	}

}
