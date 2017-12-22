package com.michaelwakahe.bankaccount.business;

import com.michaelwakahe.bankaccount.beans.Balance;
import com.michaelwakahe.bankaccount.persistence.Storage;
import com.michaelwakahe.bankaccount.persistence.StorageImpl;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Test the control logic
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class TestController {

	private Controller controller;
		
	private SessionFactory sessionFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		Storage storage;
		
		try {
            // Create the SessionFactory from hibernate.cfg.xml            
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        	
			storage = new StorageImpl(sessionFactory);
			
			controller = new Controller(storage);
			
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
	 * Test method for {@link com.michaelwakahe.bankaccount.business.Controller#depositAmt(double)}.
	 */
	@Ignore
	@Test
	public void testDepositAmt() {
		//------------------------------------------------------------
		// Test with an amount greater than allowed in one deposit
		//------------------------------------------------------------
		assertEquals(controller.depositAmt(41_500), AccountCodes.MAX_DEPOSIT_PER_TRANSACTION);
		
		
		//--------------------------------------------------------------------
		// Test with a frequency greater than the allowed withdrawals per day
		// Edit the MySQL manually to achieve this
		//--------------------------------------------------------------------
		assertEquals(controller.depositAmt(500), AccountCodes.MAX_DEPOSIT_FREQUENCY_PER_DAY);
		
		
		//--------------------------------------------------------------
		// Test with an amount greater than the maximum allowed per day
		// Edit the MySQL manually to achieve this
		//--------------------------------------------------------------
		assertEquals(controller.depositAmt(39000), AccountCodes.MAX_DEPOSIT_AMOUNT_PER_DAY);
		
		
		//--------------------------------------------------------------------
		// Test for an OK deposit
		//--------------------------------------------------------------------
		assertEquals(controller.depositAmt(300.89), AccountCodes.DEPOSIT_OK);
	}
	

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.business.Controller#getBalance()}.
	 */
	@Ignore
	@Test
	public void testGetBalance() {
		Balance balance = controller.getBalance();
		assertEquals(balance.getAmount(), 150_000, 0);		
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.business.Controller#withdrawAmt(double)}.
	 */
	@Ignore
	@Test
	public void testWithdrawAmt() {
		//------------------------------------------------------------
		// Test with an amount greater than allowed in one withdrawal
		//------------------------------------------------------------
		assertEquals(controller.withdrawAmt(20500), AccountCodes.MAX_WITHDRAWAL_PER_TRANSACTION);
		
		
		//------------------------------------------------------------
		// Test with an amount greater than the balance
		// Edit the MySQL manually to achieve this
		//------------------------------------------------------------
		assertEquals(controller.withdrawAmt(5000), AccountCodes.INSUFFICIENT_BALANCE);
		
		
		//--------------------------------------------------------------
		// Test with an amount greater than the maximum allowed per day
		// Edit the MySQL manually to achieve this
		//--------------------------------------------------------------
		assertEquals(controller.withdrawAmt(15000), AccountCodes.MAX_WITHDRAWAL_AMOUNT_PER_DAY);
		
		
		//--------------------------------------------------------------------
		// Test for an OK withdrawal
		//--------------------------------------------------------------------
		assertEquals(controller.withdrawAmt(200.89), AccountCodes.WITHDRAWAL_OK);
		
		
		//--------------------------------------------------------------------
		// Test with a frequency greater than the allowed withdrawals per day
		//--------------------------------------------------------------------
		assertEquals(controller.withdrawAmt(500), AccountCodes.MAX_WITHDRAWAL_FREQUENCY_PER_DAY);
	}

}
