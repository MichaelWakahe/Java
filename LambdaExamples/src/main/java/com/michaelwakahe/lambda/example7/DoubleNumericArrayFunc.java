package com.michaelwakahe.lambda.example7;

/**
 * A functional interface with a throws clause
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public interface DoubleNumericArrayFunc {
	double func(double[] n) throws EmptyArrayException;
}
