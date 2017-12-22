package com.michaelwakahe.bankaccount.api;

import com.michaelwakahe.bankaccount.persistence.HibernateUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

/**
 * Initialize certain activities as the webapp starts, and shut them down on 
 * exit.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
@WebListener
public class BankServletContextListener implements ServletContextListener {

	
		
	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	}

	
	
	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sessionFactory.close();
	}
	
	
}

