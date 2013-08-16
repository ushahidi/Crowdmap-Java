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

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.crowdmap.java.sdk.Crowdmap;

/**
 * The base class for testing all the task supported by the Ushahidi API
 * 
 * @author eyedol
 * 
 */
public abstract class BaseServiceTest extends TestCase {

	protected Crowdmap crowdmap;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		crowdmap = new Crowdmap();
        crowdmap.setApiKey("AmcoSiLOiRUXiiAPv6905911ab69fa32e68f4f5dbf62098148ea26ddb");

	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		// null the factory object
		crowdmap = null;
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
