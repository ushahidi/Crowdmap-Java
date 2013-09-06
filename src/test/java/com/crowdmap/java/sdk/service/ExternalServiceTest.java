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

import com.crowdmap.java.sdk.json.Externals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the external service.
 */
public class ExternalServiceTest extends BaseServiceTest {

    ExternalService mExternalService;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        mExternalService = crowdmap.externalService();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testCreateExternal() throws Exception {
        Externals externals = mExternalService.getExternal(30);
        assertNotNull(externals);
    }

}
