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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.form.LoginForm;

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
        LoginForm form = new LoginForm(username,password);
		Session session = loginService.login(form);
		assertNotNull("Media cannot be null ", session);
        assertNull(session.getError());

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
        assertNotNull(session.getError());
    }

}
