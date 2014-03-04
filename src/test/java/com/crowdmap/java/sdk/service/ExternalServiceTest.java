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
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.ApiStatusDelegate;
import com.crowdmap.java.sdk.service.api.ErrorDelegate;
import com.crowdmap.java.sdk.service.api.ExternalInterface;
import com.crowdmap.java.sdk.service.api.MockExternalService;

import org.junit.Before;
import org.junit.Test;

import retrofit.RetrofitError;

/**
 * Test for External service.
 */
public class ExternalServiceTest extends BaseTest{

    ExternalInterface mExternalInterface;

    MockExternalService mMockExternalService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mMockExternalService = new MockExternalService(mMockServerResponse);
        mExternalInterface = mMockRestAdapter.create(ExternalInterface.class, mMockExternalService);
    }

    @Test
    public void testGetExternal() {
        Externals externals = mExternalInterface.getExternal(1, 1, 0);
        assertNotNull(externals);
        assertTrue(externals.isSuccess());
        assertEquals(200, externals.getStatus());
        assertEquals(1, externals.getExternals().get(0).getId());
        assertEquals(1, externals.getExternals().get(0).getServiceId());
    }

    @Test
    public void testCreateExternal() {
        Externals externals = mExternalInterface.createExternal(1,"0303ld", "test");
        int lastItem = externals.getExternals().size() - 1;
        assertNotNull(externals);
        assertTrue(externals.isSuccess());
        assertEquals(200, externals.getStatus());
        assertEquals(1, externals.getExternals().get(lastItem).getId());
        assertEquals(1, externals.getExternals().get(lastItem).getServiceId());
        assertEquals("0303ld", externals.getExternals().get(lastItem).getIdOnService());
    }
}
