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
package com.crowdmap.java.sdk.resource;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_OWNER;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_FOLLOWERS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COLLABORATORS;

import java.util.List;

import com.crowdmap.java.sdk.json.CollaboratorsJson;
import com.crowdmap.java.sdk.json.FollowersJson;
import com.crowdmap.java.sdk.json.MapsJson;
import com.crowdmap.java.sdk.json.OwnerJson;
import com.crowdmap.java.sdk.model.Maps;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;
import com.crowdmap.java.sdk.net.content.Body;

/**
 * Service for interacting with various maps setup on crowdmap
 */
public class MapResource extends CrowdmapResource {

	/**
	 * Create map service with default configured client
	 */
	public MapResource() {
		super();
	}

	/**
	 * Create map service
	 * 
	 * @param client
	 */
	public MapResource(CrowdmapHttpClient client) {
		super(client);
	}

	/**
	 * Get list of maps. GET /maps
	 * 
	 * @return A list containing all the maps
	 */
	public MapsJson getMaps() {
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);
		String response = client.sendGetRequest(url.toString());
		MapsJson mapsJson = fromString(response, MapsJson.class);
		return mapsJson;
	}

	/**
	 * Get Maps based on a restricted set
	 * 
	 * @param offset
	 *            The offset number
	 * @param limit
	 *            The limit number
	 * @return A list containing all the maps
	 */
	public List<Maps> getMaps(int offset, int limit) {
		return null;
	}

	/**
	 * Returns a specific map. GET /maps/:map_id
	 * 
	 * @param String
	 *            id The ID of the map
	 * @return A specific map
	 */
	public MapsJson getMap(String id) {

		checkId(id);

		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);
		url.append("/");
		url.append(id);
		return fromString(client.sendGetRequest(url.toString()), MapsJson.class);
	}

	/**
	 * Get information about the owner of a particular map. GET
	 * /maps/:map_id/owner
	 * 
	 * @param String
	 *            id The ID of the map
	 * 
	 * @return The information about the owner of the map
	 */
	public OwnerJson getMapOwner(String id) {
		checkId(id);
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);
		url.append("/");
		url.append(id);
		url.append(SEGMENT_OWNER);

		return fromString(client.sendGetRequest(url.toString()),
				OwnerJson.class);
	}

	/**
	 * Get the followers of a map. GET /maps/:map_id/followers
	 * 
	 * @param String
	 *            id The ID of the map
	 * 
	 * @return The followers of a map
	 */
	public FollowersJson getFollowers(String id) {
		checkId(id);
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);
		url.append("/");
		url.append(id);
		url.append(SEGMENT_FOLLOWERS);

		return fromString(client.sendGetRequest(url.toString()),
				FollowersJson.class);
	}

	/**
	 * Get the collaborators on a map. GET /maps/:map_id/collaborators
	 * 
	 * @param String
	 *            id The ID of the map
	 * 
	 * @return The followers of a map
	 */
	public CollaboratorsJson getCollaborators(String id) {
		checkId(id);
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);
		url.append("/");
		url.append(id);
		url.append(SEGMENT_COLLABORATORS);

		return fromString(client.sendGetRequest(url.toString()),
				CollaboratorsJson.class);
	}

	/**
	 * Create a new Map. Anonymous users are not allowed to create maps. POST
	 * /maps
	 * 
	 * @param userId
	 *            The login user's user ID
	 * @param sessionId
	 *            The login user's session ID.
	 * @param subdomain
	 *            The sudomain of the map
	 * 
	 * @return The newly created map
	 */
	public MapsJson createMap(String userId, String sessionId, String subdomain) {

		// Validate all the required fields
		if (userId == null)
			throw new IllegalArgumentException("User ID cannot be null");

		if (userId.length() == 0)
			throw new IllegalArgumentException("user ID cannot be empty");

		if (sessionId == null)
			throw new IllegalArgumentException("Session ID cannot be null");

		if (sessionId.length() == 0)
			throw new IllegalArgumentException("Session ID cannot be empty ");

		if (subdomain == null)
			throw new IllegalArgumentException("Subdomain cannot be null");

		if (subdomain.length() == 0)
			throw new IllegalArgumentException("User ID cannot be empty");

		// Build the endpoints URLs
		StringBuilder url = new StringBuilder(apiUrl);
		url.append(SEGMENT_MAPS);

		// Pass the username and password to the login endpoint
		final Body body = new Body();
		body.addField("user_id", userId);
		body.addField("session_id", sessionId);
		body.addField("subdomain", subdomain);
		System.out.println("userid: " + userId + " sessionID: " + sessionId
				+ " subdomain: " + subdomain);
		return fromString(
				client.sendMultipartPostRequest(url.toString(), body),
				MapsJson.class);

	}
}
