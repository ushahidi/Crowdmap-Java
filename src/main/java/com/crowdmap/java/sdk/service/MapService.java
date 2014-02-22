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
import com.crowdmap.java.sdk.json.Owner;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.model.form.MapForm;
import com.crowdmap.java.sdk.model.form.TagForm;
import com.crowdmap.java.sdk.net.content.Body;

import java.io.File;

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
public class MapService extends CrowdmapService<MapService> {

    /**
     * Get list of maps as anonymous user
     *
     * @return Maps as
     */
    public Maps getMaps() {
        return null;
    }


    /**
     * Get Map as an authenticated user.
     *
     * <strong>Note:</strong> This requires session token to be set. See {@link
     * #setSessionToken(String)}
     *
     * @return A list containing all the maps as an authenticated user
     */
    public Maps getMapsAsAuthenicatedUser() {
        // Set session token
        //validateSession();
        return null;
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
        return null;
    }

    /**
     * <p>Returns a specific map.</p>
     *
     * <strong>Note:</strong> This requires session token to be set. See {@link
     * #setSessionToken(String)}
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public Maps getMapAsAuthenicatedUser(long mapId) {
        checkId(mapId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append("/");
        return null;
    }

    // Users associations with maps

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param id The ID of the map
     * @return The information about the owner of the map
     */
    public Owner getMapOwner(long id) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(id);
        url.append(SEGMENT_OWNER);
        return null;
    }

    /**
     * Change the owner of a map.
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public Owner updateOwner(long mapId, long userId) {
        checkId(mapId);
        checkId(userId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_OWNER);
        Body body = new Body();
        body.addField("user_id", userId);
        return null;
    }


    /**
     * Get the collaborators on a map. GET /maps/:map_id/collaborators
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public Collaborators getCollaborators(long mapId) {
        checkId(mapId);

        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);
        //setApiKey(METHOD_GET, url.toString());
        //final String json = client.get(url.toString());
        //return fromString(json, Collaborators.class);
        return null;
    }

    /**
     * Add a collaborator to the a map.
     *
     * @param mapId  The ID of the map. This should be a map the logged in user owns.
     * @param userId The ID of the user.
     * @return The  Collaborators.
     */
    public Collaborators addCollaborator(long mapId, long userId) {
        checkId(mapId);
        checkId(userId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);
        Body body = new Body();
        body.addField("collaborator_id", userId);
        //return fromString(client.post(url.toString(), body),
          //      Collaborators.class);
        return null;
    }

    /**
     * Remove a collaborator from the map
     *
     * @param mapId  The ID of the map.
     * @param userId The ID of the user.
     * @return The collaborators on the map.
     */
    public Collaborators removeCollaborator(long mapId, long userId) {
        checkId(mapId);
        checkId(userId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_COLLABORATORS);
        url.append(userId);
        url.append("/");
        return null;
    }

    /**
     * Get the followers of a map. GET /maps/:map_id/followers
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public Followers getFollowers(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);

        return null;
    }

    /**
     * Follower a map.
     *
     * @param mapId  The ID of the map.
     * @param userId The user ID.
     * @return The maps.
     */
    public Followers followMap(long mapId, long userId) {
        checkId(mapId);
        checkId(userId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);
        //setApiKey(METHOD_POST, url.toString());
        Body body = new Body();
        body.addField("user_id", userId);
        return null;
    }

    /**
     * Stop following a particular map.
     *
     * @param mapId The ID of the map to stop following.
     * @return The followers of the map.
     */
    public Followers stopFollowingMap(long mapId) {
        checkId(mapId);
        //validateSession();
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_FOLLOWERS);
        //setApiKey(METHOD_DELETE, url.toString());
       return null;
    }

    // Tagging Maps

    /**
     * Get tags attached to a map.
     *
     * @param tag The tag to add to the map.
     * @return The tags.
     */
    public MapTags getTags(String tag) {
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(tag);
        url.append(SEGMENT_TAGS);
        return null;
    }

    /**
     * Get a specific map by tag
     */
    /**
     * Get tags of a particular map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to retrieve the map by.
     * @return The tags
     */
    public MapTags getTags(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(tag);
        url.append(SEGMENT_TAGS);
        return null;
    }

    /**
     * Add a new tag to the map.
     *
     * @param mapId The ID of the map.
     * @param form  The TagForm which holds the fields of the tag.
     * @return The tags.
     */
    public MapTags addTag(long mapId, TagForm form) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_TAGS);
        return null;
    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to delete from the map.
     * @return The tags.
     */
    public MapTags deleteTag(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_TAGS);
        url.append(tag);
        url.append("/");
        return null;
    }

    //post on a map

    /**
     * Get a post on a map.
     *
     * @param mapId The ID of the map.
     * @return The Posts
     */
    public Posts getPostOnMap(long mapId) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        return null;
    }

    /**
     * Post a tag on a map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to post on the map.
     * @return The posts
     */
    public Posts getPostOnMapByTag(long mapId, String tag) {
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(tag);
        url.append("/");
        return null;
    }

    /**
     * Approve or deny a post on map.
     *
     * @param mapId  The ID of the map to approve or deny the post.
     * @param postId The post post to approve or deny.
     * @return The posts
     */
    public Posts approveOrDenyPostOnMap(long mapId, long postId) {
        //Double check the fields involve
        checkId(mapId);
        checkId(postId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        return null;
    }

    public Posts removePostFromMap(long mapId, long postId) {
        checkId(mapId);
        checkId(postId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        return null;
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
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);

       /* Maps maps = fromString(
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

        return maps;*/
        return null;
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
        // validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);

        // if a mapId is set
        url.append(mapId);
        url.append("/");

        /*Maps maps = fromString(
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

        return maps;*/
        return null;

    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map
     * @return The list of maps minus the deleted map
     */
    public Maps deleteMap(long mapId) {
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append("/");
        return null;
    }

    /**
     * Get map settings.
     *
     * @param mapId        The map to get it's settings.
     * @param settingsName The map settings name.
     * @return The map settings
     */
    public MapSettings getMapSettings(long mapId, String settingsName) {
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        // if a mapId is set
        checkId(mapId);
        url.append(mapId);
        url.append(SEGMENT_SETTINGS);
        url.append(settingsName);
        url.append("/");
        return null;
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
        //validateSession();
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
        return null;
    }

    /**
     * Delete map settings.
     *
     * @param mapId        The ID of the map to delete it's settings.
     * @param settingsName The name of the settings to delete.
     * @return The map settings
     */
    public MapSettings deleteMapSettings(long mapId, String settingsName) {
        checkId(mapId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(SEGMENT_SETTINGS);
        url.append(settingsName);
        url.append("/");
        return null;
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
        //validateSession();
        Body body = new Body();
        body.addField("file", image);
        StringBuilder url = new StringBuilder(SEGMENT_MAPS);
        url.append(mapId);
        url.append(uri);

        return null;
    }
}
