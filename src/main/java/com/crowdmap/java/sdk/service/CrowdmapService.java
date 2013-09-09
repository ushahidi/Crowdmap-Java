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
package com.crowdmap.java.sdk.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.json.UsersDeserializer;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;
import com.crowdmap.java.sdk.net.HttpClient;
import com.crowdmap.java.sdk.util.Util;
import com.crowdmap.java.sdk.util.ValidateUtil;

import java.lang.reflect.Type;
import java.util.List;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * Base crowdmap service class
 */
public abstract class CrowdmapService {

    public static Gson gson;

    static {
        Type userListType = new TypeToken<List<User>>() {
        }.getType();
        Type type = new TypeToken<Response>() {

        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.registerTypeAdapter(userListType, new UsersDeserializer());
        builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }

    protected HttpClient client;

    /**
     * private app key value *
     */
    private String privateKey;

    /**
     * public app key value *
     */
    private String publicKey;

    private String sessionToken;

    /**
     * Set the default {@link com.crowdmap.java.sdk.net.HttpClient}
     *
     * @param client The HttpClient
     */
    public void setHttpClient(HttpClient client) {

        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.client = client;
    }

    /**
     * Get the configured HTTP client
     */
    public HttpClient getHttpClient() {
        return client;
    }

    /**
     * Check that id is not null and not empty
     *
     * @param id The ID to check.
     */
    protected void checkId(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Id cannot be zero");
        }
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

    public void setSessionToken(String sessionToken) {
        if ((sessionToken == null) || (sessionToken.length() == 0)) {
            throw new IllegalArgumentException("Session token cannot be null or empty");
        }
        this.sessionToken = sessionToken;
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

    protected void initSession() {
        if (ValidateUtil.empty(sessionToken)) {
            throw new IllegalArgumentException(
                    "This action requires a valid sessionToken. You will have to login then provide the "
                            + "sessionToken id returned");
        }
        client.setSessionToken(this.sessionToken);
    }

    public String getSessionToken() {
        return sessionToken;
    }
}
