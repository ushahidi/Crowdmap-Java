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

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Followers;
import com.crowdmap.java.sdk.json.MapSettings;
import com.crowdmap.java.sdk.json.MapTags;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Owner;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.MapInterface;

import retrofit.RestAdapter;
import retrofit.mime.TypedFile;

/**
 * Service for interacting with various maps setup on crowdmap
 */
public class MapService extends CrowdmapService<MapService> {

    MapInterface mMapInterface;

    public MapService(RestAdapter restAdapter) {
        super(restAdapter);
        mMapInterface = restAdapter.create(MapInterface.class);
    }

    /**
     * Get list of maps as anonymous user
     *
     * @return Maps as
     */
    public Maps getMaps(ApiCallback<Maps> callback) {
        return mMapInterface.getMaps();
    }


    /**
     * Get Map as an authenticated user.
     *
     * @return A list containing all the maps as an authenticated user
     */
    public Maps getMaps(@SessionToken String sessionToken) {
        return mMapInterface.getMaps(sessionToken);
    }

    /**
     * Returns a specific map. GET /maps/:map_id
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public Maps getMaps(long mapId) {
        checkId(mapId);
        return mMapInterface.getMaps(mapId);
    }

    /**
     * <p>Returns a specific map.</p>
     *
     * <strong>Note:</strong> This requires session token to be set.
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public Maps getMaps(long mapId, String sessionToken) {
        checkId(mapId);
        return mMapInterface.getMaps(mapId, sessionToken);
    }

    // Users associations with maps

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public Owner getMapOwner(long mapId) {
        checkId(mapId);
        return mMapInterface.getMapOwner(mapId);
    }

    /**
     * Change the owner of a map.
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public Owner updateOwner(long mapId, long userId, String sessionToken) {
        checkId(mapId);
        checkId(userId);
        return mMapInterface.updateOwner(mapId, userId, sessionToken);
    }


    /**
     * Get the collaborators on a map. GET /maps/:map_id/collaborators
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public Collaborators getCollaborators(long mapId) {
        checkId(mapId);
        return mMapInterface.getCollaborators(mapId);
    }

    /**
     * Add a collaborator to the a map.
     *
     * @param mapId  The ID of the map. This should be a map the logged in user owns.
     * @param userId The ID of the user.
     * @return The  Collaborators.
     */
    public Collaborators addCollaborator(long mapId, long userId, String sessionToken) {
        checkId(mapId);
        checkId(userId);
        return mMapInterface.addCollaborator(mapId, userId, sessionToken);
    }

    /**
     * Remove a collaborator from the map
     *
     * @param mapId  The ID of the map.
     * @param userId The ID of the user.
     * @return The collaborators on the map.
     */
    public Collaborators removeCollaborator(long mapId, long userId, String sessionToken) {
        checkId(mapId);
        checkId(userId);
        return mMapInterface.removeCollaborator(mapId, userId, sessionToken);
    }

    /**
     * Get the followers of a map. GET /maps/:map_id/followers
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public Followers getFollowers(long mapId) {
        checkId(mapId);
        return mMapInterface.getFollowers(mapId);
    }

    /**
     * Follower a map.
     *
     * @param mapId  The ID of the map.
     * @param userId The user ID.
     * @return The maps.
     */
    public Followers followMap(long mapId, long userId, String sessionToken) {
        checkId(mapId);
        checkId(userId);
        return mMapInterface.followMap(mapId, userId, sessionToken);
    }

    /**
     * Stop following a particular map.
     *
     * @param mapId The ID of the map to stop following.
     * @return The followers of the map.
     */
    public Followers stopFollowingMap(long mapId, String sessionToken) {
        checkId(mapId);
        return mMapInterface.stopFollowingMap(mapId, sessionToken);
    }

    // Tagging Maps

    /**
     * Get tags attached to a map.
     *
     * @param tag The tag to add to the map.
     * @return The tags.
     */
    public MapTags getTags(String tag) {
        return mMapInterface.getTags(tag);
    }

    /**
     * Get tags of a particular map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to retrieve the map by.
     * @return The tags
     */
    public MapTags getTags(long mapId, String tag) {
        checkId(mapId);
        return mMapInterface.getTags(mapId, tag);
    }

    /**
     * Add a new tag to the map.
     *
     * @param mapId The ID of the map.
     * @return The tags.
     */
    public MapTags addTag(long mapId, String tag, String sessionToken) {
        checkId(mapId);
        return mMapInterface.addTag(mapId, tag, sessionToken);
    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to delete from the map.
     * @return The tags.
     */
    public MapTags deleteTag(long mapId, String tag, String sessionToken) {
        checkId(mapId);
        return mMapInterface.deleteTag(mapId, tag, sessionToken);
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
        return mMapInterface.getPostOnMap(mapId);
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
        return mMapInterface.getPostOnMapByTag(mapId, tag);
    }

    /**
     * Approve or deny a post on map.
     *
     * @param mapId  The ID of the map to approve or deny the post.
     * @param postId The post post to approve or deny.
     * @return The posts
     */
    public Posts approveOrDenyPostOnMap(long mapId, long postId, String sessionToken) {
        //Double check the fields involve
        checkId(mapId);
        checkId(postId);
        return mMapInterface.approveOrDenyPostOnMap(mapId, postId, sessionToken);
    }

    public Posts removePostFromMap(long mapId, long postId, String sessionToken) {
        checkId(mapId);
        checkId(postId);
        return mMapInterface.removePostFromMap(mapId, postId, sessionToken);
    }

    /**
     * Create a new Map.
     *
     * <p><strong>Note:</strong> Requires authentication</p>
     *
     * @param subdomain The MapForm holding the map field values
     * @return The newly created map
     */
    public Maps createMap(String subdomain, String name, String description, String sessionToken) {
        return mMapInterface.createMap(subdomain, name, description, sessionToken);
    }

    /**
     * Create a new banner
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param banner The image file
     */
    public Maps createBanner(long mapId, TypedFile banner, String sessionToken) {
        return mMapInterface.createBanner(mapId, banner, sessionToken);
    }

    /**
     * Create an avatar for an existing map.
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param avatar The image file
     * @return The updated map
     */
    public Maps createAvatar(long mapId, TypedFile avatar, String sessionToken,
            ApiCallback<Maps> callback) {
        return mMapInterface.createAvatar(mapId, avatar, sessionToken);
    }

    /**
     * Update an exisiting map.
     *
     * @param mapId The ID of the map to be updated.
     * @param name  The fields to be updated.
     * @return The updated map.
     */
    public Maps updateMap(long mapId, String name, String description, String sessionToken) {
        return mMapInterface.updateMap(mapId, name, description, sessionToken);
    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map
     * @return The list of maps minus the deleted map
     */
    public Maps deleteMap(long mapId, String sessionToken) {
        return mMapInterface.deleteMap(mapId, sessionToken);
    }

    /**
     * Get map settings.
     *
     * @param mapId        The map to get it's settings.
     * @param settingsName The map settings name.
     * @return The map settings
     */
    public MapSettings getMapSettings(long mapId, String settingsName, String sessionToken) {
        return mMapInterface.getMapSettings(mapId, settingsName, sessionToken);
    }

    public MapSettings updateMapSettings(long mapId, String settingsName, String settingsValue,
            String sessionToken,
            ApiCallback<MapSettings> callback) {
        return mMapInterface.updateMapSettings(mapId, settingsName, settingsValue, sessionToken);
    }

    /**
     * Delete map settings.
     *
     * @param mapId        The ID of the map to delete it's settings.
     * @param settingsName The name of the settings to delete.
     * @return The map settings
     */
    public MapSettings deleteMapSettings(long mapId, String settingsName, String sessionToken) {
        checkId(mapId);
        return mMapInterface.deleteMapSettings(mapId, settingsName, sessionToken);
    }

}
