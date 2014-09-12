/**
 * bhanu
 */
package com.atmecs.assertions;

import java.util.Map;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Headers;

public interface RestAssertion {

	public void assertHeaders(Headers headers, Map<String, String> headerMap );
	public void assertBody(Object body, Map<String, String> bodyMap );
	public void assertCookies(Cookies cookies, JsonPath assertionPath ) throws Exception;
	public void assertStatus(String actualStatus, String expectedStatus );
	
}
