/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;

public class PUTRequest extends RestRequestImpl {


	String uri;
	String responseMediaType;
	String requestMediaType;
	HashMap<String, String> queryParam;
	HashMap<String, String> headerParam;
	HashMap<String, String> pathParam;
	String body;
	
	@Override
	public String getUri() {
		return uri;
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String getResponseMediaType() {
		return responseMediaType;
	}
	
	@Override
	public void setResponseMediaType(String mediaType) {
		this.responseMediaType = mediaType;
	}

	public String getRequestMediaType() {
		return requestMediaType;
	}

	public void setRequestMediaType(String mediaType) {
		this.requestMediaType = mediaType;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


}
