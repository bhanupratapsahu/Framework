package com.atmecs.assertions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

import com.atmecs.common_interfaces.Response;
import com.atmecs.rest_response.RestResponseImpl;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Headers;

public class AssertionImpl implements Assertion {
	
	XmlPath xmlPath = null;
	JsonPath jsonPath = null;
	Headers headers;
	String body, actualValue, expectedValue, responseMediaType;
	
	
	
	public void assertThat(Response response, JsonPath testCaseFilePath) throws Exception {
		
		RestResponseImpl restResponseImpl = (RestResponseImpl) response;
		headers = restResponseImpl.getHeaders();
		body = restResponseImpl.getBody();
		responseMediaType = testCaseFilePath.getString("mediatype.response");
		
		if(testCaseFilePath.get("assertions.headers") != null)
			assertHeader(testCaseFilePath.getMap("assertions.headers", String.class, String.class));
		if(testCaseFilePath.get("assertions.body") != null)
			assertBody(testCaseFilePath.getMap("assertions.body", String.class, String.class));
			
	}


	private void assertHeader(Map<String, String> headerMap) {
		
		Set<String> set = headerMap.keySet();
		
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String headerName = (String) iterator.next();
			expectedValue = headerMap.get(headerName);
			actualValue = headers.getValue(headerName);
			
			Assert.assertEquals(actualValue, expectedValue);
		}
	}
	
	
	private void assertBody(Map<String, String> bodyMap) throws Exception {

		Set<String> set = bodyMap.keySet();
		detectResponseMedia();
		
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String bodyParam = (String) iterator.next();
			expectedValue = bodyMap.get(bodyParam);
			
			if(xmlPath != null)
				actualValue = xmlPath.getString(bodyParam);
			else
				actualValue = jsonPath.getString(bodyParam);
			
			Assert.assertEquals(actualValue, expectedValue);
		}
	}
	
	private void detectResponseMedia() throws Exception {
		
			if(responseMediaType.equalsIgnoreCase("application/json"))
				jsonPath = new JsonPath(body);
			else if(responseMediaType.equalsIgnoreCase("application/xml"))
				xmlPath = new XmlPath(body);
			else
				throw new Exception("Invalid Response mediaType");
	}
		

}