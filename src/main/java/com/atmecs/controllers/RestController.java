package com.atmecs.controllers;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.common_interfaces.Request;
import com.atmecs.common_interfaces.Response;
import com.atmecs.parsers.JSONParser;
import com.jayway.restassured.path.json.JsonPath;


public class RestController implements Controller {

	private JsonPath jsonPath;
	public Request request;
	public RequestCreator requestCreator = new RequestCreator();	
	public JSONParser jsonParser = new JSONParser();	
	public Response responseRef;	
	public Assertion assertionObject;
	public ProcessRequest processRequest = new ProcessRequest();
	com.jayway.restassured.response.Response response;

	 @Test
	 @Parameters("filePath")
	public void restTest(String filePath) {

		 System.out.println(filePath);
		jsonPath = jsonParser.parseJSONFile(filePath);

		switch (jsonPath.getString("method")) {
		case "GET":
			request = requestCreator.createGETRequest(jsonPath);
			break;

		case "PUT":
			request = requestCreator.createPUTRequest(jsonPath);
			break;

		case "POST":
			request = requestCreator.createPOSTRequest(jsonPath);
			break;

		case "DELETE":
			request = requestCreator.createDELETERequest(jsonPath);
			break;

		default:
			System.out.println("Invalid Method type");
			break;
		}

		
		response = processRequest.process(request);
		
		System.out.println(response.asString());
		
	}
}
