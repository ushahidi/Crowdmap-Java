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

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.LIMIT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.OFFSET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_ABOUT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_HEARTBEAT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_OEMBED;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_REGISTEREDMAP;

/**
 * The Utility service provide resources for useful information about the Crowdmap API
 */
public class UtilityService extends CrowdmapService {

    /**
     * Get status of the Crowdmap service.
     */
    public Response hearbeat() {
        setApiKey(METHOD_GET, SEGMENT_HEARTBEAT);
        return fromString(client.get(SEGMENT_HEARTBEAT), Response.class);
    }

    /**
     * Get the details of which version of the Crowdmap API you're accessing and some defaults
     * values like the range of acceptable limits for results, etc.
     *
     * @return Details about the Crowdmap API
     */
    public About about() {
        setApiKey(METHOD_GET, SEGMENT_ABOUT);
        return fromString(client.get(SEGMENT_ABOUT), About.class);
    }

    /**
     * Get an embed link
     *
     * @param url A Crowdmap encoded URL.
     * @return OEmbed details
     */
    public OEmbed oEmbed(String url) {
        client.setRequestParameters("url", url);
        return fromString(client.get(SEGMENT_OEMBED), OEmbed.class);
    }

    /**
     * Verify that a subdomain has been registered on Crowdmap or not.
     *
     * @param subdomain The name of the subdomain to check for
     * @return The registeration details.
     */
    public RegisteredMap registeredMap(String subdomain) {
        StringBuilder url = new StringBuilder(SEGMENT_REGISTEREDMAP);
        url.append(subdomain);
        url.append("/");
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), RegisteredMap.class);
    }

    public UtilityService limit(int limit) {
        if (limit > 0) {
            getClient().setRequestParameters(LIMIT, String.valueOf(limit));
        }
        return this;
    }

    public UtilityService offset(int offset) {

        if (getClient().getRequestParameters().containsKey(LIMIT)) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        getClient().setRequestParameters(OFFSET, String.valueOf(offset));
        return this;
    }
}
