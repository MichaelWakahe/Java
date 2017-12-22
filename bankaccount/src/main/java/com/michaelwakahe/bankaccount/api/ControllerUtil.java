package com.michaelwakahe.bankaccount.api;

import com.michaelwakahe.bankaccount.business.Controller;
import com.michaelwakahe.bankaccount.persistence.HibernateUtil;
import com.michaelwakahe.bankaccount.persistence.Storage;
import com.michaelwakahe.bankaccount.persistence.StorageImpl;

/**
 * Maintains a global {@link Controller} to be used by servlets
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class ControllerUtil {

	private final static Controller controller = initController();
	
	
	/**
	 * @return a {@link Controller}
	 */
	private static Controller initController() {
		Storage storage = new StorageImpl(HibernateUtil.getSessionFactory());
		
		Controller c = new Controller(storage);
		
		return c;
	}
		

	/**
	 * @return a {@link Controller}
	 */
	public static Controller getController()  {
		return controller;
	}

}
