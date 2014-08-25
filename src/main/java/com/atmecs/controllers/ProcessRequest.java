package com.atmecs.controllers;

import static com.jayway.restassured.RestAssured.given;

import com.atmecs.common_interfaces.Request;
import com.atmecs.rest_request.DELETERequest;
import com.atmecs.rest_request.GETRequest;
import com.atmecs.rest_request.POSTRequest;
import com.atmecs.rest_request.PUTRequest;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;



public class ProcessRequest {

	private Response response;
	String uri;
	
	//Method to make the request according to request type
	public Response process(Request request) {
		
		switch (request.getClass().getSimpleName()) {

			case "GETRequest":
					processGET(request);
				break;
			case "POSTRequest":
					processPOST(request);
				break;
			case "PUTRequest":
					processPUT(request);
				break;
			case "DELETERequest":
					processDELETE(request);
				break;
			default:
					System.out.println("Invalid request type");
				break;
		}

		return response;
	}

	
	
	public void processGET(Request request) {

		GETRequest getRequest = (GETRequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();

		uri = getRequest.getUri();

		if (!getRequest.getHeaderParam().isEmpty())
			builder.addHeaders(getRequest.getHeaderParam());

		if (!getRequest.getPathParam().isEmpty())
			builder.addPathParams(getRequest.getPathParam());

		if (!getRequest.getQueryParam().isEmpty())
			builder.addQueryParams(getRequest.getQueryParam());

		RequestSpecification requestSpecification = builder.build();
		response = given().
						spec(requestSpecification).
				   when().
				   		get(uri);
		
	}
	
	
	public void processPOST(Request request) {
		
		POSTRequest postRequest = (POSTRequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(postRequest.getUri() != null)
			uri = postRequest.getUri();
		
		if(!postRequest.getHeaderParam().isEmpty())
			builder.addHeaders(postRequest.getHeaderParam());
		
		if(!postRequest.getBody().isEmpty())
			builder.setBody(postRequest.getBody());
		
		if(!postRequest.getRequestMediaType().isEmpty())
			builder.setContentType(postRequest.getRequestMediaType());
		
		RequestSpecification requestSpecification =  builder.build();
		response = given().
						spec(requestSpecification).
				   when().
				   		post(uri);
	}
	

	public void processPUT(Request request) {
		
		PUTRequest putRequest = (PUTRequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(putRequest.getUri() != null) 
			uri = putRequest.getUri();
		
		if(!putRequest.getHeaderParam().isEmpty())
			builder.addHeaders(putRequest.getHeaderParam());
		
		if(!putRequest.getBody().isEmpty())
			builder.setBody(putRequest.getBody());
		
		if(!putRequest.getRequestMediaType().isEmpty())
			builder.setContentType(putRequest.getRequestMediaType());
		
		RequestSpecification requestSpecification =  builder.build();
		response = given().
						spec(requestSpecification).
				   when().
				   		put(uri);
	}

	
	public void processDELETE(Request request) {
		
		DELETERequest deleteRequest = (DELETERequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(deleteRequest.getUri() != null)
			uri = deleteRequest.getUri();
	
		if(!deleteRequest.getHeaderParam().isEmpty())
			builder.addHeaders(deleteRequest.getHeaderParam());
		
		RequestSpecification requestSpecification =  builder.build();
		response = given().
						spec(requestSpecification).
				   when().
				   		delete(uri);
		
	}

}
