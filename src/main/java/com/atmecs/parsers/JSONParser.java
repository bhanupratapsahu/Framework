package com.atmecs.parsers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.jayway.restassured.path.json.JsonPath;


public class JSONParser implements Parser {

	private String value = null;

	public JsonPath parseJSONFile(String jsonFilePath) {
		String jsonText = "";
		String line = null;
		JsonPath jsonPath = null;

		try {
			InputStream inputStream = new FileInputStream(jsonFilePath);

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				jsonText += line + "\n";
			}
			inputStream.close();
			
			jsonPath = new JsonPath(jsonText);
			
		} catch (FileNotFoundException e1) {
			System.out.println("Unable to locate the file on the specified path");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read/write the specified file");
			e.printStackTrace();
		}
		
		return jsonPath;
	}
	
	public JsonPath parseJSONString(String json) {
		JsonPath jsonPath = new JsonPath(json);
		return jsonPath;
	}

	@Override
	public String getValue(String key) {
		return value;
	}
}
