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
    public Users getUsers() {
        return mUserInterface.getUsers();
    }

    /**
     * Get Posts a particular user has created
     *
     * @param userId The user's ID
     * @return Posts the user has created
     */
    public Posts getUsersPosts(long userId) {
        checkId(userId);
        return mUserInterface.getUsersPosts(userId);
    }

    /**
     * Update details of a particular user
     *
     * @param userId The user's ID
     * @param name   User fields;
     */
    public Users updateUser(long userId, String name,
            String bio,
            String baseLayer,
            boolean isTwitterAutoPost,
            boolean isInstagramAutoPost,
            boolean isTwitterAutoPostRetweets,
            @SessionToken String sessionToken) {
        checkId(userId);
        // Not sure how to send boolean value to the server. So turn true to 1 and false to 0
        final int twitterAutoPost = isTwitterAutoPost ? 1 : 0;
        final int instagramAutoPost = isInstagramAutoPost ? 1 : 0;
        final int twitterAutoPostRetweet = isTwitterAutoPostRetweets ? 1 : 0;

        return mUserInterface.updateUser(userId, name, bio, baseLayer, twitterAutoPost, instagramAutoPost,
                twitterAutoPostRetweet, sessionToken);
    }

    /**
     * Get a user by the ID
     *
     * @return The User
     */
    public Users getUser(long userId) {
        checkId(userId);
        return mUserInterface.getUser(userId);
    }

    /**
     * Update user avatar
     *
     * @param userId The user's ID
     * @return The updated user
     */
    public Users updateUserAvatar(long userId, String avatar, @SessionToken String sessionToken) {
        checkId(userId);
        return mUserInterface.updateAvatar(userId, avatar, sessionToken);
    }

    /**
     * Delete a user's avatar
     *
     * @param userId The user's ID
     * @return The user.
     */
    public Users deleteUserAvatar(long userId, @SessionToken String sessionToken) {
        checkId(userId);
        return mUserInterface.deleteUserAvatar(userId, sessionToken);
    }

    /**
     * Get Users followed by a particular users
     *
     * @param userId The user ID of the user to get his/her followers.
     * @return The users
     */
    public Users getUsersFollowedBy(long userId) {
        return mUserInterface.getUsersFollowedBy(userId);
    }

    /**
     * Verify that a user follows the provided user ID
     *
     * @return The Users
     */
    public Users verifyUsersFollowing(long userId, long followerId) {
        checkId(userId);
        return mUserInterface.verifyUsersFollowing(userId, followerId);
    }

    /**
     * Get a User's followers
     *
     * @return The User the user follows
     */
    public Users getUsersFollowers(long userId) {
        checkId(userId);
        return mUserInterface.getUsersFollowers(userId);
    }

    /**
     * Follow a user.
     *
     * This requires authentication
     *
     * @return The Users the user follows with the new user the user is following.
     */
    public Users followUser(long userId, @SessionToken String sessionToken) {
        checkId(userId);
        return mUserInterface.followUser(userId, sessionToken);
    }

    /**
     * Stop following a user
     *
     * @param userId The user's ID
     * @return The users the user follows without including the user the user stopped following.
     */
    public Users stopFollowingUser(long userId, @SessionToken String sessionToken) {
        checkId(userId);
        return mUserInterface.stopFollowingUser(userId, sessionToken);
    }

    /**
     * Get the map the user follows
     *
     * @param userId The user's ID
     * @return The map the user follows
     */
    public Maps getUserFollowedMap(long userId) {
        checkId(userId);
        return mUserInterface.getUserFollowedMap(userId);
    }

    /**
     * Get the map a user collaborates on.
     *
     * @param userId The user's ID
     * @return The maps the user collaborates on.
     */
    public Maps getMapsUserCollaboratesOn(long userId) {
        checkId(userId);
        return mUserInterface.getMapsUserCollaboratesOn(userId);
    }

    /**
     * Get a user's map.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public Maps getUsersMaps(long userId) {
        checkId(userId);
        return mUserInterface.getUsersMaps(userId);
    }

    /**
     * The map a user is associated with.
     *
     * @param userId The user's ID
     * @return The maps by the user.
     */
    public Maps getUsersAssociatedMaps(long userId) {
        checkId(userId);
       return mUserInterface.getUsersAssociatedMaps(userId);
    }

    /**
     * Get users notifications
     *
     * @param userId The user's ID to be used for fetching the notification details
     * @return The list of notifications
     */
    public Notifications getNotifications(long userId) {
        checkId(userId);
       return mUserInterface.getNotifications(userId);
    }

    /**
     * Mark a notification as read
     *
     * @param userId The user's ID
     * @return The user's notifications
     */
    public Response markNotificationAsRead(long userId, @SessionToken String sessionToken) {
        checkId(userId);
        return mUserInterface.markNotificationAsRead(userId, sessionToken);
    }
}
