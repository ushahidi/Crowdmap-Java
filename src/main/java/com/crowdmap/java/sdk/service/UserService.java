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
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Notifications;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.json.Users;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.UserInterface;

import retrofit.RestAdapter;

/**
 * User service
 */
public class UserService extends CrowdmapService<UserService> {

    private UserInterface mUserInterface;

    public UserService(RestAdapter restAdapter) {
        super(restAdapter);
        mUserInterface = restAdapter.create(UserInterface.class);
    }

    /**
     * Get users registered on Crowdmap
     *
     * @return Users detail
     */
    public void getUsers(ApiCallback<Users> callback) {
        mUserInterface.getUsers(callback);
    }

    /**
     * Get Posts a particular user has created
     *
     * @param userId The user's ID
     * @return Posts the user has created
     */
    public void getUsersPosts(long userId, ApiCallback<Posts> callback) {
        mUserInterface.getUsersPosts(userId, callback);
    }

    /**
     * Update details of a particular user
     *
     * @param userId The user's ID
     * @param name   User fields;
     */
    public void updateUser(long userId, String name,
            String bio,
            String baseLayer,
            boolean isTwitterAutoPost,
            boolean isInstagramAutoPost,
            boolean isTwitterAutoPostRetweets,
            @SessionToken String sessionToken,
            ApiCallback<Users> callback) {

        // Not sure how to send boolean value to the server. So turn true to 1 and false to 0
        final int twitterAutoPost = isTwitterAutoPost ? 1 : 0;
        final int instagramAutoPost = isInstagramAutoPost ? 1 : 0;
        final int twitterAutoPostRetweet = isTwitterAutoPostRetweets ? 1 : 0;

        mUserInterface.updateUser(userId, name, bio, baseLayer, twitterAutoPost, instagramAutoPost,
                twitterAutoPostRetweet, sessionToken, callback);
    }

    /**
     * Get a user by the ID
     *
     * @return The User
     */
    public void getUser(long userId, ApiCallback<Users> callback) {
        mUserInterface.getUser(userId, callback);
    }

    /**
     * Update user avatar
     *
     * @param userId The user's ID
     * @return The updated user
     */
    public void updateUserAvatar(long userId, String avatar, @SessionToken String sessionToken,
            ApiCallback<Users> callback) {
        mUserInterface.updateAvatar(userId, avatar, sessionToken, callback);
    }

    /**
     * Delete a user's avatar
     *
     * @param userId The user's ID
     * @return The user.
     */
    public void deleteUserAvatar(long userId, @SessionToken String sessionToken,
            ApiCallback<Users> callback) {
        mUserInterface.deleteUserAvatar(userId, sessionToken, callback);
    }

    /**
     * Get Users followed by a particular users
     *
     * @param userId The user ID of the user to get his/her followers.
     * @return The users
     */
    public void getUsersFollowedBy(long userId, ApiCallback<Users> callback) {
        mUserInterface.getUsersFollowedBy(userId, callback);
    }

    /**
     * Verify that a user follows the provided user ID
     *
     * @return The Users
     */
    public void verifyUsersFollowing(long userId, long followerId, ApiCallback<Users> callback) {
        mUserInterface.verifyUsersFollowing(userId, followerId, callback);
    }

    /**
     * Get a User's followers
     *
     * @return The User the user follows
     */
    public void getUsersFollowers(long userId, ApiCallback<Users> callback) {
        mUserInterface.getUsersFollowers(userId, callback);
    }

    /**
     * Follow a user.
     *
     * This requires authentication
     *
     * @return The Users the user follows with the new user the user is following.
     */
    public void followUser(long userId, @SessionToken String sessionToken,
            ApiCallback<Users> callback) {
        mUserInterface.followUser(userId, sessionToken, callback);
    }

    /**
     * Stop following a user
     *
     * @param userId The user's ID
     * @return The users the user follows without including the user the user stopped following.
     */
    public void stopFollowingUser(long userId, @SessionToken String sessionToken,
            ApiCallback<Users> callback) {
        mUserInterface.stopFollowingUser(userId, sessionToken, callback);
    }

    /**
     * Get the map the user follows
     *
     * @param userId The user's ID
     * @return The map the user follows
     */
    public void getUserFollowedMap(long userId, ApiCallback<Maps> callback) {
        mUserInterface.getUserFollowedMap(userId, callback);
    }

    /**
     * Get the map a user collaborates on.
     *
     * @param userId The user's ID
     * @return The maps the user collaborates on.
     */
    public void getMapsUserCollaboratesOn(long userId, ApiCallback<Maps> callback) {
        mUserInterface.getMapsUserCollaboratesOn(userId, callback);
    }

    /**
     * Get a user's map.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public void getUsersMaps(long userId, ApiCallback<Maps> callback) {
        mUserInterface.getUsersMaps(userId, callback);
    }

    /**
     * The map a user is associated with.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public void getUsersAssociatedMaps(long userId, ApiCallback<Maps> callback) {
        mUserInterface.getUsersAssociatedMaps(userId, callback);
    }

    /**
     * Get users notifications
     *
     * @param userId The user's ID to be used for fetching the notification details
     * @return The list of notifications
     */
    public void getNotifications(long userId, ApiCallback<Notifications> callback) {
        mUserInterface.getNotifications(userId, callback);
    }

    /**
     * Mark a notification as read
     *
     * @param userId The user's ID
     * @return The user's notifications
     */
    public void markNotificationAsRead(long userId, @SessionToken String sessionToken,
            ApiCallback<Response> callback) {
        mUserInterface.markNotificationAsRead(userId, sessionToken, callback);
    }
}
