package com.michaelwakahe.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * The driver class
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class LogDemo {

    private static final Logger logger = LogManager.getLogger(LogDemo.class.getName());

    public static void main(String[] args){

        logger.debug("Hello world - debug log");
        logger.info("Hello world - info log");
        logger.warn("Hello world - warn log");
        logger.error("Hello world - error log");
    }
}
