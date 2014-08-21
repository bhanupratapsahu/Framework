/**
 * bhanu
 */
package com.atmecs.rest_request;

import java.util.HashMap;

import com.atmecs.common_interfaces.Request;

public interface RestRequest extends Request {

	public void setRequestMediaType(String mediaType);

	public String getRequestMediaType();

	public void setResponseMediaType(String mediaType);

	public String getResponseMediaType();

	public void setBody(String requestBody);

	public String getBody();

	public void setHeaderParam(String key, String value);

	public HashMap<String, String> getHeaderParam();

	public void setpathParam(String key, String value);

	public HashMap<String, String> getPathParam();

	public void setQueryParam(String key, String value);

	public HashMap<String, String> getQueryParam();

}
