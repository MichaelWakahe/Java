package com.michaelwakahe.bankaccount.persistence;

import com.michaelwakahe.bankaccount.beans.StorableBean;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Implementation of a Storage facility.
 * <p>
 *  
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class StorageImpl extends Storage {

	private SessionFactory sessionFactory;
	
	/**
	 * Disable default constructor
	 */
	private StorageImpl() {}
	
	
	/**
	 * @param sessionFactory
	 */
	public StorageImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	/**
	 * @see Storage#save(StorableBean)
	 */
	@Override
	public StorableBean save(StorableBean bean) {
		Session session = sessionFactory.openSession();
        
        session.beginTransaction();            
        session.saveOrUpdate(bean);           
        session.getTransaction().commit();
        
        session.close();
        		
		return bean; 	// In the case where the primary key is an Id (integer), this bean
						// has the updated Id from the database.
	}	
	

	/**
	 * @see Storage#getAll(java.lang.Class, Date, Date)
	 */
	@Override
	public List<StorableBean> getAll(Class aClass, Date startDate, Date stopDate) {
		List<StorableBean> list = null;
		
		String hql = ("SELECT c FROM " + aClass.getSimpleName() + 
				" AS c WHERE c.date BETWEEN :stDate AND :edDate");
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		query.setParameter("stDate", startDate);
		query.setParameter("edDate", stopDate);
		list = query.list();	
						
		session.close();
		
		return list;
	}

			
	/**
	 * @see Storage#get(java.lang.Class, java.lang.Object, java.lang.Object)
	 */
	@Override
	public List<StorableBean> get(Class aClass, Object fieldName, Object fieldValue) {
		List<StorableBean> list = null;
		
		String hql = "from " + aClass.getSimpleName() + " where " + fieldName.toString() + " = :" + fieldName.toString();
		// Example of hql string: "from Withdrawal where uuid = :uuid"
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		query.setParameter(fieldName.toString(), fieldValue);
		list = query.list();						
				
		session.close();
		
		return list;
	}

}
