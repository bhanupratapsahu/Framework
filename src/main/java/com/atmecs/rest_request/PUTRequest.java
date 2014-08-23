/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;
import java.util.Map;

public class PUTRequest extends RestRequestImpl {


	String uri;
	String responseMediaType;
	String requestMediaType;
	Map<String, String> queryParam = new HashMap<String, String>();
	Map<String, String> headerParam = new HashMap<String, String>();
	Map<String, String> pathParam = new HashMap<String, String>();
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

	@Override
	public String getRequestMediaType() {
		return requestMediaType;
	}

	@Override
	public void setRequestMediaType(String mediaType) {
		this.requestMediaType = mediaType;
	}

	@Override
	public Map<String, String> getQueryParam() {
		return queryParam;
	}
	
	@Override
	public void setQueryParam(Map<String, String> map) {
		this.queryParam.putAll(map);
	}

	@Override
	public Map<String, String> getHeaderParam() {
		return headerParam;
	}

	@Override
	public void setHeaderParam(Map<String, String> map) {
		this.headerParam.putAll(map);
	}

	@Override
	public Map<String, String> getPathParam() {
		return pathParam;
	}

	@Override
	public void setPathParam(Map<String, String> map) {
		this.pathParam.putAll(map);
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}

}
