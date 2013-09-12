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
import com.crowdmap.java.sdk.model.form.LocationForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.LIMIT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.OFFSET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LOCATIONS;

/**
 * The location service. Locations are the points or geometries that are attached to posts.
 */
public class LocationService extends CrowdmapService {

    /**
     * Create a new location.
     *
     * @param form The location to be added to Crowdmap
     * @return The list of locations including the newly created location.
     */
    public Locations createLocation(LocationForm form) {
        validateSession();
        return fromString(client.post(SEGMENT_LOCATIONS, form.getParameters()),
                Locations.class);
    }

    /**
     * Get locations.
     *
     * @return Get location.
     */
    public Locations getLocation() {

        setApiKey(METHOD_GET, SEGMENT_LOCATIONS);
        return fromString(client.get(SEGMENT_LOCATIONS),
                Locations.class);

    }

    public LocationService limit(int limit) {
        if (limit > 0) {
            getHttpClient().setRequestParameters(LIMIT, String.valueOf(limit));
        }
        return this;
    }

    public LocationService offset(int offset) {
        if (getHttpClient().getRequestParameters().containsKey(LIMIT)) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        getHttpClient().setRequestParameters(OFFSET, String.valueOf(offset));
        return this;
    }


    @Override
    public LocationService setSessionToken(String sessionToken) {
        if ((sessionToken == null) || (sessionToken.length() == 0)) {
            throw new IllegalArgumentException("Session token cannot be null or empty");
        }
        getHttpClient().setSessionToken(sessionToken);
        return this;
    }
}
