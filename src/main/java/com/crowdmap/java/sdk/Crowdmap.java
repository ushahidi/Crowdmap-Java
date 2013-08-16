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

import com.crowdmap.java.sdk.resource.CrowdmapResource;
import com.crowdmap.java.sdk.resource.MediaResource;

/**
 * Creates the various Crowdmap API resources
 */
public class Crowdmap {
    /** private app key value **/
    private String apiKey;

    /** User password. */
    private String password;

    /** Username **/
    private String username;

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
    public Crowdmap setAppKey(String value) {
        this.apiKey = value;
        return this;
    }

    /**
     * Set default authentication credentials.
     *
     * @param email User email.
     * @param password User password.
     * @return Current instance.
     */
    public Crowdmap setAuthentication(String email, String password) {
        this.username = email;
        this.password = password;
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

    private void setupResource(CrowdmapResource resource) {

        if(this.connectionTimeout != null) {
            resource.getClient().setConnectionTimeout(this.connectionTimeout);
        }

        if(this.socketTimeout != null) {
            resource.getClient().setSocketTimeout(this.socketTimeout);
        }

        if((this.username != null) && (this.password != null) ) {
            resource.getClient().setAuthentication(this.username, this.password);
        }

    }

    /**
     * Create a new media resource instance
     *
     */
    public static final MediaResource newMediaResource() {
        return new MediaResource();
    }

    /**
     * Get media resource
     *
     * @return Media Resource
     */
    public MediaResource mediaResource() {
        MediaResource resource = Crowdmap.newMediaResource();
        return resource;
    }

}
