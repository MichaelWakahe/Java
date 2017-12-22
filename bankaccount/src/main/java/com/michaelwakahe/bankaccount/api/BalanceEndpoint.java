package com.michaelwakahe.bankaccount.api;

import com.michaelwakahe.bankaccount.beans.Balance;
import com.michaelwakahe.bankaccount.business.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * The part of the API that allows for an account holder to query balance.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class BalanceEndpoint extends HttpServlet {

	private Controller controller;
	
	private Logger logger;
	
	
	/**
	 * 
	 * @param config
	 * @throws ServletException
	 */
	@Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		logger = LogManager.getLogger(this.getClass());
                
        controller = ControllerUtil.getController();
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		OutputStream out = response.getOutputStream();

		response.setContentType("application/json;charset=UTF-8");
		response.setDateHeader("Expires", new Date().getTime()); // Expiration
																	// date
		response.setDateHeader("Date", new Date().getTime()); // Date and time
																// that the
																// message was
																// sent
				
		out.write(getResponse().getBytes());
		out.flush();
		out.close();		
	}
	   
	
	/**
	 * @return 
	 */
	private String getResponse() {
		
		Gson gson = new Gson();
		Map<String, String> jsonHash = new HashMap<>();
		
		Balance balance = controller.getBalance();
		
		jsonHash.put("amount", String.valueOf(balance.getAmount()));
		
		return gson.toJson(jsonHash);		
	}
			
	
	/**
    *
    * @param request
    * @param response
    * @throws ServletException, IOException
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   response.sendError(405, "This method is forbidden." );
   }
   
   
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.sendError(405, "This method is forbidden." );
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(405, "This method is forbidden." );
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doHead(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(405, "This method is forbidden." );
	}
	
	
	/**	 */
	private static final long serialVersionUID = 5356669011201221661L;
}
