/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;

public class DELETERequest extends RestRequestImpl {

	String uri;
	String responseMediaType;
	HashMap<String, String> queryParam;
	HashMap<String, String> headerParam;
	HashMap<String, String> pathParam;
	
	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String getUri() {
		return uri;
	}

	@Override
	public void setResponseMediaType(String mediaType) {
		this.responseMediaType = mediaType;
		
	}

	@Override
	public String getResponseMediaType() {
		return responseMediaType;
	}

	public HashMap<String, String> getQueryParam() {
		return queryParam;
	}
	
	public void setQueryParam(String key, String value) {
		this.queryParam.put(key, value);
	}

	public HashMap<String, String> getHeaderParam() {
		return headerParam;
	}

	public void setHeaderParam(String key, String value) {
		this.headerParam.put(key, value);
	}

	public HashMap<String, String> getPathParam() {
		return pathParam;
	}

	public void setPathParam(String key, String value) {
		this.pathParam.put(key, value);
	}

}
