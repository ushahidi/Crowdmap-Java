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

import java.util.List;

import com.crowdmap.java.sdk.model.Map;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

/**
 * Service for interacting with various maps setup on crowdmap
 */
public class MapService extends BaseService {

	/**
	 * Create map service
	 */
	public MapService() {
		super();
	}

	/**
	 * Create map service
	 * 
	 * @param client
	 */
	public MapService(CrowdmapHttpClient client) {
		super(client);
	}

	/**
	 * Get list of maps.
	 * 
	 * @return A list containing all the maps
	 */
	public List<Map> getMaps() {
		return getMaps(0, 20);
	}

	/**
	 * Get Maps based on restricted set
	 * 
	 * @param offset
	 *            The offset number
	 * @param limit
	 *            The limit number
	 * @return A list containing all the maps
	 */
	public List<Map> getMaps(int offset, int limit) {
		return null;
	}

	/**
	 * Returns a specific map
	 * 
	 * @return A specific map
	 */
	public Map getMap() {
		return null;
	}
	
	

}
