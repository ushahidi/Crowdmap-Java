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

import com.crowdmap.java.sdk.json.Locations;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LOCATIONS;

/**
 * The location service. Locations are the points or geometries that are attached to posts.
 */
public class LocationService extends CrowdmapService {

    /**
     * Create a new external
     */
    public Locations createLocation() {
        //TODO:: ask for location fields.
        initSession();
        return fromString(client.post(SEGMENT_LOCATIONS),
                Locations.class);
    }

    /**
     * Get specific external
     */
    public Locations getLocation() {
        StringBuilder url = new StringBuilder(SEGMENT_LOCATIONS);
        setApiKey(METHOD_GET, SEGMENT_LOCATIONS);
        return fromString(client.get(SEGMENT_LOCATIONS),
                Locations.class);

    }
}
