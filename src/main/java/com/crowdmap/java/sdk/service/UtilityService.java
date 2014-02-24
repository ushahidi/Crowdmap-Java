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

import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.UtilityInterface;

import retrofit.RestAdapter;

/**
 * The Utility service provide resources for useful information about the Crowdmap API
 */
public class UtilityService extends CrowdmapService<UtilityService> {

    private UtilityInterface utility;

    public UtilityService(RestAdapter restAdapter) {
        super(restAdapter);
        utility = restAdapter.create(UtilityInterface.class);
    }


    /**
     * Get status of the Crowdmap service.
     */
    public void heartbeat(ApiCallback<Response> callback) {
        utility.heartbeat(callback);
    }


    /**
     * Get the details of which version of the Crowdmap API you're accessing and some defaults
     * values like the range of acceptable limits for results, etc.
     *
     * @return Details about the Crowdmap API
     */
    public void about(ApiCallback<About> callback) {
        utility.about(callback);
    }

    /**
     * Get an embed link
     *
     * @param url A Crowdmap encoded URL.
     * @return OEmbed details
     */
    public void oEmbed(String url, ApiCallback<OEmbed> callback) {
        utility.oEmbed(url, callback);
    }

    /**
     * Verify that a subdomain has been registered on Crowdmap or not.
     *
     * @param subdomain The name of the subdomain to check for
     * @return The registeration details.
     */
    public void registeredMap(String subdomain, ApiCallback<RegisteredMap> callback) {
        utility.registeredMap(subdomain, callback);
    }

}
