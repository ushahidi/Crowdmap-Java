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
import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.MockUtilityService;
import com.crowdmap.java.sdk.service.api.UtilityInterface;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for Utility Service
 */
public class UtilityServiceTest extends BaseTest {

    UtilityInterface utilityInterface;

    MockUtilityService mockUtilityService;

    @Before
    public void setUp() throws Exception {
        super.setUp();

        mockUtilityService = new MockUtilityService(mMockServerResponse);

        utilityInterface = mMockRestAdapter.create(UtilityInterface.class, mockUtilityService);
    }

    @Test
    public void testHeartbeat() throws Exception {
        Response response = utilityInterface.heartbeat();
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testAbout() throws Exception {
        About about = utilityInterface.about();
        assertNotNull(about);
        assertEquals(200, about.getStatus());
        assertEquals(1, about.getVersion());
    }

    @Test
    public void testOEmbed() throws Exception {
        OEmbed oEmbed = utilityInterface.oEmbed("https://crowdmap.com/post/3354821");
        assertNotNull(oEmbed);
        assertEquals("eyedol", oEmbed.getAuthorName());
        assertEquals(1.0f, oEmbed.getVersion());

    }

    @Test
    public void testRegisteredMap() throws Exception {
        RegisteredMap registeredMap = utilityInterface.registeredMap("eyedol");
        assertNotNull(registeredMap);
        assertTrue(registeredMap.isRegistered());
    }
}
