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

import com.crowdmap.java.sdk.MockServerResponse;
import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;

import java.util.Collections;

import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedByteArray;

/**
 * Mock Utility service
 */
public class MockUtilityService implements UtilityInterface {

    MockServerResponse mMockServerResponse;

    public MockUtilityService(MockServerResponse mMockServerResponse) {
        this.mMockServerResponse  = mMockServerResponse;
    }
    @Override
    public Response heartbeat() {
        return mMockServerResponse.getResponse();
    }

    @Override
    public About about() {
        return mMockServerResponse.getAbout();
    }

    @Override
    public OEmbed oEmbed(@Query("url") String url) {
        return mMockServerResponse.getOEmbed();
    }

    @Override
    public RegisteredMap registeredMap(@Path("domain") String domain) {
        return mMockServerResponse.getRegisteredMap();
    }
}
