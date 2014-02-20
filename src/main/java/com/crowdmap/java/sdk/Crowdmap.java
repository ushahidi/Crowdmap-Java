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

import com.crowdmap.java.sdk.json.Session;
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

import retrofit.RestAdapter;

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
     * Connection timeout (in milliseconds).
     */

    private Integer connectionTimeout;

    /**
     * Socket timeout (in milliseconds).
     */
    private Integer socketTimeout;

    /**
     * The HTTP client to use.
     */
    private HttpClient httpClient;

    private RestAdapter restAdapter;

    private static RequestParam mRequestParam;

    public Crowdmap(RestAdapter restAdapter, RequestParam requestParam) {
        this.restAdapter = restAdapter;
        this.mRequestParam = requestParam;
    }

    public Crowdmap(RequestParam requestParam) {
        this(null, requestParam);
    }

    /**
     * Default constructor
     *
     * @param publicKey  The Crowdmap public key.
     * @param privateKey The Crowdmap private key.
     */

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
    }

    /**
     * Provide custom implementation of the HTTP client.
     *
     * @param httpClient The custom HTTP client to use.
     * @param publicKey  The Crowdmap public key.
     * @param privateKey The Crowdmap private key.
     */
    public Crowdmap(HttpClient httpClient, String publicKey, String privateKey) {
        this(publicKey, privateKey);
        this.httpClient = httpClient;
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

        if (this.httpClient != null) {
            service.setHttpClient(this.httpClient);
        } else {
            service.setHttpClient(new CrowdmapHttpClient());
        }
    }

    /**
     * Create a new media service instance
     */
    private static final MediaService newMediaService() {
        return new MediaService(mRequestParam);
    }

    /**
     * Create a new session service instance
     */
    private static final SessionService newSessionService() {
        return new SessionService(mRequestParam);
    }

    private static final UserService newUserService() {
        return new UserService(mRequestParam);
    }

    private static final MapService newMapService() {
        return new MapService(mRequestParam);
    }

    private static final UtilityService newUtilitySerivce() {
        return null;
    }

    private static final ModerationService newModerationSerivce() {
        return new ModerationService(mRequestParam);
    }

    private static final ExternalService newExternalService() {
        return new ExternalService(mRequestParam);
    }

    private static final LocationService newLocationService() {
        return new LocationService(mRequestParam);
    }

    private static final PostService newPostService() {
        return new PostService(mRequestParam);
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