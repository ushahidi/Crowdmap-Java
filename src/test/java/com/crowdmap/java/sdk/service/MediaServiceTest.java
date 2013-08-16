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

import com.crowdmap.java.sdk.json.MediaJson;
import com.crowdmap.java.sdk.resource.MediaResource;

/**
 * 
 */
public class MediaServiceTest extends BaseServiceTest {

	private MediaResource mediaService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		mediaService = new MediaResource(client);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		mediaService = null;
	}

	/**
	 * Test method for
	 * {@link com.crowdmap.java.sdk.resource.MediaResource#getMedia()}.
	 */
	@Test
	public void testGetMedia() {
		MediaJson mediaJson = mediaService.getMedia();

		assertNotNull("Media cannot be null ", mediaJson);

	}

	/**
	 * Test method for
	 * {@link com.crowdmap.java.sdk.resource.MediaResource#getMedia(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetMediaString() {
		MediaJson mediaJson = mediaService.getMedia(String.valueOf(43));
		assertNotNull("Media cannot be null ", mediaJson);
	}

}
