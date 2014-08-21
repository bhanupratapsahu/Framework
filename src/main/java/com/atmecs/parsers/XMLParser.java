package com.atmecs.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.jayway.restassured.path.xml.XmlPath;

public class XMLParser implements Parser{
	
	private String value = null;
	
	public XmlPath parseXMLFile(String xmlFilePath) {
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		XmlPath xmlPath = null;
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
		    Document document = builder.parse(new FileInputStream(xmlFilePath));
		    xmlPath = new XmlPath(document.toString());
		    
		} catch (ParserConfigurationException e) {
		    e.printStackTrace(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return xmlPath;
	}
	
	public XmlPath parseXMLString(String xml) {
		XmlPath xmlPath = new XmlPath(xml);
		return xmlPath;
	}

	@Override
	public String getValue(String key) {
		return value;
	}

}
