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
package com.crowdmap.java.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;
import com.crowdmap.java.sdk.json.UsersDeserializer;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.net.ICrowdmapConstants;
import com.crowdmap.java.sdk.net.SignRequestClient;
import com.crowdmap.java.sdk.service.ExternalService;
import com.crowdmap.java.sdk.service.LocationService;
import com.crowdmap.java.sdk.service.MediaService;
import com.crowdmap.java.sdk.service.SessionService;
import com.crowdmap.java.sdk.service.UserService;
import com.crowdmap.java.sdk.service.UtilityService;
import com.crowdmap.java.sdk.service.api.UtilityInterface;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.GsonConverter;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;


/**
 * Creates the various Crowdmap API resources. Create an object of this class to get to the various
 * services supported by the Crowdmap API.
 */
public class CrowdmapApiModule {

    private static Gson gson;

    private RestAdapter restAdapter;

    private CrowdmapApiKeys mCrowdmapApiKeys;

    static {
        Type userListType = new TypeToken<List<User>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.registerTypeAdapter(userListType, new UsersDeserializer());
        builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }

    public CrowdmapApiModule(Endpoint endpoint, Client client, ApiHeaders headers,
            CrowdmapApiKeys crowdmapApiKeys) {
        if (crowdmapApiKeys == null) {
            throw new IllegalArgumentException(
                    "Crowdmap API Key cannot be public. Please provide a valid api key");
        }
        this.mCrowdmapApiKeys = crowdmapApiKeys;

        this.restAdapter = new RestAdapter.Builder()
                .setClient(client)
                .setEndpoint(endpoint)
                .setRequestInterceptor(headers)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();
    }

    public CrowdmapApiModule(CrowdmapApiKeys crowdmapApiKeys) {
        this(Endpoints.newFixedEndpoint(ICrowdmapConstants.CROWDMAP_HOST_API),
                new SignRequestClient(crowdmapApiKeys), new ApiHeaders(), crowdmapApiKeys);
    }

    public CrowdmapApiModule(RestAdapter adapter, CrowdmapApiKeys crowdmapApiKeys) {
        this(crowdmapApiKeys);
        this.restAdapter = adapter;
    }

    public UtilityService utilityService() {
        return new UtilityService(restAdapter);
    }

    public ExternalService externalService() {
        return new ExternalService(restAdapter);
    }

    public LocationService locationService() {
        return new LocationService(restAdapter);
    }

    public SessionService sessionService() {
        return new SessionService(restAdapter);
    }

    public UserService userService() {
        return new UserService(restAdapter);
    }

    /**
     * Create a new media service instance
     */
    private MediaService provideMediaService() {
        return new MediaService(restAdapter);
    }
}
