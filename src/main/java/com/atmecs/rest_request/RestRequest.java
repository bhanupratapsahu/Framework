/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.Map;

import com.atmecs.common_interfaces.Request;

public interface RestRequest extends Request {

	public void setRequestMediaType(String mediaType);

	public String getRequestMediaType();

	public void setResponseMediaType(String mediaType);

	public String getResponseMediaType();

	public void setBody(String requestBody);

	public String getBody();

	public void setHeaderParam(Map<String, String> map);

	public Map<String, String> getHeaderParam();

	public void setPathParam(Map<String, String> map);

	public Map<String, String> getPathParam();

	public void setQueryParam(Map<String, String> map);

	public Map<String, String> getQueryParam();

}
