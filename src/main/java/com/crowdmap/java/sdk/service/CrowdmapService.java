/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 *****************************************************************************/
package com.crowdmap.java.sdk.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;
import com.crowdmap.java.sdk.util.Util;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * Base crowdmap service class
 */
public class CrowdmapService {

    public static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());

        builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }

    protected CrowdmapHttpClient client;

    /**
     * private app key value *
     */
    private String privateKey;

    /**
     * public app key value *
     */
    private String publicKey;

    /**
     * Create a the task using the default {@link com.crowdmap.java.sdk.net.CrowdmapHttpClient}
     *
     * @param client The HttpClient
     */
    public CrowdmapService(CrowdmapHttpClient client) {

        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.client = client;
    }

    /**
     * Create a service using a default {@link com.crowdmap.java.sdk.net.CrowdmapHttpClient}
     */
    public CrowdmapService() {
        this(new CrowdmapHttpClient());
    }

    /**
     * Get the configured HTTP client
     */
    public CrowdmapHttpClient getClient() {
        return client;
    }

    /**
     * Check that id is not null and not empty
     *
     * @return id
     */
    protected String checkId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (id.length() == 0) {
            throw new IllegalArgumentException("Id cannot be empty");
        }
        return id;
    }

    /**
     * Deserialize the JSON string into Java objects representing the various Crowdmap models.
     *
     * @param json the json string to be converted
     * @param cls  the class for the model
     * @return The Object related to the Crowdmap API model
     */
    public static <T> T fromString(String json, Class<T> cls) {

        return gson.fromJson(json, cls);
    }

    /**
     * Serialize an Object into JSON objects.
     *
     * @param obj the object to be serialized
     * @return the json string
     */
    public static String toJson(final Object obj) {

        return gson.toJson(obj);
    }

    public CrowdmapService limit(int limit) {
        if (limit > 0) {
            getClient().setRequestParameters("limit", String.valueOf(limit));
        }
        return this;
    }

    public CrowdmapService offset(int offset) {

        if (getClient().getRequestParameters().containsKey("limit")) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        getClient().setRequestParameters("offset", String.valueOf(offset));
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * Set the application signature key for every request.
     */
    protected void setApiKey(String method, String uri) {
        //generate the api key
        final String apiKey = Util
                .generateSignature(method, uri, getPublicKey(), getPrivateKey());
        // set the apikey for the request
        client.setApiKey(apiKey);
    }
}
