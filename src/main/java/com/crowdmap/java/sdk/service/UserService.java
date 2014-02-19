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

import com.crowdmap.java.sdk.ApiKeys;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Notifications;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.json.Users;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.model.form.UserForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.LIMIT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.OFFSET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_AVATAR;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_FOLLOWERS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_FOLLOWS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS_ASSOCIATED;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS_COLLABORATING;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS_FOLLOWING;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS_OWNS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_NOTIFICATIONS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_USERS;

/**
 * User service
 */
public class UserService extends CrowdmapService {

    public UserService(ApiKeys keys){
        super(keys);
    }
    /**
     * Get users registered on Crowdmap
     *
     * @return Users detail
     */
    public Users getUsers() {

        //Set the api signature key
        setApiKey(METHOD_GET, SEGMENT_USERS);

        //Send a get request to fetch registered users
        String json = client.get(SEGMENT_USERS);
        return fromString(json,
                Users.class);
    }

    /**
     * Get Posts a particular user has created
     *
     * @param userId The user's ID
     * @return Posts the user has created
     */
    public Posts getUsersPosts(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_POSTS);

        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Posts.class);
    }

    /**
     * Update details of a particular user
     *
     * @param userId   The user's ID
     * @param userFrom User fields;
     */
    public User updateUser(long userId, UserForm userFrom) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);

        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.put(url.toString(), userFrom.getParameters()), User.class);
    }

    /**
     * Get a user by the ID
     *
     * @return The User
     */
    public Users getUser(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        setApiKey(METHOD_GET, url.toString());
        String json = client.get(url.toString());
        return fromString(json, Users.class);
    }

    /**
     * Update user avatar
     *
     * @param userId The user's ID
     * @return The updated user
     */
    public User updateUserAvatar(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_AVATAR);
        setApiKey(METHOD_PUT, url.toString());
        //TODO: lookup the form fields
        return null;

    }

    /**
     * Delete a user's avatar
     *
     * @param userId The user's ID
     * @return The user.
     */
    public User deleteUserAvatar(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_AVATAR);
        setApiKey(METHOD_DELETE, url.toString());
        //TODO: lookup the form fields for avatar
        return fromString(client.delete(url.toString()), User.class);
    }

    /**
     * Get Users followed by a particular users
     *
     * @param userId The user ID of the user to get his/her followers.
     * @return The users
     */
    public Users getUsersFollowedBy(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWS);
        setApiKey(METHOD_GET, url.toString());

        return fromString(client.get(url.toString()), Users.class);
    }

    /**
     * Verify that a user follows the provided user ID
     *
     * @return The Users
     */
    public Users verifyUsersFollowing(long userId, long followerId) {

        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWS);
        url.append(followerId);
        url.append("/");
        setApiKey(METHOD_GET, url.toString());

        return fromString(client.get(url.toString()), Users.class);
    }

    /**
     * Get a User's followers
     *
     * @return The User the user follows
     */
    public Users getUsersFollowers(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_GET, url.toString());

        return fromString(client.get(url.toString()), Users.class);
    }

    /**
     * Follow a user.
     *
     * This requires authentication
     *
     * @return The Users the user follows with the new user the user is following.
     */
    public Users followUser(long userId) {
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWERS);
        return fromString(client.post(url.toString()), Users.class);
    }

    /**
     * Stop following a user
     *
     * @param userId The user's ID
     * @return The users the user follows without including the user the user stopped following.
     */
    public Users stopFollowingUser(long userId) {
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.post(url.toString()), Users.class);
    }

    /**
     * Get the map the user follows
     *
     * @param userId The user's ID
     * @return The map the user follows
     */
    public Maps getUserFollowedMap(long userId) {
        // Set session token
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_FOLLOWING);

        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * Get the map a user collaborates on.
     *
     * @param userId The user's ID
     * @return The maps the user collaborates on.
     */
    public Maps getMapsUserCollaboratesOn(long userId) {
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_COLLABORATING);
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * Get a user's map.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public Maps getUsersMaps(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_OWNS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * The map a user is associated with.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public Maps getUsersAssociatedMaps(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_ASSOCIATED);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     * Get users notifications
     *
     * @param userId The user's ID to be used for fetching the notification details
     * @return The list of notifications
     */
    public Notifications getNotifications(long userId) {
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_NOTIFICATIONS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Notifications.class);
    }

    /**
     * Mark a notification as read
     *
     * @param userId The user's ID
     * @return The user's notifications
     */
    public Response markNotificationAsRead(long userId) {
        validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_NOTIFICATIONS);
        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.get(url.toString()), Response.class);
    }

    /**
     * Limit the number items to return.
     *
     * @param limit The limit number.
     * @return The UserSerivce.
     */
    public UserService limit(int limit) {
        if (limit > 0) {
            getHttpClient().setRequestParameters(LIMIT, String.valueOf(limit));
        }
        return this;
    }

    /**
     * The offset to use to limit the number of items returned.
     *
     * <p><strong>Note:</strong> This requires limit to be set.</p>
     *
     * @return The UserSerice
     */
    public UserService offset(int offset) {
        if (getHttpClient().getRequestParameters().containsKey(LIMIT)) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        getHttpClient().setRequestParameters(OFFSET, String.valueOf(offset));
        return this;
    }

    @Override
    public UserService setSessionToken(String sessionToken) {
        if ((sessionToken == null) || (sessionToken.length() == 0)) {
            throw new IllegalArgumentException("Session token cannot be null or empty");
        }
        getHttpClient().setSessionToken(sessionToken);
        return this;
    }
}
