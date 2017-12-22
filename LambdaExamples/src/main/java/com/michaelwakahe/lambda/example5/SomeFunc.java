package com.michaelwakahe.lambda.example5;

/**
 * A generic functional interface.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public interface SomeFunc<T> {
	T func(T t);
}
