package com.atmecs.controllers;

import java.util.HashMap;
import java.util.Map;

import com.atmecs.rest_request.DELETERequest;
import com.atmecs.rest_request.GETRequest;
import com.atmecs.rest_request.POSTRequest;
import com.atmecs.rest_request.PUTRequest;
import com.jayway.restassured.path.json.JsonPath;

public class RequestCreator {

	private Map<String, String> map = new HashMap<String, String>();


	public GETRequest createGETRequest(JsonPath jsonPath) {

		GETRequest getRequest = new GETRequest();

		getRequest.setUri(jsonPath.getString("uri"));

		getRequest.setResponseMediaType(jsonPath.getString("mediatype.response"));

		if(jsonPath.getMap("request.pathparam") != null)
			getRequest.setPathParam(jsonPath.getMap("request.pathparam", String.class, String.class));

		if(jsonPath.getMap("request.queryparam") != null)
			getRequest.setQueryParam(jsonPath.getMap("request.queryparam", String.class, String.class));

		if(jsonPath.getMap("request.headerparam") != null)
			getRequest.setHeaderParam(jsonPath.getMap("request.headerparam", String.class, String.class));

		return getRequest;
	}

	public PUTRequest createPUTRequest(JsonPath jsonPath) {

		PUTRequest putRequest = new PUTRequest();

		putRequest.setUri(jsonPath.getString("uri"));

		putRequest.setResponseMediaType(jsonPath.getString("mediatype.response"));

		if(jsonPath.getMap("mediatype.request") != null)
			putRequest.setRequestMediaType(jsonPath.getString("mediatype.request"));

		if(jsonPath.getMap("request.pathparam") != null)
			putRequest.setPathParam(jsonPath.getMap("request.pathparam", String.class, String.class));

		if(jsonPath.getMap("request.queryparam") != null)
			putRequest.setQueryParam(jsonPath.getMap("request.queryparam", String.class, String.class));

		if(jsonPath.getMap("request.headerparam") != null)
			putRequest.setHeaderParam(jsonPath.getMap("request.headerparam", String.class, String.class));

		if(jsonPath.getMap("request.body") != null)
			putRequest.setBody(jsonPath.getString("request.body"));

		return putRequest;
	}

	public POSTRequest createPOSTRequest(JsonPath jsonPath) {

		POSTRequest postRequest = new POSTRequest();
		
		postRequest.setUri(jsonPath.getString("uri"));

		postRequest.setResponseMediaType(jsonPath.getString("mediatype.response"));

		postRequest.setRequestMediaType(jsonPath.getString("mediatype.request"));

		postRequest.setBody(jsonPath.getString("request.body"));

		if(jsonPath.getMap("request.pathparam") != null)
			postRequest.setPathParam(jsonPath.getMap("request.pathparam", String.class, String.class));

		if(jsonPath.getMap("request.queryparam") != null)
			postRequest.setQueryParam(jsonPath.getMap("request.queryparam", String.class, String.class));

		if(jsonPath.getMap("request.headerparam") != null)
			postRequest.setHeaderParam(jsonPath.getMap("request.headerparam", String.class, String.class));

		return postRequest;
	}

	public DELETERequest createDELETERequest(JsonPath jsonPath) {
		
		DELETERequest deleteRequest = new DELETERequest();

		deleteRequest.setUri(jsonPath.getString("uri"));

		deleteRequest.setResponseMediaType(jsonPath.getString("mediatype.response"));

		if(jsonPath.getMap("request.pathparam") != null)
			deleteRequest.setPathParam(jsonPath.getMap("request.pathparam", String.class, String.class));

		if(jsonPath.getMap("request.queryparam") != null)
			deleteRequest.setQueryParam(jsonPath.getMap("request.queryparam", String.class, String.class));

		if(jsonPath.getMap("request.headerparam") != null)
			deleteRequest.setHeaderParam(jsonPath.getMap("request.headerparam", String.class, String.class));
		
		return deleteRequest;
	}

}
