package com.michaelwakahe.bankaccount.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.URL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;

import org.apache.http.entity.StringEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * HTTP utilities.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 * 
 */
public class HttpUtil {

	private static Logger logger = LogManager.getLogger(HttpUtil.class);
		
	
	/**
	 * @param url
	 * @param params
	 * @return an {@link HttpEntity} based on the server response
	 */
	public static HttpEntity getPostEntity(URL url, Map<String,String> params) {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		UrlEncodedFormEntity entity = null;
		
		Iterator<String> iter = params.keySet().iterator();
		String key;
		
		while(iter.hasNext()) {
			key = iter.next();
			formparams.add(new BasicNameValuePair(key, params.get(key)));
		}
		
		try {
			entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            HttpPost httppost = new HttpPost(url.toString());
            httppost.setEntity(entity);
            HttpResponse response = httpclient.execute(httppost);
            
            
            HttpEntity httpEntity = response.getEntity();
				
            httpclient.close();
            
            return httpEntity;
            
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException for URL: '" + url + "'");
			logger.error(ExceptionUtils.getStackTrace(e));
				
			
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException for URL: '" + url + "'");
			logger.error(ExceptionUtils.getStackTrace(e));
			
			
		} catch (IOException e) {
			logger.error("IOException for URL: '" + url + "'");
			logger.error(ExceptionUtils.getStackTrace(e));			
		}		
		
		return entity;
	}
	
	
	/**
	 * Used to send an arg in the body of an HTTP POST, for example a JSON 
	 * POST.
	 * 
	 * @param url
	 * @param arg 
	 * @param contentType for example "application/json"
	 * @return the server response
	 */
	public static String getPostResponse(String url, String arg, String contentType) {
		String response = "";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost postRequest = new HttpPost(url);
				
		try {
			StringEntity input = new StringEntity(arg);
			input.setContentType(contentType);
			postRequest.setEntity(input);

			CloseableHttpResponse httpResponse = httpClient.execute(postRequest);

			response = EntityUtils.toString(httpResponse.getEntity());
			
			httpResponse.close();
			
		} catch ( IOException e) {
			logger.error("IOException for getPostResponse for URL: '" + url + "'");
			logger.error(ExceptionUtils.getStackTrace(e));
		}

		return response;
	}
	
}

