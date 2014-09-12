/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;
import java.util.Map;

public class GETRequest extends RestRequestImpl {

	String uri;
	String responseMediaType;
	Map<String, String> queryParam = new HashMap<String, String>();
	Map<String, String> headerParam = new HashMap<String, String>();
	Map<String, String> pathParam = new HashMap<String, String>();
	
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

	
}
