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

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;

import com.crowdmap.java.sdk.json.PostsJson;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

/**
 * Service for interacting with crowdmap's Posts API
 */
public class PostsService extends BaseService {

	public PostsService() {
		super();
	}

	/**
	 * Create Posts service with the default crowdmap http client
	 * 
	 * @param client
	 */
	public PostsService(CrowdmapHttpClient client) {
		super(client);
	}

	public PostsJson getPosts() {

		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_POSTS);

		return fromString(client.sendGetRequest(url.toString()),
				PostsJson.class);
	}
	
}
