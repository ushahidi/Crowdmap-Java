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
import com.crowdmap.java.sdk.json.Locations;
import com.crowdmap.java.sdk.model.form.LocationForm;
import com.crowdmap.java.sdk.service.provider.LocationInterface;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.LIMIT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.OFFSET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LOCATIONS;

/**
 * The location service. Locations are the points or geometries that are attached to posts.
 */
public class LocationService extends CrowdmapService<LocationService> {

    private LocationInterface mLocationInterface;

    public LocationService(LocationInterface locationInterface) {
        mLocationInterface = locationInterface;
    }

    /**
     * Create a new location.
     *
     * @param form The location to be added to Crowdmap
     * @return The list of locations including the newly created location.
     */
    public Locations createLocation(LocationForm form) {
        //validateSession();
        return null;
    }

    /**
     * Get locations.
     *
     * @return Get location.
     */
    public Locations getLocation() {
        return null;
    }
}
