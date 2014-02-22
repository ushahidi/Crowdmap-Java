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

import com.crowdmap.java.sdk.CrowdmapApiKeys;
import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.provider.UtilityInterface;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_REGISTEREDMAP;

/**
 * The Utility service provide resources for useful information about the Crowdmap API
 */
public class UtilityService extends CrowdmapService<UtilityService> {

    private final UtilityInterface utility;

    public UtilityService(UtilityInterface utility) {
        this.utility = utility;
    }

    /**
     * Get status of the Crowdmap service.
     */
    public Response heartbeat() {
        return utility.heartbeat(limit, offset);

    }


    /**
     * Get the details of which version of the Crowdmap API you're accessing and some defaults
     * values like the range of acceptable limits for results, etc.
     *
     * @return Details about the Crowdmap API
     */
    public About about() {
        return utility.about(limit, offset);
    }

    /**
     * Get an embed link
     *
     * @param url A Crowdmap encoded URL.
     * @return OEmbed details
     */
    public OEmbed oEmbed(String url) {
        return utility.oEmbed(url, limit, offset);
    }

    /**
     * Verify that a subdomain has been registered on Crowdmap or not.
     *
     * @param subdomain The name of the subdomain to check for
     * @return The registeration details.
     */
    public RegisteredMap registeredMap(String subdomain) {
        return utility.registeredMap(subdomain);
    }

}
