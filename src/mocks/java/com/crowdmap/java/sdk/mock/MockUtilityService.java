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

package com.crowdmap.java.sdk.mock;

import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.provider.UtilityInterface;

import retrofit.MockRestAdapter;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Mock Utility service
 */
public class MockUtilityService implements UtilityInterface{

    public MockUtilityService() {
        initData();
    }

    private void initData() {

    }

    @Override
    public Response heartbeat() {
        // Seed mock response.
        final Response mResponse = new Response();
        mResponse.setSuccess(true);
        mResponse.setStatus(200);
        mResponse.setTimestamp(new Date(1375336170));
        mResponse.setQcount(2);
        mResponse.setElapsed("0.1135s");
        return mResponse;
    }

    @Override
    public About about() {
        // Seed mock about
        About about = new About();
        about.setEnvironment("Demo");
        about.setVersion(1);
        about.setLimitMax(1000);
        about.setLimitMin(0);
        about.setStatus(200);
        about.setTimestamp(new Date(1375336265));
        about.setQcount(2);
        return about;
    }

    @Override
    public OEmbed oEmbed(@Query("url") String url) {
        return null;
    }

    @Override
    public RegisteredMap registeredMap(@Path("domain") String domain) {
        return null;
    }
}
