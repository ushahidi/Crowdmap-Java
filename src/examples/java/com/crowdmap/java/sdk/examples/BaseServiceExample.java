/*******************************************************************************
 * Copyright (c) 2010 - 2014 Ushahidi Inc.
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

package com.crowdmap.java.sdk.examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.CrowdmapApiKeys;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;
import com.crowdmap.java.sdk.json.UsersDeserializer;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.net.SignRequestClient;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * Base class
 */
public abstract class BaseServiceExample {

    static Gson gson;

    public Crowdmap mModule;

    static {
        Type userListType = new TypeToken<List<User>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.registerTypeAdapter(userListType, new UsersDeserializer());
        builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }

    public BaseServiceExample(String pubKey, String privKey) {

        CrowdmapApiKeys keys = new CrowdmapApiKeys(pubKey, privKey);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(new SignRequestClient(keys))
                .setEndpoint(Endpoints.newFixedEndpoint("http://api.crdmp3.com/v1"))
                .setRequestInterceptor(new ExampleApiHeaders())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        mModule = new Crowdmap(restAdapter, keys);
    }

    class ExampleApiHeaders implements RequestInterceptor {

        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("User-Agent", "Test Crowdmap SDK Client");
        }
    }
}
