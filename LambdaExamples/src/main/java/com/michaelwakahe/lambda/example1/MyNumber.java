package com.michaelwakahe.lambda.example1;

/**
 * Example functional interface, for a lambda expression that takes no 
 * parameters.
 * <p>
 * A functional interface is an interface that specifies only one abstract 
 * method. An interface method is abstract only if it does not specify a 
 * default implementation.
 * <p>
 * A functional interface is sometimes referred to as a SAM type, where SAM 
 * stands for Single Abstract Method.
 * <p>
 * The body of the lambda shown here consists of a single expression. These 
 * types of lambda bodies are referred to as expression bodies, and lambdas 
 * that have expression bodies are sometimes called expression lambdas. In an
 * expression body, the code on the right side of the lambda operator must 
 * consist of a single expression.
 * <p>
 * Adapted from "Java: The Complete Reference, Ninth Edition", by Herbert 
 * Schildt, Apr 1, 2014
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public interface MyNumber {
	double getValue();
}
