package com.atmecs.FrameWork;

import com.atmecs.common_interfaces.Request;
import com.atmecs.common_interfaces.Response;
import com.atmecs.controllers.ProcessRequest;
import com.atmecs.controllers.RequestCreator;
import com.atmecs.parsers.JSONParser;
import com.atmecs.rest_request.GETRequest;
import com.atmecs.rest_response.RestResponseImpl;
import com.jayway.restassured.path.json.JsonPath;


public class Test {
	public static void main(String[] args) {
		
		RequestCreator requestCreator = new RequestCreator();
		JSONParser jsonParser = new JSONParser();
		JsonPath jsonPath = jsonParser.parseJSONFile("/home/kalpesh/testcase.json");
		
		GETRequest getRequest = requestCreator.createGETRequest(jsonPath);
		Request request = getRequest;
		ProcessRequest processRequest = new ProcessRequest();
		Response response = processRequest.process(request);
<<<<<<< HEAD
		System.out.println(response.body().asString());
		System.out.println(response.headers().iterator().next().getValue());
=======
		System.out.println(((RestResponseImpl)response).getBody());
>>>>>>> 2355bf7d45b75fb72127d02bcf067ab8cdaadc99
	}

}
