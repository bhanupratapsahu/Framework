/**
 * bhanu
 */
package com.atmecs.rest_response;

import java.util.Map;

import com.atmecs.common_interfaces.Response;

public interface RestResponse extends Response{

	public Map<String,String> getHeaders();
	public void setHeaders(Map<String,String> headers);
	public String getBody();
	public void setBody(String body);
}
