/**
 * bhanu
 */
package com.atmecs.rest_response;

import com.jayway.restassured.response.Response;

public class RestResponseImpl implements RestResponse{

	Response response;

	@Override
	public Response getResponse() {
		return this.response;
	}

	@Override
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
