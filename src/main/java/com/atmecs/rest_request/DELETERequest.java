/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public HashMap<String, String> getQueryParam() {
		return queryParam;
	}
	
	@Override
	public void setQueryParam(Map<String, String> map) {
		this.queryParam.putAll(map);
	}

	@Override
	public HashMap<String, String> getHeaderParam() {
		return headerParam;
	}

	@Override
	public void setHeaderParam(Map<String, String> map) {
		this.headerParam.putAll(map);
	}

	@Override
	public HashMap<String, String> getPathParam() {
		return pathParam;
	}

	@Override
	public void setPathParam(Map<String, String> map) {
		this.pathParam.putAll(map);
	}

}
