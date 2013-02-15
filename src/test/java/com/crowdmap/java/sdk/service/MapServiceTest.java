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

import com.crowdmap.java.sdk.json.MapsJson;
import com.crowdmap.java.sdk.json.OwnerJson;
import com.crowdmap.java.sdk.model.Owner;

/**
 * 
 */
public class MapServiceTest extends BaseServiceTest {

	/** Maps Service */
	private MapService mapService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		mapService = new MapService(client);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		mapService = null;
	}

	/**
	 * Test method for fetching all public maps
	 * 
	 * {@link com.crowdmap.java.sdk.service.MapService }
	 */

	@Test
	public void testGetMaps() {
		MapsJson maps = mapService.getMaps();
		assertNotNull("Maps cannot be null ", maps);
	}
	
	@Test
	public void testGetMap() {
		MapsJson maps = mapService.getMap(String.valueOf(1));
		assertNotNull("Maps cannot be null ", maps);
	}
	
	public void testgetMapOwner() {
		OwnerJson ownerJson = mapService.getMapOwner(String.valueOf(1));
		assertNotNull("Maps cannot be null ", ownerJson);
	}

}
