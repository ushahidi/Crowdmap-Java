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

import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.LoginForm;

/**
 * Test case for login service. 
 */
public class SessionServiceTest extends BaseServiceTest {

	SessionService loginService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		loginService = crowdmap.sessionService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		loginService = null;
	}

	/**
	 * Test method for
	 * {@link com.crowdmap.java.sdk.service.SessionService#login(LoginForm)}.
	 */
	@Test
	public void testLogin() throws Exception{

		// Provide correct credentials. Note: these ones are fake.
		final String username = "henry@ushahidi.com";
		final String password = "godles123";

        LoginForm form = new LoginForm(username,password);
		Session session = loginService.login(form);
		assertNotNull("Media cannot be null ", session);
        assertNull(session.error);

	}

    /**
     * Test that when provided with wrong credentials Session.error
     * won't be null
     * 
     * @throws Exception
     */
    @Test
    public void testWrongCredentialsLogin()throws Exception{
        // Provide correct credentials. Note: these ones are fake.
        final String username = "email@itdoesntexist.com";
        final String password = "ohgosh";

        LoginForm form = new LoginForm(username,password);
        Session session = loginService.login(form);
        assertNotNull("Media cannot be null ", session);
        assertNotNull(session.error);
    }

}
