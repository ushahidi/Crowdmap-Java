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

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

/**
 * Api Test.
 */
public abstract class BaseTest extends TestCase {

    protected MockRestAdapter mMockRestAdapter;

    protected MockServerResponse mMockServerResponse;

    RestAdapter mRestAdapter;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoints.PRODUCTION.url)
                .build();

        mMockRestAdapter = MockRestAdapter.from(mRestAdapter);
        mMockServerResponse = new MockServerResponse();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        mMockRestAdapter = null;
        mRestAdapter = null;
        mMockServerResponse = null;
    }
}
