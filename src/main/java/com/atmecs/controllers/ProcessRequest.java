package com.atmecs.controllers;

import java.util.Map;

import com.atmecs.common_interfaces.Request;
import com.atmecs.rest_request.DELETERequest;
import com.atmecs.rest_request.GETRequest;
import com.atmecs.rest_request.POSTRequest;
import com.atmecs.rest_request.PUTRequest;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;



public class ProcessRequest {

	private Response response;
	String uri, bodyContent, contentType;
	Map<String, String> headerParam;

	public Response process(Request request) {
		
		/*if(request instanceof GETRequest)
			processGET(request);
		*/
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

	
	
	
	public void processPOST(Request request) {
		System.out.println("inside..");
		POSTRequest postRequest = (POSTRequest) request;
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(postRequest.getUri() != null) {
			uri = postRequest.getUri();
		}
		if(postRequest.getHeaderParam() != null) {
			headerParam = postRequest.getHeaderParam();
			builder.addHeaders(headerParam);
		}
		if(postRequest.getBody() != null) {
			bodyContent = postRequest.getBody();
			builder.setBody(bodyContent);
		}
		if(postRequest.getRequestMediaType() != null) {
			contentType = postRequest.getRequestMediaType();
			builder.setContentType(contentType);
		}
		
		response = builder.build().post(uri);
	}

	public void processPUT(Request request) {
		
		PUTRequest putRequest = (PUTRequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(putRequest.getUri() != null) {
			uri = putRequest.getUri();
		}
		if(putRequest.getHeaderParam() != null) {
			headerParam = putRequest.getHeaderParam();
			builder.addHeaders(headerParam);
		}
		if(putRequest.getBody() != null) {
			bodyContent = putRequest.getBody();
			builder.setBody(bodyContent);
		}
		if(putRequest.getRequestMediaType() != null) {
			contentType = putRequest.getRequestMediaType();
			builder.setContentType(contentType);
		}
		
		response = builder.build().put(uri);
	}

	public void processDELETE(Request request) {
		
		DELETERequest deleteRequest = (DELETERequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(deleteRequest.getUri() != null) {
			uri = deleteRequest.getUri();
		}
		if(deleteRequest.getHeaderParam() != null) {
			headerParam = deleteRequest.getHeaderParam();
			builder.addHeaders(headerParam);
		}
		
		response = builder.build().delete(uri);
	}
	
	public void processGET(Request request) {
		
		GETRequest getRequest = (GETRequest) request;
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		if(getRequest.getUri() != null) {
			uri = getRequest.getUri();
		}
		if(getRequest.getHeaderParam() != null) {
			headerParam = getRequest.getHeaderParam();
			builder.addHeaders(headerParam);
		}
		
		response = builder.build().get(uri);
		
	}
	
	public static void main(String[] args) {
		Request request = new POSTRequest();
		ProcessRequest processRequest = new ProcessRequest();
		processRequest.process(request);
	}
}
