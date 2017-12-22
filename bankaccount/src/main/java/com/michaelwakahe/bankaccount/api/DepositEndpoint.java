package com.michaelwakahe.bankaccount.api;

import com.michaelwakahe.bankaccount.business.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * The part of the API that allows for an account holder to make a deposit.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class DepositEndpoint extends HttpServlet {

	private Controller controller;
	
	/**
	 * 
	 * @param config
	 * @throws ServletException
	 */
	@Override
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		                
        controller = ControllerUtil.getController();
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException, IOException
	 */
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		OutputStream out = response.getOutputStream();

		response.setContentType("application/json;charset=UTF-8");
		response.setDateHeader("Expires", new Date().getTime()); // Expiration
																	// date
		response.setDateHeader("Date", new Date().getTime()); // Date and time
																// that the
																// message was
																// sent
				
		out.write(getResponse(request).getBytes());
		out.flush();
		out.close();		
	}
	   
	
	/**
	 * @return 
	 */
	private String getResponse(HttpServletRequest request) throws IOException {				   
	   String join = "";
		JsonElement root = null;

		// Get all parameters
		List<String> lines = IOUtils.readLines(request.getReader());

		// used to format/join incoming JSon string
		join = StringUtils.join(lines.toArray(), " ");

		// instantiate the JSon
		Gson gson = new Gson();
		Map<String, String> jsonHash = new HashMap<>();
			
		JsonObject jsonObject = null;
		
		try {
			// parse the JSon string
			root = new JsonParser().parse(join);
			jsonObject = root.getAsJsonObject();
			
			
		} catch (Exception e) {		
			// Invalid JSON argument
			jsonHash.put("response", "INVALID_PARAMETERS");			
			return gson.toJson(jsonHash);
		}	
		
		// Check for the presence of the required parameter
		if(!jsonObject.has("amount") ) {
			jsonHash.put("response", "INVALID_PARAMETERS");
			return gson.toJson(jsonHash);
		}
		
		Double depositAmt = Double.parseDouble(jsonObject.get("amount").getAsString());
		
		jsonHash.put("response", controller.depositAmt(depositAmt));
		
		return gson.toJson(jsonHash);
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

}
