package com.atmecs.assertions;

import org.testng.Assert;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Headers;

public class AssertionImpl implements Assertion {

	AssertionAdapter assertionAdapter = new AssertionAdapter(); 

	@Override
	public void assertObject(Object actual, Object expected) throws Exception {

		if (actual instanceof String && expected instanceof String)
			Assert.assertEquals(actual, expected);
		else
			assertionAdapter.assertObject(actual, expected);

	}


}
