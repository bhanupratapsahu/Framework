/**
 * bhanu
 */
package com.atmecs.assertions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Headers;

public class RestAssertionImpl implements RestAssertion{

	private String expectedValue;
	private String actualValue;

	@Override
	public void assertHeaders(Headers headers, Map<String, String> headerMap) {

		Set<String> set = headerMap.keySet();

		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {

			String headerName = (String) iterator.next();
			expectedValue = headerMap.get(headerName);
			actualValue = headers.getValue(headerName);

			Assert.assertEquals(actualValue, expectedValue);
		}

	}

	@Override
	public void assertBody(Object body, Map<String, String> bodyMap) {

		Set<String> set = bodyMap.keySet();
		JsonPath jsonPath = null;
		XmlPath xmlPath = null;

		if (body instanceof JsonPath)
			jsonPath = (JsonPath) body;
		else if (body instanceof XmlPath)
			xmlPath = (XmlPath) body;


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


	@Override
	public void assertCookies(Cookies cookies, JsonPath assertionPath) throws Exception {

		Map<String, String> actualCookieParamMap = null;
		Map<String, String> expectedCookieParamMap = null;
		Set<String> cookieSet = null;
		Set<String> cookieParamSet = null;
		Cookie cookie = null;

		cookieSet = assertionPath.getMap("assertions.cookies", String.class, String.class).keySet();

		for (Iterator<String> iterator = cookieSet.iterator(); iterator.hasNext();) {

			String cookieName = (String) iterator.next();

			if(cookies.hasCookieWithName(cookieName))
			{
				cookie = cookies.get(cookieName);
				actualCookieParamMap = createCookieParamMap(cookie);
			}
			else
				throw new Exception("cookie not present");

			expectedCookieParamMap = assertionPath.getMap("assertions.cookies." + cookieName, String.class, String.class);
			cookieParamSet = expectedCookieParamMap.keySet();

			for (String cookieParamName : cookieParamSet) {

				expectedValue = expectedCookieParamMap.get(cookieParamName);
				actualValue = actualCookieParamMap.get(cookieParamName);

				Assert.assertEquals(actualValue, expectedValue);
			}
			
		}
	}


	private Map< String, String > createCookieParamMap(Cookie cookie) {

		Map<String, String> cookieParamMap = new HashMap<String, String>();

		if(cookie.hasComment())
			cookieParamMap.put("comment", cookie.getComment().substring(1, cookie.getComment().length()-1));

		if(cookie.hasDomain())
			cookieParamMap.put("domain", cookie.getDomain().substring(1, cookie.getDomain().length()-1));

		if(cookie.hasMaxAge())
			cookieParamMap.put("max-age", String.valueOf(cookie.getMaxAge()));

		if(cookie.hasPath())
			cookieParamMap.put("path", cookie.getPath().substring(1, cookie.getPath().length()-1));

		if(cookie.hasValue())
			cookieParamMap.put("value", cookie.getValue().substring(1, cookie.getValue().length()-1));

		if(cookie.hasVersion())
			cookieParamMap.put("version", String.valueOf(cookie.getVersion()));

		if(cookie.isHttpOnly())
			cookieParamMap.put("httponly", "true");

		if(cookie.isSecured())
			cookieParamMap.put("secured", "true");
		return cookieParamMap;
	}


	@Override
	public void assertStatus(String actualStatus, String expectedStatus) {

		int actualStatusCode = 0;
		int expectedStatusCode = 0;

		if(expectedStatus.matches("\\d\\d\\d")) {
			Pattern pattern = Pattern.compile("\\d\\d\\d");
			Matcher matcher = pattern.matcher(actualStatus);

			if(matcher.find())
				actualStatusCode = Integer.parseInt(matcher.group());
			
			expectedStatusCode = Integer.parseInt(expectedStatus);

			Assert.assertEquals(actualStatusCode, expectedStatusCode);
		}
		else {

			actualStatus = actualStatus.substring(13);
			Assert.assertEquals(actualStatus, expectedStatus);
		}
	}

}
