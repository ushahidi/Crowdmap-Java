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
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.json.UsersDeserializer;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.model.form.LoginForm;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;
import com.crowdmap.java.sdk.net.HttpClient;
import com.crowdmap.java.sdk.service.CrowdmapService;
import com.crowdmap.java.sdk.service.ExternalService;
import com.crowdmap.java.sdk.service.LocationService;
import com.crowdmap.java.sdk.service.MapService;
import com.crowdmap.java.sdk.service.MediaService;
import com.crowdmap.java.sdk.service.ModerationService;
import com.crowdmap.java.sdk.service.PostService;
import com.crowdmap.java.sdk.service.SessionService;
import com.crowdmap.java.sdk.service.UserService;
import com.crowdmap.java.sdk.service.UtilityService;
import com.crowdmap.java.sdk.util.ValidateUtil;
import com.squareup.okhttp.OkHttpClient;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.Server;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.CROWDMAP_API;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * Creates the various Crowdmap API resources. Create an object of this class to get to the various
 * services supported by the Crowdmap API.
 */
public class Crowdmap {

    /**
     * private app key value *
     */
    private String privateKey;

    /**
     * public app key value *
     */
    private String publicKey;

    /**
     * Default constructor
     *
     * @param publicKey The Crowdmap public key.
     *
     * @param privateKey The Crowdmap private key.
     */

    private static Gson gson;

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
    public Crowdmap(String publicKey, String privateKey) {
        if (ValidateUtil.empty(publicKey)) {
            throw new IllegalArgumentException(
                    "Public key cannot be null or empty. Please provide a valid public key");
        }

        if (ValidateUtil.empty(privateKey)) {
            throw new IllegalArgumentException(
                    "Private key cannot be null or empty. Please provide a valid private key");
        }

        this.publicKey = publicKey;

        this.privateKey = privateKey;

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(CROWDMAP_API)
                .setConverter(new GsonConverter(gson))
                .build();
    }

    @Provides
    @Singleton
    Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, Client client) {
        return new RestAdapter.Builder() //
                .setClient(client) //
                .setEndpoint(endpoint) //
                .build();
    }

    @Provides @Singleton GalleryService provideGalleryService(RestAdapter restAdapter) {
        return restAdapter.create(GalleryService.class);
    }

    /**
     * Set default  connection timeout.
     *
     * @param connectionTimeout The timeout in milliseconds.
     * @return Current instance.
     */
    public Crowdmap setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    /**
     * Set default socket timeout.
     *
     * @param socketTimeout The read timeout in milliseconds
     * @return Current instance.
     */
    public Crowdmap setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
        return this;
    }

    public Session login(String username, String password) {

        LoginForm form = new LoginForm(username, password);
        return sessionService().login(form);

    }

    private void setupService(CrowdmapService service) {

        if (this.connectionTimeout != null) {
            service.getHttpClient().setConnectionTimeout(this.connectionTimeout);
        }

        if (this.socketTimeout != null) {
            service.getHttpClient().setSocketTimeout(this.socketTimeout);
        }

        if ((this.privateKey != null)) {
            service.setPrivateKey(this.privateKey);
        }

        if ((this.publicKey != null)) {
            service.setPublicKey(this.publicKey);
        }

        if( this.httpClient != null) {
            service.setHttpClient(this.httpClient);
        } else {
            service.setHttpClient(new CrowdmapHttpClient());
        }
    }

    /**
     * Create a new media service instance
     */
    private static final MediaService newMediaService() {
        return new MediaService();
    }

    /**
     * Create a new session service instance
     */
    private static final SessionService newSessionService() {
        return new SessionService();
    }

    private static final UserService newUserService() {
        return new UserService();
    }

    private static final MapService newMapService() {
        return new MapService();
    }

    private static final UtilityService newUtilitySerivce() {
        return new UtilityService();
    }

    private static final ModerationService newModerationSerivce() {
        return new ModerationService();
    }

    private static final ExternalService newExternalService() {
        return new ExternalService();
    }

    private static final LocationService newLocationService() {
        return new LocationService();
    }

    private static final PostService newPostService() {
        return new PostService();
    }

    /**
     * Get media service
     *
     * @return Media Resource
     */
    public MediaService mediaService() {
        MediaService service = Crowdmap.newMediaService();
        this.setupService(service);
        return service;
    }

    /**
     * Get the Session service
     *
     * @return Session service instance
     */
    public SessionService sessionService() {
        SessionService service = Crowdmap.newSessionService();
        this.setupService(service);
        return service;
    }

    /**
     * Get the User service
     *
     * @return User service instance
     */
    public UserService userService() {
        UserService service = Crowdmap.newUserService();
        this.setupService(service);
        return service;
    }

    /**
     * Get the Map service
     *
     * @return Map service instance
     */
    public MapService mapService() {
        MapService service = Crowdmap.newMapService();
        this.setupService(service);
        return service;
    }

    /**
     * Get the Utility service
     *
     * @return Utility service instance
     */
    public UtilityService utilityService() {
        UtilityService service = Crowdmap.newUtilitySerivce();
        this.setupService(service);
        return service;
    }

    /**
     * Get the Moderation service
     *
     * @return Moderation service instance
     */
    public ModerationService moderationService() {
        ModerationService service = Crowdmap.newModerationSerivce();
        this.setupService(service);
        return service;
    }

    public ExternalService externalService() {
        ExternalService service = Crowdmap.newExternalService();
        setupService(service);
        return service;
    }

    public LocationService locationService() {
        LocationService service = Crowdmap.newLocationService();
        setupService(service);
        return service;
    }

    public PostService postService() {
        PostService service = Crowdmap.newPostService();
        setupService(service);
        return service;
    }
}
