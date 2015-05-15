/*******************************************************************************
 * Copyright (c) 2010 - 2014 Ushahidi Inc.
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

package com.crowdmap.java.sdk.service.api;

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Notifications;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.json.Users;

import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

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
 * User interface
 */
public interface UserInterface {

    @GET(SEGMENT_USERS)
    Users getUsers();

    @GET(SEGMENT_USERS + "{user_id}")
    Users getUser(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_POSTS)
    Posts getUsersPosts(@Path("user_id") long userId);

    @FormUrlEncoded
    @POST(SEGMENT_USERS + "{user_id}")
    Users updateUser(@Path("user_id") long userId, @Field("name") String name,
            @Field("bio") String bio,
            @Field("baseLayer") String baseLayer,
            @Field("twitter_auto_post") int twitterAutoPost,
            @Field("instagram_auto_post") int isInstagramAutoPost,
            @Field("twitter_auto_post_retweets") int isTwitterAutoPostRetweets,
            @Field("session") @SessionToken String sessionToken);

    @FormUrlEncoded
    @POST(SEGMENT_USERS + "{user_id}" + SEGMENT_AVATAR)
    Users updateAvatar(@Path("user_id") long userId, @Field("avatar") String avatar,
            @Field("session") @SessionToken String sessionToken);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_AVATAR)
    Users getAvatar(@Path("user_id") long userId, @Field("avatar") String avatar);

    @DELETE(SEGMENT_USERS + "{user_id}" + SEGMENT_AVATAR)
    Users deleteUserAvatar(@Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_FOLLOWS)
    Users getUsersFollowedBy(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_FOLLOWS + "{follower_id/}")
    Users verifyUsersFollowing(@Path("user_id") long userId, @Path("follower_id") long followerId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_FOLLOWERS)
    Users getUsersFollowers(@Path("user_id") long userId);

    @FormUrlEncoded
    @POST(SEGMENT_USERS + "{user_id}" + SEGMENT_FOLLOWERS)
    Users followUser(@Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken);

    @DELETE(SEGMENT_USERS + "{user_id}" + SEGMENT_FOLLOWERS)
    Users stopFollowingUser(@Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_MAPS_FOLLOWING)
    Maps getUserFollowedMap(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_MAPS_COLLABORATING)
    Maps getMapsUserCollaboratesOn(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_MAPS_OWNS)
    Maps getUsersMaps(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_MAPS_ASSOCIATED)
    Maps getUsersAssociatedMaps(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_NOTIFICATIONS)
    Notifications getNotifications(@Path("user_id") long userId);

    @GET(SEGMENT_USERS + "{user_id}" + SEGMENT_NOTIFICATIONS)
    Response markNotificationAsRead(long userId,
            @Query("session") @SessionToken String sessionToken);
}
