/*******************************************************************************
 * Copyright (c) 2010 - 2014 Ushahidi Inc.
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

package com.crowdmap.java.sdk.service.api;

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Locations;
import com.crowdmap.java.sdk.model.Location;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LOCATIONS;

/**
 * Location interface
 */
public interface LocationInterface {

    @GET(SEGMENT_LOCATIONS)
    void getLocation(ApiCallback<Locations> callback);

    @GET(SEGMENT_LOCATIONS + "{external_id}/")
    void getLocation(@Path("external_id") long externalId, ApiCallback<Locations> callback);

    @FormUrlEncoded
    @POST(SEGMENT_LOCATIONS)
    void createLocation(@Field("fsq_venue_id") String fsVenueId, @Field("geometry") String geometry,
            @Field("name") String name, @Field("region") String region,
            @Field("session_token") @SessionToken String sessionToken,
            ApiCallback<Locations> callback);
}
