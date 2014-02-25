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

package com.crowdmap.java.sdk;

import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.model.External;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.ApiStatusDelegate;
import com.crowdmap.java.sdk.service.api.ErrorDelegate;
import com.crowdmap.java.sdk.service.api.ExternalInterface;
import com.crowdmap.java.sdk.service.api.MockExternalService;

import org.junit.Before;

import retrofit.RetrofitError;
import retrofit.client.Request;

/**
 * Test for External service.
 */
public class ExternalServiceTest extends  BaseTest implements ApiStatusDelegate, ErrorDelegate {

    ExternalInterface mExternalInterface;
    MockExternalService mMockExternalService;

    ApiCallback<Externals> mApiCallback;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mMockExternalService = new MockExternalService();
        mExternalInterface = mMockRestAdapter.create(ExternalInterface.class, mMockExternalService);
    }

    @Before
    public void testGetExternal() {
        mMockExternalService.getExternal(1, 1, 3, mApiCallback);
        mApiCallback = new ApiCallback<Externals>(this,this) {
            @Override
            public void success(Externals externals, retrofit.client.Response response) {
                assertEquals(200, response.getStatus());
                assertNotNull(externals);
                /*for (External external : externals.getExternals()) {
                    Ext
                    if (external.getUserId() == 1) {
                        return mMockServerResponse.getExternals();
                    }
                }*/
            }
        };

        //assertNotNull(externals);
        //assertTrue(externals.isSuccess());
        //assertEquals(200, externals.getStatus());
        //assertEquals(1, externals.getExternals().get(0).getUserId());
        //assertEquals(1, externals.getExternals().get(0).getServiceId());
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
