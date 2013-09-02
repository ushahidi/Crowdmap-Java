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
import com.crowdmap.java.sdk.service.CrowdmapService;
import com.crowdmap.java.sdk.service.ExternalService;
import com.crowdmap.java.sdk.service.LocationService;
import com.crowdmap.java.sdk.service.MapService;
import com.crowdmap.java.sdk.service.MediaService;
import com.crowdmap.java.sdk.service.ModerationService;
import com.crowdmap.java.sdk.service.SessionService;
import com.crowdmap.java.sdk.service.UserService;
import com.crowdmap.java.sdk.service.UtilityService;

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

    public Crowdmap(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
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
            service.getClient().setConnectionTimeout(this.connectionTimeout);
        }

        if (this.socketTimeout != null) {
            service.getClient().setSocketTimeout(this.socketTimeout);
        }

        if ((this.privateKey != null)) {
            service.setPrivateKey(this.privateKey);
        }

        if ((this.publicKey != null)) {
            service.setPublicKey(this.publicKey);
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
}
