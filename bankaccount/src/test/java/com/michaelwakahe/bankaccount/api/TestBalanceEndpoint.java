package com.michaelwakahe.bankaccount.api;

import com.michaelwakahe.bankaccount.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;


/**
 * Tests our {@link BalanceEndpoint}
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class TestBalanceEndpoint {

	final String CGI_URL = "http://localhost:8080/BankAccount/balance";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception { }
	

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.BalanceEndpoint#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		Gson gson = new Gson();
		
		Map<String, String> expectedResponseHash = new HashMap<>();
		//expectedResponseHash.put("command_status", APIConstants.COMMANDSTATUS_INVALID_PARAMETERS);
		String jsonExpected = gson.toJson(expectedResponseHash);
		
		
		//***********************************************************
		// Test with invalid JSON
		//***********************************************************				
		//assertEquals(HttpUtil.getPostResponse(CGI_URL, "A_bad_argument", "application/json"), jsonExpected);
		System.out.println(HttpUtil.getPostResponse(CGI_URL, "A_bad_argument", "application/json"));		
	}
	

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.BalanceEndpoint#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.BalanceEndpoint#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPutHttpServletRequestHttpServletResponse() {
		
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.BalanceEndpoint#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoDeleteHttpServletRequestHttpServletResponse() {
		
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.BalanceEndpoint#doHead(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoHeadHttpServletRequestHttpServletResponse() {
		
	}

}
