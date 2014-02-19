package com.crowdmap.java.sdk.net;

import com.crowdmap.java.sdk.net.content.Body;

import java.util.Map;

/**
 * Interface for the HTTP Client to be used for the web service interactions
 */
public interface HttpClient {

    /**
     * Sends a GET request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the GET request to.
     * @return The HTTP response string as returned from the server
     */
    public String get(String url);

    /**
     * Sends a DELETE request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the DELETE request to.
     * @return The HTTP response string as returned from the server
     */
    public String delete(String url);

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the POST request to.
     * @param body The form fields to be sent
     * @return The HTTP response string as returned from the server
     */
    public String post(String url, Body body);

    /**
     * Sends a PUT request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the PUT request to.
     * @param body The form fields to be sent
     * @return The HTTP response string as returned from the server
     */
    public String put(String url, Body body);

    /**
     * Sends a PUT request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the PUT request to.
     * @return The HTTP response string as returned from the server
     */
    public String put(String url);

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url The URL to send the POST request to.
     * @return The HTTP response string as returned from the server
     */
    public String post(String url);

    /**
     * Sends a POST request to the supplied URL. Converts the input stream as received from the
     * server to string.
     *
     * @param url  The URL to send the POST request to.
     * @param body The parameters to
     * @return The HTTP response string as returned from the server
     */
    public String multipartPost(String url, Body body);

    /**
     * Set the request parameters
     *
     * @param key   The variable name
     * @param value The variable value
     */
    public void setRequestParameters(String key, String value);

    /**
     * Get the request parameters.
     *
     * @return A map containing the request parameters. key=>value
     */
    public Map<String, String> getRequestParameters();

    /**
     * Set the API key to be used for signing the various API request
     */
    public void setApiKey(String apiKey);

    /**
     * Set the session token.
     *
     * @param session The session token.
     */
    public void setSessionToken(String session);

    /**
     * Set the value to set as the user agent header on every request created. Specifying a null or
     * empty agent parameter will reset this client to use the default user agent header value.
     *
     * @param agent The String labeling the user agent.
     */
    public void setUserAgent(String agent);

    /**
     * Get the user agent
     *
     * @return The user agent
     */
    public String getUserAgent();

    /**
     * Set the default connection timeout.
     *
     * @param connectionTimeout The connection timeout in miliseconds
     */
    public void setConnectionTimeout(int connectionTimeout);

    /**
     * Get the connection timeout.
     *
     * @return The set connection timeout
     */
    public int getConnectionTimeout();

    /**
     * Set the socket timeout. The default socket timeout is 3 secs.
     *
     * @param socketTimeout An <code>int</code> that specifies the socket timeout value in
     *                      milliseconds
     */
    public void setSocketTimeout(int socketTimeout);

    /**
     * Get the socket timeout.
     *
     * @return The socket timeout in milliseconds
     */
    public int getSocketTimeout();

    public String requestUrl = null;
}
