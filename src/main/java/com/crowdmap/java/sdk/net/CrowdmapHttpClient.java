/*******************************************************************************
 * Copyright (c) 2010 - 2013 Ushahidi Inc.
 * All rights reserved
 * Website: http://www.ushahidi.com
 *
 * GNU AFFERO GENERAL PUBLIC LICENSE Version 3 Usage
 * This file may be used under the terms of the GNU AFFERO GENERAL
 * PUBLIC LICENSE Version 3 as published by the Free Software
 * Foundation and appearing in the file LICENSE included in the
 * packaging of this file. Please review the following information to
 * ensure the GNU AFFERO GENERAL PUBLIC LICENSE Version 3 requirements
 * will be met: http://www.gnu.org/licenses/agpl.html.
 ******************************************************************************/
package com.crowdmap.java.sdk.net;

import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.net.content.Body;

import java.io.InputStream;
import java.util.Map;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.API_KEY_PARAM;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.CROWDMAP_API;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.GZIP_DEFLATE;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.PROTOCOL_HTTPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SESSION;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.USER_AGENT;

/**
 * The main HTTP Client to interact with the Ushahidi API
 *
 * @author eyedol
 */
public class CrowdmapHttpClient extends BaseHttpClient {

    /**
     * The user agent to use
     */
    private String userAgent = null;

    public static final String METHOD_GET = "GET";

    /**
     * METHOD_PUT
     */
    public static final String METHOD_PUT = "PUT";

    /**
     * METHOD_POST
     */
    public static final String METHOD_POST = "POST";

    /**
     * METHOD_DELETE
     */
    public static final String METHOD_DELETE = "DELETE";

    /**
     * METHOD_MULTIPART. Not really a method. Calling it so to maintain consistency
     */
    private static final String METHOD_MULTIPART = "MULTIPART";

    public CrowdmapHttpClient() {
        super(CROWDMAP_API, -1, PROTOCOL_HTTPS);
        requestHeaders.put("Accept-Encoding", GZIP_DEFLATE);
    }


    /**
     * Set the value to set as the user agent header on every request created. Specifying a null or
     * empty agent parameter will reset this client to use the default user agent header value.
     */
    public void setUserAgent(String agent) {
        if (agent != null && agent.length() > 0) {
            userAgent = agent;
        } else {
            userAgent = USER_AGENT;
        }
    }

    /**
     * Get the user agent
     *
     * @return The user agent
     */
    public String getUserAgent() {
        if (userAgent != null && userAgent.length() > 0) {
            return this.userAgent;
        }
        return USER_AGENT;
    }

    private String request(String url, String method, Body body) {

        if (url == null || method.equals("")) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        if (method == null || method.equals("")) {
            throw new IllegalArgumentException("Method cannot be null or empty");
        }

        InputStream inputStream = null;
        try {
            addRequestHeader("User-Agent", getUserAgent());

            // Which HTTP request method is being executed
            if (method.equals(METHOD_POST)) {

                if (body != null) {
                    inputStream = postRequest(url, body);
                } else {
                    inputStream = postRequest(url);
                }
            } else if (method.equals(METHOD_PUT)) {
                if (body != null) {
                    inputStream = putRequest(url, body);
                }
            } else if (method.equals(METHOD_GET)) {

                inputStream = getRequest(url);
            } else if (method.equals(METHOD_MULTIPART)) {

                if (body != null) {
                    inputStream = postMultipartRequest(url, body);
                }
            } else if (method.equals(METHOD_DELETE)) {
                inputStream = deleteRequest(url);
            }

            if (inputStream != null) {
                return streamToString(inputStream);
            } else {
                throw new CrowdmapException(
                        "Unknown content found in response.");
            }
        } catch (Exception e) {
            throw new CrowdmapException(e);
        } finally {
            closeStream(inputStream);
        }
    }

    /**
     * Sends a GET request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the GET request to.
     * @return The HTTP response string as returned from the server
     */
    public String get(String url) {
        return request(url, METHOD_GET, null);

    }

    /**
     * Sends a DELETE request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the DELETE request to.
     * @return The HTTP response string as returned from the server
     */
    public String delete(String url) {
        return request(url, METHOD_DELETE, null);

    }

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the POST request to.
     * @param body The form fields to be sent
     * @return The HTTP response string as returned from the server
     */
    public String post(String url, Body body) {

        return request(url, METHOD_POST, body);

    }

    /**
     * Sends a PUT request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the PUT request to.
     * @param body The form fields to be sent
     * @return The HTTP response string as returned from the server
     */
    public String put(String url, Body body) {
        return request(url, METHOD_PUT, body);

    }

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the POST request to.
     * @return The HTTP response string as returned from the server
     */
    public String post(String url) {

        return request(url, METHOD_POST, null);
    }

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the POST request to.
     * @param body The parameters to
     * @return The HTTP response string as returned from the server
     */
    public String multipartPost(String url, Body body) {
        return request(url, METHOD_MULTIPART, body);

    }

    /**
     * Set the request parameters
     *
     * @param key   The variable name
     * @param value The variable value
     */
    public void setRequestParameters(String key, String value) {
        requestParameters.put(key, value);
    }

    public Map<String, String> getRequestParameters() {
        return this.requestParameters;
    }

    /**
     * Set the API key to be used for signing the various API request
     */
    public void setApiKey(String apiKey) {
        setRequestParameters(API_KEY_PARAM, apiKey);
    }

    public void setSessionKey(String session){
        setRequestParameters(SESSION, session);
    }
}
