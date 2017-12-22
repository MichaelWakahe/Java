package com.michaelwakahe.bankaccount.persistence;

import com.michaelwakahe.bankaccount.beans.StorableBean;

import java.util.Date;
import java.util.List;

/**
 * Our storage definition
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public abstract class Storage {

	/**
	 * This can both save new objects, as well as update objects if a bean with
	 * a matching primary key is present in the database.
	 * 
	 * @param bean
	 * @return
	 */
	public abstract StorableBean save(StorableBean bean);
	
		
	/**
	 *  
	 * @param aClass
	 * @param startDate the earliest date of a {@link Deposit} or {@link Withdrawal}
	 * @param stopDate the latest date of a {@link Deposit} or {@link Withdrawal}
	 * @return a list of all objects in persistence
	 */
	public abstract List<StorableBean> getAll(Class aClass, Date startDate, Date stopDate);
	
	
	/**
	 * Select a set of objects from persistence which has a certain fieldName (column) and whose
	 * value is fieldValue
	 * 
	 * @param aClass
	 * @param fieldName
	 * @param fieldValue
	 * @return a matching list of all objects in persistence
	 */
	public abstract List<StorableBean> get(Class aClass, Object fieldName, Object fieldValue);
}
