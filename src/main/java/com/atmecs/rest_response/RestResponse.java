/**
 * bhanu
 */
package com.atmecs.rest_response;

import com.atmecs.common_interfaces.Response;
import com.jayway.restassured.response.Headers;

public interface RestResponse extends Response{

	public com.jayway.restassured.response.Response getResponse();
	public void setResponse(com.jayway.restassured.response.Response response);
}
