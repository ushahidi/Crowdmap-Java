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

import com.crowdmap.java.sdk.service.CrowdmapService;
import com.crowdmap.java.sdk.service.MapService;
import com.crowdmap.java.sdk.service.MediaService;
import com.crowdmap.java.sdk.service.ModerationService;
import com.crowdmap.java.sdk.service.SessionService;
import com.crowdmap.java.sdk.service.UserService;
import com.crowdmap.java.sdk.service.UtilityService;

/**
 * Creates the various Crowdmap API resources
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

    public Crowdmap login(String username, String password) {

        if ((username == null) || (username.length() == 0)) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if ((password == null) || (password.length() == 0)) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        return this;
    }

    private void setupResource(CrowdmapService resource) {

        if (this.connectionTimeout != null) {
            resource.getClient().setConnectionTimeout(this.connectionTimeout);
        }

        if (this.socketTimeout != null) {
            resource.getClient().setSocketTimeout(this.socketTimeout);
        }

        if ((this.privateKey != null)) {
            resource.setPrivateKey(this.privateKey);
        }

        if ((this.publicKey != null)) {
            resource.setPublicKey(this.publicKey);
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

    /**
     * Get media service
     *
     * @return Media Resource
     */
    public MediaService mediaService() {
        MediaService service = Crowdmap.newMediaService();
        this.setupResource(service);
        return service;
    }

    /**
     * Get the Session service
     *
     * @return Session service instance
     */
    public SessionService sessionService() {
        SessionService service = Crowdmap.newSessionService();
        this.setupResource(service);
        return service;
    }

    /**
     * Get the User service
     *
     * @return User service instance
     */
    public UserService userService() {
        UserService service = Crowdmap.newUserService();
        this.setupResource(service);
        return service;
    }

    /**
     * Get the Map service
     *
     * @return Map service instance
     */
    public MapService mapService() {
        MapService service = Crowdmap.newMapService();
        this.setupResource(service);
        return service;
    }

    /**
     * Get the Utility service
     *
     * @return Utility service instance
     */
    public UtilityService utilityService() {
        UtilityService service = Crowdmap.newUtilitySerivce();
        this.setupResource(service);
        return service;
    }

    /**
     * Get the Moderation service
     *
     * @return Moderation service instance
     */
    public ModerationService moderationService() {
        ModerationService service = Crowdmap.newModerationSerivce();
        this.setupResource(service);
        return service;
    }
}
