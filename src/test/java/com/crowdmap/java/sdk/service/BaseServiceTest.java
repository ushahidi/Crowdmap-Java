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

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import org.mockito.MockitoAnnotations;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.form.LoginForm;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

/**
 * The base class for testing all the task supported by the Ushahidi API
 * 
 * @author eyedol
 * 
 */
public abstract class BaseServiceTest extends TestCase {

	protected Crowdmap crowdmap;

    protected LoginForm loginForm;

    protected SessionService loginService;

    protected Session session;

    private CrowdmapHttpClient httpClient;

    protected String username;
    protected String password;

	@Before
	public void setUp() throws Exception {
		super.setUp();
        httpClient = new CrowdmapHttpClient();
		crowdmap = new Crowdmap("mcoSiLOiRUXiiAPv","jodJljijJNiBSLLW");

        username = "henry@ushahidi.com";
        password = "dontchangeme";

        loginForm = new LoginForm(username,password);
        loginService = crowdmap.sessionService();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		// null the factory object
		crowdmap = null;
        loginForm = null;
        loginService = null;
        session = null;
	}

	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}

	/**
	 * Assert not null or empty.
	 * 
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 */
	protected static void assertNotNullOrEmpty(String message,
			Collection<?> value) {
		assertNotNull(message, value);
		assertFalse(message, value.isEmpty());
	}

	protected static void assetNotNullOrZero(String message, int value) {
		assertNotNull(message, value);
		assertEquals(message, 0, value);
	}
}
