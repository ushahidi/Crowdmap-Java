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

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Locations;
import com.crowdmap.java.sdk.model.Geometry;
import com.crowdmap.java.sdk.service.api.LocationInterface;

import retrofit.RestAdapter;

/**
 * The location service. Locations are the points or geometries that are attached to posts.
 */
public class LocationService extends CrowdmapService<LocationService> {

    private LocationInterface mLocationInterface;

    public LocationService(RestAdapter restAdapter) {
        super(restAdapter);
        mLocationInterface = restAdapter.create(LocationInterface.class);
    }

    /**
     * Create a new location.
     *
     * @param fsVenueId The location to be added to Crowdmap
     * @return The list of locations including the newly created location.
     */
    public Locations createLocation(String fsVenueId, Geometry geometry, String name, String region,
            @SessionToken String sessionToken) {
        return mLocationInterface
                .createLocation(fsVenueId, geometry.toString(), name, region, sessionToken);
    }

    /**
     * Get locations.
     *
     * @return Get location.
     */
    public Locations getLocation() {
        return mLocationInterface.getLocation();
    }

    public Locations getLocation(long locationId) {
        checkId(locationId);
        return mLocationInterface.getLocation(locationId);
    }
}
