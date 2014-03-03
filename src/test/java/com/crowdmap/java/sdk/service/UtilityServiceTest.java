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

package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.BaseTest;
import com.crowdmap.java.sdk.Endpoints;
import com.crowdmap.java.sdk.MockHttpClient;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.ApiStatusDelegate;
import com.crowdmap.java.sdk.service.api.ErrorDelegate;
import com.crowdmap.java.sdk.service.api.MockUtilityService;
import com.crowdmap.java.sdk.service.api.UtilityInterface;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Test for Utility Service
 */
public class UtilityServiceTest extends BaseTest implements ApiStatusDelegate, ErrorDelegate {

    UtilityInterface utilityInterface;

    MockUtilityService mockUtilityService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        String response = "{\"success\":true,\"status\":200,\"timestamp\":1393829600,\"qcount\":3,\"elapsed\":\"0.3035s\"}";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoints.MOCK_MODE.url)
                .setClient(new MockHttpClient(response))
                .build();

        mockUtilityService = new MockUtilityService();

        utilityInterface = restAdapter.create(UtilityInterface.class);
    }

    @Test
    public void testHeartbeat() throws Exception {
        utilityInterface.heartbeat(new ApiCallback<Response>(this, this) {
            @Override
            public void success(Response response, retrofit.client.Response response2) {
                super.success(response, response2);
                assertEquals(200, response.getStatus());
                assertNotNull(response);
                assertEquals("0.1135s", response.getElapsed());
                System.out.println("Ouch!");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                super.failure(retrofitError);
                assertNull(retrofitError);
                System.out.println("Hey there");
            }
        });
        //System.out.println("Yo!");
    }

    @Test
    public void testAbout() throws Exception {
        /*About about = utilityInterface.about();
        assertNotNull(about);
        assertEquals(200, about.getStatus());
        assertEquals(1, about.getVersion());*/
    }

    @Test
    public void testOEmbed() throws Exception {
        /*OEmbed oEmbed = utilityInterface.oEmbed("https://crowdmap.com/post/3354821");
        assertNotNull(oEmbed);
        assertEquals("eyedol", oEmbed.getAuthorName());
        assertEquals(1.0f, oEmbed.getVersion());*/

    }

    @Test
    public void testRegisteredMap() throws Exception {
        /*RegisteredMap registeredMap = utilityInterface.registeredMap("eyedol");
        assertNotNull(registeredMap);
        assertTrue(registeredMap.isRegistered());*/
    }

    @Override
    public void onCallbackFinished() {

    }

    @Override
    public void noNetworkError(RetrofitError error) {

    }

    @Override
    public void notAuthorizedError(RetrofitError error, Response response) {

    }

    @Override
    public void invalidUrlError(RetrofitError error) {

    }

    @Override
    public void serverError(RetrofitError error) {

    }

    @Override
    public void generalError(RetrofitError error, Response response) {

    }
}
