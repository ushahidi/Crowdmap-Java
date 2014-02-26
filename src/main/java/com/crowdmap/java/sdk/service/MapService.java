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
    public void getMaps(ApiCallback<Maps> callback) {
        mMapInterface.getMaps(callback);
    }


    /**
     * Get Map as an authenticated user.
     *
     * @return A list containing all the maps as an authenticated user
     */
    public void getMaps(@SessionToken String sessionToken, ApiCallback<Maps> callback) {
        mMapInterface.getMaps(sessionToken, callback);
    }

    /**
     * Returns a specific map. GET /maps/:map_id
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public void getMaps(long mapId, ApiCallback<Maps> callback) {
        checkId(mapId);
        mMapInterface.getMaps(mapId, callback);
    }

    /**
     * <p>Returns a specific map.</p>
     *
     * <strong>Note:</strong> This requires session token to be set.
     *
     * @param mapId The ID of the map
     * @return A specific map
     */
    public void getMaps(long mapId, String sessionToken, ApiCallback<Maps> callback) {
        checkId(mapId);
        mMapInterface.getMaps(mapId, sessionToken, callback);
    }

    // Users associations with maps

    /**
     * Get information about the owner of a particular map. GET /maps/:map_id/owner
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public void getMapOwner(long mapId, ApiCallback<Owner> callback) {
        checkId(mapId);
        mMapInterface.getMapOwner(mapId, callback);
    }

    /**
     * Change the owner of a map.
     *
     * @param mapId The ID of the map
     * @return The information about the owner of the map
     */
    public void updateOwner(long mapId, long userId, String sessionToken,
            ApiCallback<Owner> callback) {
        checkId(mapId);
        checkId(userId);
        mMapInterface.updateOwner(mapId, userId, sessionToken, callback);
    }


    /**
     * Get the collaborators on a map. GET /maps/:map_id/collaborators
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public void getCollaborators(long mapId, ApiCallback<Collaborators> callback) {
        checkId(mapId);
        mMapInterface.getCollaborators(mapId, callback);
    }

    /**
     * Add a collaborator to the a map.
     *
     * @param mapId  The ID of the map. This should be a map the logged in user owns.
     * @param userId The ID of the user.
     * @return The  Collaborators.
     */
    public void addCollaborator(long mapId, long userId, String sessionToken,
            ApiCallback<Collaborators> callback) {
        checkId(mapId);
        checkId(userId);
        mMapInterface.addCollaborator(mapId, userId, sessionToken, callback);
    }

    /**
     * Remove a collaborator from the map
     *
     * @param mapId  The ID of the map.
     * @param userId The ID of the user.
     * @return The collaborators on the map.
     */
    public void removeCollaborator(long mapId, long userId, String sessionToken,
            ApiCallback<Collaborators> callback) {
        checkId(mapId);
        checkId(userId);
        mMapInterface.removeCollaborator(mapId, userId, sessionToken, callback);
    }

    /**
     * Get the followers of a map. GET /maps/:map_id/followers
     *
     * @param mapId The ID of the map.
     * @return The followers of a map.
     */
    public void getFollowers(long mapId, ApiCallback<Followers> callback) {
        checkId(mapId);
        mMapInterface.getFollowers(mapId, callback);
    }

    /**
     * Follower a map.
     *
     * @param mapId  The ID of the map.
     * @param userId The user ID.
     * @return The maps.
     */
    public void followMap(long mapId, long userId, String sessionToken,
            ApiCallback<Followers> callback) {
        checkId(mapId);
        checkId(userId);
        mMapInterface.followMap(mapId, userId, sessionToken, callback);
    }

    /**
     * Stop following a particular map.
     *
     * @param mapId The ID of the map to stop following.
     * @return The followers of the map.
     */
    public void stopFollowingMap(long mapId, String sessionToken, ApiCallback<Followers> callback) {
        checkId(mapId);
        mMapInterface.stopFollowingMap(mapId, sessionToken, callback);
    }

    // Tagging Maps

    /**
     * Get tags attached to a map.
     *
     * @param tag The tag to add to the map.
     * @return The tags.
     */
    public void getTags(String tag, ApiCallback<MapTags> callback) {
        mMapInterface.getTags(tag, callback);
    }

    /**
     * Get tags of a particular map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to retrieve the map by.
     * @return The tags
     */
    public void getTags(long mapId, String tag, ApiCallback<MapTags> callback) {
        checkId(mapId);
        mMapInterface.getTags(mapId, tag, callback);
    }

    /**
     * Add a new tag to the map.
     *
     * @param mapId The ID of the map.
     * @return The tags.
     */
    public void addTag(long mapId, String tag, String sessionToken, ApiCallback<MapTags> callback) {
        checkId(mapId);
        mMapInterface.addTag(mapId, tag, sessionToken, callback);
    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to delete from the map.
     * @return The tags.
     */
    public void deleteTag(long mapId, String tag, String sessionToken,
            ApiCallback<MapTags> callback) {
        checkId(mapId);
        mMapInterface.deleteTag(mapId, tag, sessionToken, callback);
    }

    //post on a map

    /**
     * Get a post on a map.
     *
     * @param mapId The ID of the map.
     * @return The Posts
     */
    public void getPostOnMap(long mapId, ApiCallback<Posts> callback) {
        checkId(mapId);
        mMapInterface.getPostOnMap(mapId, callback);
    }

    /**
     * Post a tag on a map.
     *
     * @param mapId The ID of the map.
     * @param tag   The tag to post on the map.
     * @return The posts
     */
    public void getPostOnMapByTag(long mapId, String tag, ApiCallback<Posts> callback) {
        checkId(mapId);
        mMapInterface.getPostOnMapByTag(mapId, tag, callback);
    }

    /**
     * Approve or deny a post on map.
     *
     * @param mapId  The ID of the map to approve or deny the post.
     * @param postId The post post to approve or deny.
     * @return The posts
     */
    public void approveOrDenyPostOnMap(long mapId, long postId, String sessionToken,
            ApiCallback<Posts> callback) {
        //Double check the fields involve
        checkId(mapId);
        checkId(postId);
        mMapInterface.approveOrDenyPostOnMap(mapId, postId, sessionToken, callback);
    }

    public void removePostFromMap(long mapId, long postId, String sessionToken,
            ApiCallback<Posts> callback) {
        checkId(mapId);
        checkId(postId);
        mMapInterface.removePostFromMap(mapId, postId, sessionToken, callback);
    }

    /**
     * Create a new Map.
     *
     * <p><strong>Note:</strong> Requires authentication</p>
     *
     * @param subdomain The MapForm holding the map field values
     * @return The newly created map
     */
    public void createMap(String subdomain, String name, String description, String sessionToken,
            ApiCallback<Maps> callback) {
        mMapInterface.createMap(subdomain, name, description, sessionToken, callback);
    }

    /**
     * Create a new banner
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param banner The image file
     */
    public void createBanner(long mapId, TypedFile banner, String sessionToken,
            ApiCallback<Maps> callback) {
        mMapInterface.createBanner(mapId, banner, sessionToken, callback);
    }

    /**
     * Create an avatar for an existing map.
     *
     * @param mapId  The ID of the map to attach the image to be uploaded to.
     * @param avatar The image file
     * @return The updated map
     */
    public void createAvatar(long mapId, TypedFile avatar, String sessionToken,
            ApiCallback<Maps> callback) {
        mMapInterface.createAvatar(mapId, avatar, sessionToken, callback);
    }

    /**
     * Update an exisiting map.
     *
     * @param mapId The ID of the map to be updated.
     * @param name  The fields to be updated.
     * @return The updated map.
     */
    public void updateMap(long mapId, String name, String description, String sessionToken,
            ApiCallback<Maps> callback) {
        mMapInterface.updateMap(mapId, name, description, sessionToken, callback);
    }

    /**
     * Delete an existing map.
     *
     * @param mapId The ID of the map
     * @return The list of maps minus the deleted map
     */
    public void deleteMap(long mapId, String sessionToken,
            ApiCallback<Maps> callback) {
        mMapInterface.deleteMap(mapId, sessionToken, callback);
    }

    /**
     * Get map settings.
     *
     * @param mapId        The map to get it's settings.
     * @param settingsName The map settings name.
     * @return The map settings
     */
    public void getMapSettings(long mapId, String settingsName, String sessionToken,
            ApiCallback<MapSettings> callback) {
        mMapInterface.getMapSettings(mapId, settingsName, sessionToken, callback);
    }

    public void updateMapSettings(long mapId, String settingsName, String settingsValue,
            String sessionToken,
            ApiCallback<MapSettings> callback) {
        mMapInterface.updateMapSettings(mapId, settingsName, settingsValue, sessionToken, callback);
    }

    /**
     * Delete map settings.
     *
     * @param mapId        The ID of the map to delete it's settings.
     * @param settingsName The name of the settings to delete.
     * @return The map settings
     */
    public void deleteMapSettings(long mapId, String settingsName, String sessionToken,
            ApiCallback<MapSettings> callback) {
        checkId(mapId);
        mMapInterface.deleteMapSettings(mapId, settingsName, sessionToken, callback);
    }

}
