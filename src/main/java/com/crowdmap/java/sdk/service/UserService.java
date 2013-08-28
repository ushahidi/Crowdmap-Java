/*******************************************************************************
 ** Copyright (c) 2010 - 2013 Ushahidi Inc
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
 ******************************************************************************/

package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Users;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.model.UserForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
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
     *
     * @param userId
     * @return
     */
    public Users getUser(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        setApiKey(METHOD_GET, url.toString());
        String json = client.get(url.toString());
        return fromString(json, Users.class);
    }

    /**
     *
     * @param userId
     * @return
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
     *
     * @param userId
     * @return
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
     *
     * @param userId
     * @return
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
     */
    public Users followUser(long userId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWERS);
        return fromString(client.post(url.toString()), Users.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Users stopFollowingUser(long userId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_FOLLOWERS);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.post(url.toString()), Users.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps getUserFollowedMap(long userId) {
        // Set session token
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_FOLLOWING);

        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps getMapsUserCollaboratesOn(long userId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_COLLABORATING);
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps getUsersMaps(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_OWNS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps getUsersAssociatedMaps(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_MAPS_ASSOCIATED);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps getNotifications(long userId) {
        //TODO:: ask Brian the fields for notifications
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_NOTIFICATIONS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }

    /**
     *
     * @param userId
     * @return
     */
    public Maps markNotificationAsRead(long userId) {
        //TODO ask Brian the fields for making a notification as read
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_NOTIFICATIONS);
        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.get(url.toString()), Maps.class);
    }
}
