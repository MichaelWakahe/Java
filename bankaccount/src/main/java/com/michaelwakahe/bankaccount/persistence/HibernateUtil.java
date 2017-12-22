package com.michaelwakahe.bankaccount.persistence;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Maintains our global {@link SessionFactory}.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    /**
     * @return {@link SessionFactory}
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    
    /**
     * @return {@link SessionFactory}
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }    
    
}

