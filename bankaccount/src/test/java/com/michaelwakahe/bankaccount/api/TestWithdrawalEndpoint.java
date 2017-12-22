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
 * Tests our {@link WithdrawalEndpoint}
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class TestWithdrawalEndpoint {

	final String CGI_URL = "http://localhost:8080/BankAccount/withdrawal";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.WithdrawalEndpoint#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		Gson gson = new Gson();
		
		Map<String, String> expectedResponseHash = new HashMap<>();
		expectedResponseHash.put("response", "INVALID_PARAMETERS");
		String jsonExpected = gson.toJson(expectedResponseHash);
		
		
		//***********************************************************
		// Test with invalid JSON
		//***********************************************************				
		assertEquals(HttpUtil.getPostResponse(CGI_URL, "A_bad_argument", "application/json"), jsonExpected);
		
		
		//***********************************************************
		// Test with a valid deposit amount
		//***********************************************************		
		Map<String, String> requestHash = new HashMap<>();
		requestHash.put("amount", "150");
		
		expectedResponseHash = new HashMap<>();
		expectedResponseHash.put("response", "WITHDRAWAL_OK");
		jsonExpected = gson.toJson(expectedResponseHash);
		
		String jsonRequest = gson.toJson(requestHash);		
		assertEquals(HttpUtil.getPostResponse(CGI_URL, jsonRequest, "application/json"), jsonExpected);
	}

	
	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.WithdrawalEndpoint#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		
	}

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.WithdrawalEndpoint#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPutHttpServletRequestHttpServletResponse() {
		
	}

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.WithdrawalEndpoint#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoDeleteHttpServletRequestHttpServletResponse() {
		
	}

	/**
	 * Test method for {@link com.michaelwakahe.bankaccount.api.WithdrawalEndpoint#doHead(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoHeadHttpServletRequestHttpServletResponse() {
		
	}

}
