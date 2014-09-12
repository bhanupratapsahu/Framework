/**
 * bhanu
 */
package com.atmecs.assertions;

import java.util.Map;

import com.atmecs.rest_response.RestResponse;
import com.atmecs.rest_response.RestResponseImpl;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;

public class AssertionAdapter implements Assertion{

	Class<String> keyType = String.class;
	Class<String> valueType = String.class;
	
	RestAssertion restAssertion = new RestAssertionImpl();
	RestResponse restResponse;
	JsonPath assertionPath;

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}

	public JsonPath getAssertionPath() {
		return assertionPath;
	}

	public void setAssertionPath(JsonPath assertionPath) {
		this.assertionPath = assertionPath;
	}



	@Override
	public void assertObject(Object actualValue, Object expectedValue) throws Exception {

		if(actualValue instanceof RestResponse)
			setRestResponse( (RestResponse)actualValue );
		
		if(expectedValue instanceof JsonPath)
			setAssertionPath( (JsonPath)expectedValue );

		if(assertionPath.get("assertions.headerparam") != null)
		{
			Headers responseHeaders = restResponse.getResponse().getHeaders();
			Map<String, String> expectedHeaders = assertionPath.getMap("assertions.headerparam", keyType, valueType);
			
			restAssertion.assertHeaders( responseHeaders, expectedHeaders);
		}
		
		if(assertionPath.get("assertions.body") != null)
		{
			if(restResponse.getResponse().contentType().equalsIgnoreCase("application/json"))
				restAssertion.assertBody(restResponse.getResponse().getBody().jsonPath() , assertionPath.getMap("assertions.body", String.class, String.class));
			else if(restResponse.getResponse().contentType().equalsIgnoreCase("application/xml"))
				restAssertion.assertBody(restResponse.getResponse().getBody().xmlPath() , assertionPath.getMap("assertions.body", String.class, String.class));
		}
		
		if(assertionPath.get("assertions.cookies") != null)
		{
			restAssertion.assertCookies(restResponse.getResponse().getDetailedCookies(), assertionPath);
		}
		
		if(assertionPath.get("assertions.status") != null)
		{
			restAssertion.assertStatus(restResponse.getResponse().getStatusLine(), assertionPath.getString("assertions.status"));
		}
	}


}
