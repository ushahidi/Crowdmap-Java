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

package com.crowdmap.java.sdk.examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.CrowdmapApiKeys;
import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.json.Locations;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.UsersDeserializer;
import com.crowdmap.java.sdk.model.External;
import com.crowdmap.java.sdk.model.Geometry;
import com.crowdmap.java.sdk.model.User;
import com.squareup.okhttp.OkHttpClient;

import java.lang.reflect.Type;
import java.util.List;

import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * This example code will show you how to information about the Crowmap API version
 */
public class UtilityServiceExample {

    private Crowdmap mModule;

    static Gson gson;

    static {
        Type userListType = new TypeToken<List<User>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.registerTypeAdapter(userListType, new UsersDeserializer());
        builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = builder.create();
    }


    public UtilityServiceExample(String pubKey, String privKey) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint(Endpoints.newFixedEndpoint("http://api.crdmp3.com/v1"))
                .setRequestInterceptor(new ExampleApiHeaders())
                        //.setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        mModule = new Crowdmap(restAdapter, new CrowdmapApiKeys(privKey, pubKey));
    }

    /**
     * Get the version number of crowdmap
     */
    public void getAbout() {
        About about = mModule.utilityService().about();
        System.out.println(about.toString());
    }

    /**
     * Check if crowdmap api service is up and running
     */
    public void hearbeat() {
        com.crowdmap.java.sdk.json.Response response = mModule.utilityService().heartbeat();
        System.out.println("Heart Beat");
        System.out.println(response.toString() + "\n\n");
    }

    public void oembed() {
        OEmbed embed = mModule.utilityService()
                .oEmbed("https://crowdmap.com/post/832/saw-jonshuler-posting-this-on-facebook-check-out-the");
        System.out.println("Oembed");
        System.out.println(embed.toString() + "\n\n");

    }

    public void getExternal() {
        Externals externals = mModule.externalService().getExternal(1);
        System.out.println("Get Externals");
        System.out.println(externals.toString() + "\n\n");
    }

    public void createExternal() {
        @SessionToken String sessionToken = "ohwhwowow";
        External mExternal = new External();
        mExternal.setId(1);
        mExternal.setServiceId(2);
        mExternal.setIdOnService("365695488227409921");
        mExternal.setContent(
                "Just completed a 4 km bike with @RunKeeper. Check it out! http://t.co/IEB4h7wgb1 #RunKeeper");
        mExternal.setDateTime(new Date(1376023573));
        mExternal.setEmbedHtml(
                "<blockquote class=\"twitter-tweet\"><p>Just completed a 4 km bike with <a href=\"https://twitter.com/RunKeeper\">@RunKeeper</a>. Check it out! <a href=\"http://t.co/IEB4h7wgb1\">http://t.co/IEB4h7wgb1</a> <a href=\"https://twitter.com/search?q=%23RunKeeper&amp;src=hash\">#RunKeeper</a></p>&mdash; Tetsuya Sato - 佐藤哲也 (@satetsu) <a href=\"https://twitter.com/satetsu/statuses/365695488227409921\">August 9, 2013</a></blockquote>\n");
        mExternal.setFaviconUrl("https://twitter.com/favicons/faviico");

        Externals externals = mModule.externalService().createExternal(1, "365695488227409921", sessionToken);
        System.out.println("Create External");
        System.out.println(externals.toString());
    }

    public void getLocations() {
        Locations location = mModule.locationService().getLocation();
        System.out.println("Get Locations ");
        System.out.println(location.toString() + "\n\n");
    }

    public void createLocation() {
        Double[] coordinates = {-48.506087064743, -1.4581703362106};
        Geometry geometry = new Geometry();
        geometry.setType("Point");
        geometry.setCoordinates(coordinates);

        Locations location = mModule.locationService()
                .createLocation("4c9de5a7d3c2b60c1173c5bc", geometry, "Green Hills", "", "test");

        System.out.println("Add A Location");
        System.out.println(location.getLocations().toString() + "\n\n");
    }

    public void login() {
        System.out.println("Login Service");
        mModule.sessionService().login("henry@ushahidi.com", "myPassword");
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args.length < 1) {

            System.out.println("Please provide your apps public key and private key respectively.");
        } else {
            UtilityServiceExample example = new UtilityServiceExample(args[0], args[1]);
            example.getAbout();
            example.hearbeat();
            example.oembed();
            example.getExternal();
            example.createExternal();
            example.getLocations();
            example.createLocation();
            example.login();
        }
    }

    class ExampleApiHeaders implements RequestInterceptor {

        @Override
        public void intercept(RequestFacade request) {
            request.addQueryParam("apikey", "godmode");
            request.addHeader("User-Agent", "Test Crowdmap SDK Client");
        }
    }
}