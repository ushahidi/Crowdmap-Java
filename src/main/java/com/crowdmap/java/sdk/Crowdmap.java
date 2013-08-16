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
package com.crowdmap.java.sdk;

import com.crowdmap.java.sdk.service.CrowdmapService;
import com.crowdmap.java.sdk.service.MediaService;
import com.crowdmap.java.sdk.service.SessionService;
import com.crowdmap.java.sdk.service.UserService;

/**
 * Creates the various Crowdmap API resources
 */
public class Crowdmap {

    /** private app key value **/
    private String apiKey;

    /** Connection timeout (in milliseconds). */

    private Integer connectionTimeout;

    /** Socket timeout (in milliseconds). */
    private Integer socketTimeout;

    public Crowdmap() {}

    /**
     * Set default API key.
     *
     * @param value API key value.
     * @return Current instance for builder pattern.
     */
    public Crowdmap setApiKey(String value) {
        this.apiKey = value;
        return this;
    }

    /**
     * Set default  connection timeout.
     *
     * @param  connectionTimeout The timeout in milliseconds.
     * @return Current instance.
     */
    public Crowdmap setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    /**
     * Set default socket timeout.
     *
     * @param socketTimeout The read timeout in milliseconds
     * @return Current instance.
     */
    public Crowdmap setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
        return this;
    }

    private void setupResource(CrowdmapService resource) {

        if(this.connectionTimeout != null) {
            resource.getClient().setConnectionTimeout(this.connectionTimeout);
        }

        if(this.socketTimeout != null) {
            resource.getClient().setSocketTimeout(this.socketTimeout);
        }

        if((this.apiKey != null)) {
            resource.getClient().setApiKey(this.apiKey);
        }

    }

    /**
     * Create a new media service instance
     *
     */
    public static final MediaService newMediaService() {
        return new MediaService();
    }

    /**
     * Create a new session service instance
     */
    public static final SessionService newSessionService() {
        return new SessionService();
    }

    public static final UserService newUserService() {
        return new UserService();
    }

    /**
     * Get media service
     *
     * @return Image Resource
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

    public UserService userService() {
        UserService service = Crowdmap.newUserService();
        this.setupResource(service);
        return service;
    }
}
