package com.michaelwakahe.bankaccount.persistence;

import com.michaelwakahe.bankaccount.beans.StorableBean;
import com.michaelwakahe.bankaccount.beans.Balance;
import com.michaelwakahe.bankaccount.beans.Withdrawal;

import org.joda.time.DateTime;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Tests the Storage facility.
 * <p>
 * Ensure the database is reset to initial data before running these tests.
 * <p>
 *  
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class TestStorageImpl {

	private Storage storage;
	
	private SessionFactory sessionFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
            // Create the SessionFactory from hibernate.cfg.xml            
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        	
			storage = new StorageImpl(sessionFactory);
			
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		sessionFactory.close();
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.persistence.StorageImpl#save(com.michaelwakahe.bankaccount.beans.StorableBean)}.
	 */
	@Test
	public void testSave() {
		List<StorableBean> balances = storage.get(Balance.class, "uuid", "f681d2e6-84f2-45ff-914c-522a3b076141");
		Balance balance = (Balance)balances.get(0);
		
		balance.setAmount(200.01);
		
		storage.save(balance);
		
		balances = storage.get(Balance.class, "uuid", "f681d2e6-84f2-45ff-914c-522a3b076141");
		balance = (Balance)balances.get(0);
		
		assertEquals(balance.getAmount(), 200.01, 0);
		
		balance.setAmount(30000);
		
		storage.save(balance);
	}
	

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.persistence.StorageImpl#getAll(java.lang.Class, java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetAll() {
		// Get all Withdrawals on 2017-05-17
		DateTime startDate = new DateTime(2017, 5, 17, 1, 1);
		startDate = startDate.withTimeAtStartOfDay();
				
		DateTime endDate = startDate.plusDays(1);
		
		List<StorableBean> withdrawals = storage.getAll(Withdrawal.class, startDate.toDate(), endDate.toDate());
		assertEquals(withdrawals.size(), 3);		
	}
	

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.persistence.StorageImpl#get(java.lang.Class, java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testGet() {
		List<StorableBean> balances = storage.get(Balance.class, "uuid", "f681d2e6-84f2-45ff-914c-522a3b076141");
		Balance balance = (Balance)balances.get(0);
		
		assertEquals(balance.getAmount(), 30000, 0);		
	}

}
