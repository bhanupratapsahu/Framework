/**
 * bhanu
 */
package com.atmecs.rest_response;

import com.jayway.restassured.response.Headers;

public class RestResponseImpl implements RestResponse{

	Headers headers;
	String body;
	
	@Override
	public Headers getHeaders() {
		return headers;
	}
	
	@Override
	public void setHeaders(Headers headers) {
		this.headers = headers;
		
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
