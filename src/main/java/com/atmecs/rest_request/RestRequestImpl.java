/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.Map;

public abstract class RestRequestImpl implements RestRequest{

	@Override
	public abstract String getUri();

	@Override
	public abstract void setUri(String uri);

	@Override
	public abstract void setResponseMediaType(String mediaType);

	@Override
	public abstract String getResponseMediaType();
	
	@Override
	public void setRequestMediaType(String mediaType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRequestMediaType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBody(String requestBody) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHeaderParam(Map<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getHeaderParam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPathParam(Map<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getPathParam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setQueryParam(Map<String, String> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getQueryParam() {
		// TODO Auto-generated method stub
		return null;
	}

}
