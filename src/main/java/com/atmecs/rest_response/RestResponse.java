/**
 * bhanu
 */
package com.atmecs.rest_response;

import com.atmecs.common_interfaces.Response;
import com.jayway.restassured.response.Headers;

public interface RestResponse extends Response{

	public Headers getHeaders();
	public void setHeaders(Headers headers);
	public String getBody();
	public void setBody(String body);
}
