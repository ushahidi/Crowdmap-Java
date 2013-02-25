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
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENTS;

import com.crowdmap.java.sdk.json.CommentsJson;
import com.crowdmap.java.sdk.json.MapsJson;
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

	/**
	 * Get all posts across crowdmap - GET /posts
	 * 
	 * @return
	 */
	public PostsJson getPosts() {

		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_POSTS);

		return fromString(client.sendGetRequest(url.toString()),
				PostsJson.class);
	}

	/**
	 * Get posts based on the post ID and a segment of the URL passed to it
	 * 
	 * @param id
	 *            The ID of the post
	 * 
	 * @param segement
	 *            The URL segment
	 * 
	 * @return The Object related to the JSON response
	 */
	private <T> T get(String id, String segment, Class<T> cls) {

		checkId(id);
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_POSTS);
		url.append("/");
		url.append(id);

		// Add the segment
		if (segment != null && segment.length() > 0) {
			url.append(segment);
		}

		return fromString(client.sendGetRequest(url.toString()), cls);
	}

	/**
	 * Get a specific post. GET /posts/:post_id
	 * 
	 * @param id
	 *            The post ID
	 * 
	 * @return The {@link com.crowdmap.java.sdk.json.PostsJson} response of the
	 *         specific post
	 */
	public PostsJson getPosts(String id) {

		return get(id, null, PostsJson.class);
	}

	/**
	 * Get all of the maps a specific post is featured on. GET
	 * /posts/:post_id/maps
	 * 
	 * @param id
	 *            The post ID
	 * 
	 * @return The {@link com.crowdmap.java.sdk.json.MapsJson} response for the
	 *         specific post
	 */
	public MapsJson getPostMaps(String id) {

		return get(id, SEGMENT_MAPS, MapsJson.class);
	}

	/**
	 * Gell all the comments associated with a specific post.
	 * 
	 * GET /posts/:post_id/comments/
	 * 
	 * @param id
	 *            The post ID
	 * 
	 * @return The {@link com.crowdmap.java.sdk.json.CommentsJson} response of
	 *         the specific post
	 */
	public CommentsJson getPostComments(String id) {
		return get(id, SEGMENT_COMMENTS, CommentsJson.class);
	}

	/**
	 * Get the comments on a post from the context of a map the post is featured
	 * on. GET /posts/:post_id/comments/:map_id
	 * 
	 * @param id
	 *            The Post ID
	 * 
	 * @param mapId
	 *            The map ID
	 * 
	 * @return The {@link com.crowdmap.java.sdk.json.CommentsJson} response of
	 *         the specific post
	 */
	public CommentsJson getPostComments(String id, String mapId) {
		checkId(id);
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_POSTS);
		url.append("/");
		url.append(id);
		url.append(SEGMENT_COMMENTS);
		url.append("/");
		url.append(mapId);

		return fromString(client.sendGetRequest(url.toString()),
				CommentsJson.class);
	}

}
