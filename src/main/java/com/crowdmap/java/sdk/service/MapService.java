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

import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Followers;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Owners;
import com.crowdmap.java.sdk.model.Map;
import com.crowdmap.java.sdk.net.content.Body;
import com.crowdmap.java.sdk.util.Util;

import java.util.List;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COLLABORATORS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_FOLLOWERS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MEDIA;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_OWNER;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;

/**
 * Service for interacting with various maps setup on crowdmap
 */
public class MapService extends CrowdmapService {

    /**
     * Create map service with default configured client
     */
    public MapService() {
    }

    /**
     * Get list of maps. GET /maps
     *
     * @return A list containing all the maps
     */
    public Maps getMaps() {
        //Crowdmap requires a new api signature every 2 minutes
        // so before a request is made, generate a new key
        //generate the api key
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        String response = client.get(SEGMENT_MAPS);
        Maps mapsJson = fromString(response, Maps.class);
        return mapsJson;
    }

    /**
     * Get Map based on a restricted set
     *
     * @param offset The offset number
     * @param limit  The limit number
     * @return A list containing all the maps
     */
    public List<Map> getMaps(int offset, int limit) {
        return null;
    }

    /**
     * Returns a specific map. GET /maps/:map_id
     *
     * @param id The ID of the map
     * @return A specific map
     */
    public Maps getMap(String id) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append("/");
        url.append(id);
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param id The ID of the map
     * @return The information about the owner of the map
     */
    public Owners getMapOwner(String id) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append("/");
        url.append(id);
        url.append(SEGMENT_OWNER);
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Owners.class);
    }

    /**
     * Get the followers of a map. GET /maps/:map_id/followers
     *
     * @param id The ID of the map
     * @return The followers of a map
     */
    public Followers getFollowers(String id) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append("/");
        url.append(id);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Followers.class);
    }

    /**
     * Get the collaborators on a map. GET /maps/:map_id/collaborators
     *
     * @param id The ID of the map
     * @return The followers of a map
     */
    public Collaborators getCollaborators(String id) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append("/");
        url.append(id);
        url.append(SEGMENT_COLLABORATORS);

        return fromString(client.get(url.toString()),
                Collaborators.class);
    }

    /**
     * Create a new Map. Anonymous users are not allowed to create maps. POST /maps
     *
     * @param userId    The login user's user ID
     * @param sessionId The login user's session ID.
     * @param subdomain The sudomain of the map
     * @return The newly created map
     */
    public Maps createMap(String userId, String sessionId, String subdomain) {

        // Validate all the required fields
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if (userId.length() == 0) {
            throw new IllegalArgumentException("user ID cannot be empty");
        }

        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null");
        }

        if (sessionId.length() == 0) {
            throw new IllegalArgumentException("Session ID cannot be empty ");
        }

        if (subdomain == null) {
            throw new IllegalArgumentException("Subdomain cannot be null");
        }

        if (subdomain.length() == 0) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }

        // Pass the username and password to the login endpoint
        final Body body = new Body();
        body.addField("user_id", userId);
        body.addField("session_id", sessionId);
        body.addField("subdomain", subdomain);

        return fromString(
                client.multipartPost(SEGMENT_MAPS, body),
                Maps.class);

    }
}
