/**
 * bhanu
 */
package com.atmecs.rest_response;

import java.util.HashMap;
import java.util.Map;

public class RestResponseImpl implements RestResponse{

	Map<String, String> headers = new HashMap<String, String>();
	String body;
	
	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	@Override
	public void setHeaders(Map<String, String> headers) {
		this.headers.putAll(headers);
		
	}
	
	@Override
	public String getBody() {
		return body;
	}
	
	@Override
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
