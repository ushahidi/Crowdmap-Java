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
import com.crowdmap.java.sdk.json.Externals;

import retrofit.http.Field;
import retrofit.http.Query;

/**
 * Mock external service
 */
public class MockExternalService implements ExternalInterface {

    @Override
    public void getExternal(@Query("external_id") long externalId, @Query("limit") int limit,
            @Query("offset") int offset, ApiCallback<Externals> callback) {

    }

    @Override
    public void createExternal(@Field("service_id") long serviceId,
            @Field("id_on_service") String idOnService,
            @Field("session_token") @SessionToken String sessionToken,
            ApiCallback<Externals> callback) {

    }

    /*@Override
    public Externals getExternal(@Query("external_id") long externalId, @Query("limit") int limit,
            @Query("offset") int offset) {
        for (External external : mMockServerResponse.getExternals().getExternals()) {
            if (external.getUserId() == externalId) {
                return mMockServerResponse.getExternals();
            }
        }
        return null;
    }

    @Override
    public Externals createExternal(@Body External external, @Field("session") String session) {
        Externals externals = mMockServerResponse.getExternals();
        externals.setExternals(mMockServerResponse.addExternaList(external));
        return externals;
    }*/
}
