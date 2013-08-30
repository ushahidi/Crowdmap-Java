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

import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Followers;
import com.crowdmap.java.sdk.json.MapSettings;
import com.crowdmap.java.sdk.json.MapTags;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Owners;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.model.Map;
import com.crowdmap.java.sdk.model.MapForm;
import com.crowdmap.java.sdk.net.content.Body;
import com.crowdmap.java.sdk.net.content.FileBody;

import java.io.File;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_AVATAR;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_BANNER;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COLLABORATORS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_FOLLOWERS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_OWNER;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_SETTINGS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_TAGS;

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
     * Get list of maps as anonymous user
     *
     * @return Maps as
     */
    public Maps getMaps() {
        //Crowdmap requires a new api signature every 2 minutes
        // so before a request is made, generate a new key
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(SEGMENT_MAPS), Maps.class);
    }


    /**
     * Get Map as an authenticated user.
     *
     * This requires that you set a session token by loging in.
     *
     * @return A list containing all the maps as an authenticated user
     */
    public Maps getMapsAsAuthenicatedUser() {
        // Set session token
        initSession();
        return fromString(client.get(SEGMENT_MAPS), Maps.class);
    }

    /**
     * Returns a specific map. GET /maps/:map_id
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public Maps getMap(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append("/");
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * Returns a specific map. GET /maps/:map_id
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public Maps getMapAsAuthenicatedUser(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append("/");
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()), Maps.class);
    }

    // Users associations with maps

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param id The ID of the map
     * @return The information about the owner of the map
     */
    public Owners getMapOwner(long id) {
        checkId(id);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(id);
        url.append(SEGMENT_OWNER);
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Owners.class);
    }

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public Owners updateOwner(long mapId) {
        checkId(mapId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_OWNER);
        setApiKey(METHOD_PUT, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Owners.class);
    }


    /**
     * Get the collaborators on a map. GET /maps/:map_id/collaborators
     *
     * @param mapId The ID of the map
     * @return The followers of a map
     */
    public Collaborators getCollaborators(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);

        return fromString(client.get(url.toString()),
                Collaborators.class);
    }

    /**
     * Add a collaborator to the a map
     */
    public Collaborators addCollaborators(long mapId) {
        //TODO:: ask Brian about collaborators fields
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);
        return fromString(client.post(url.toString()),
                Collaborators.class);
    }

    /**
     * Remove a collaborator from the map
     */
    public Collaborators removeCollaborator(long mapId, long collaboratorId) {
        //TODO:: ask Brian what response is returned when a collaborator is deleted
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);
        url.append(collaboratorId);
        url.append("/");
        return fromString(client.post(url.toString()),
                Collaborators.class);
    }

    /**
     * Get the followers of a map. GET /maps/:map_id/followers
     *
     * @param mapId The ID of the map
     * @return The followers of a map
     */
    public Followers getFollowers(long mapId) {
        checkId(mapId);
        //TODO:: confirm with Brian if this requires authentication
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_GET, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Followers.class);
    }

    public Followers followMap(long mapId) {
        //TODO:: ask brian what fields are pass for following a map
        checkId(mapId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_POST, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Followers.class);
    }

    /**
     * Stop following a particular map
     *
     * @param mapId The ID of the map to stop following
     */
    public Followers stopFollowingMap(long mapId) {
        //TODO:: ask Brian what response is returned when stopped to follow a map
        checkId(mapId);
        initSession();
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_DELETE, SEGMENT_MAPS);
        return fromString(client.get(url.toString()),
                Followers.class);
    }

    // Tagging Maps
    public MapTags getTags(String tag) {
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(tag);
        url.append(SEGMENT_TAGS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), MapTags.class);
    }


    /**
     * Get a specific map's tag
     */
    public MapTags getTags(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(tag);
        url.append(SEGMENT_TAGS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), MapTags.class);

    }

    public MapTags addTag(long mapId) {
        //TODO:: get tags of a map
        return null;
    }

    public MapTags deleteTag(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(tag);
        url.append(SEGMENT_TAGS);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()), MapTags.class);
    }

    //post on a map
    public Posts getPostOnMap(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        setApiKey(METHOD_GET, url.toString());
        String json = client.get(url.toString());
        return fromString(json, Posts.class);
    }

    //post on a map
    public Posts getPostOnMapByTag(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(tag);
        url.append("/");
        setApiKey(METHOD_GET, url.toString());
        String json = client.get(url.toString());
        return fromString(json, Posts.class);
    }

    public Posts approveOrDenyPostOnMap(long mapId, long postId) {
        //Double check the fields involve
        checkId(mapId);
        checkId(postId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.put(url.toString(), null), Posts.class);
    }

    public Posts removePostFromMap(long mapId, long postId) {
        checkId(mapId);
        checkId(postId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.put(url.toString(), null), Posts.class);
    }

    /**
     * Create a new Map.
     *
     * <p><strong>Note:</strong> Requires authentication</p>
     *
     * @param form The MapForm holding the map field values
     * @return The newly created map
     */
    public Maps createMap(MapForm form) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);

        Maps maps = fromString(
                client.multipartPost(url.toString(), form.getParameters()),
                Maps.class);

        // Check if upload banner is set, then upload the files
        if (form.getUploadBanner() != null) {
            for (Map map : maps.getMaps()) {
                createBanner(map.getId(), form.getUploadBanner());
            }
        }

        // Check if upload avatar is set, then upload the files
        if (form.getUploadAvatar() != null) {
            for (Map map : maps.getMaps()) {
                createAvatar(map.getId(), form.getUploadAvatar());
            }
        }

        return maps;
    }

    /**
     * Create a new banner
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param banner The image file
     */
    public Maps createBanner(long mapId, File banner) {
        return uploadImage(mapId, banner, SEGMENT_BANNER);
    }

    /**
     * Create an avatar for an existing map.
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param avatar The image file
     * @return The updated map
     */
    public Maps createAvatar(long mapId, File avatar) {
        return uploadImage(mapId, avatar, SEGMENT_AVATAR);
    }

    /**
     * Update an exisiting map.
     *
     * @param mapId The ID of the map to be updated.
     * @param form  The fields to be updated.
     * @return The updated map.
     */
    public Maps updateMap(long mapId, MapForm form) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);

        // if a mapId is set
        url.append(mapId);
        url.append("/");

        Maps maps = fromString(
                client.put(url.toString(), form.getParameters()),
                Maps.class);

        // Check if upload banner is set, then upload the files
        if (form.getUploadBanner() != null) {
            for (Map map : maps.getMaps()) {
                createBanner(map.getId(), form.getUploadBanner());
            }
        }

        // Check if upload avatar is set, then upload the files
        if (form.getUploadAvatar() != null) {
            for (Map map : maps.getMaps()) {
                createAvatar(map.getId(), form.getUploadAvatar());
            }
        }

        return maps;

    }

    /**
     * Delete an existing map
     */
    public Maps deleteMap(long mapId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        // if a mapId is set
        url.append(mapId);
        url.append("/");
        return fromString(client.delete(url.toString()), Maps.class);
    }

    /**
     * Get map settings.
     *
     * @param mapId        The map to get it's settings.
     * @param settingsName The map settings name.
     * @return The map settings
     */
    public MapSettings getMapSettings(long mapId, String settingsName) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        // if a mapId is set
        checkId(mapId);
        url.append(mapId);
        url.append(SEGMENT_SETTINGS);
        url.append(settingsName);
        url.append("/");
        setApiKey(METHOD_GET, url.toString());
        return fromString(
                client.get(url.toString()),
                MapSettings.class);
    }

    /**
     * Get map settings.
     *
     * @param mapId        The map to get it's settings.
     * @param settingsName The map settings name.
     * @return The map settings
     */
    public MapSettings createOrUpdateMapSettings(long mapId, String settingsName,
            String settingsValue) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        // if a mapId is set
        checkId(mapId);
        url.append(mapId);
        url.append(SEGMENT_SETTINGS);
        url.append(settingsName);
        url.append("/");
        Body body = new Body();
        body.addField("settings", settingsName);
        body.addField("value", settingsValue);
        setApiKey(METHOD_POST, url.toString());
        return fromString(
                client.get(url.toString()),
                MapSettings.class);
    }

    public MapSettings deleteMapSettings(long mapId, String settingsName) {
        checkId(mapId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_SETTINGS);
        url.append(settingsName);
        url.append("/");
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(
                client.get(url.toString()),
                MapSettings.class);
    }

    /**
     * Upload image to the specified endpoint.
     *
     * @param mapId The ID of the map to attach the image to be uploaded to.
     * @param image The image file.
     * @param uri   The endpoint uri segement
     * @return The updated map.
     */
    private Maps uploadImage(long mapId, File image, String uri) {
        initSession();
        FileBody fileBody = new FileBody(image);
        Body body = new Body();
        body.addField("file", fileBody);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(uri);

        return fromString(
                client.multipartPost(url.toString(), body),
                Maps.class);
    }
}
