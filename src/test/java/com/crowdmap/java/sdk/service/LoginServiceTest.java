/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 *****************************************************************************/
package com.crowdmap.java.sdk.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crowdmap.java.sdk.json.SessionJson;

/**
 * Test case for login service. 
 */
public class LoginServiceTest extends BaseServiceTest {

	LoginService loginService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		loginService = new LoginService(client);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		loginService = null;
	}

	/**
	 * Test method for
	 * {@link com.crowdmap.java.sdk.service.LoginService#loginService()}.
	 */
	@Test
	public void testLogin() {

		// Provide correct credentials. Note: these ones are fake.
		final String username = "demo@ushahidi.com";

		final String password = "demo";

		SessionJson sessionJson = loginService.login(username, password);
		assertNotNull("Media cannot be null ", sessionJson.getUserId());

	}

}
