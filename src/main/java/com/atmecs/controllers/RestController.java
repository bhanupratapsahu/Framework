package com.atmecs.controllers;

import com.atmecs.common_interfaces.Request;
import com.atmecs.common_interfaces.Response;
import com.atmecs.parsers.JSONParser;
import com.jayway.restassured.path.json.JsonPath;


public class RestController {
	
	private JsonPath jsonPath;
	public Request requestReference;
	public RequestCreator requestCreatorObject = new RequestCreator();	
	public JSONParser parseFile = new JSONParser();	
	public Response responseRef;	
	public Assertion assertionObject;
	
	public void getFile(String filePath) {
		jsonPath = parseFile.parseJSONFile(filePath);
	}

}
