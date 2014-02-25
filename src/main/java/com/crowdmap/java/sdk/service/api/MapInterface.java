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
import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Followers;
import com.crowdmap.java.sdk.json.MapSettings;
import com.crowdmap.java.sdk.json.MapTags;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Owner;
import com.crowdmap.java.sdk.json.Posts;

import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

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
 * Map Interface
 */
public interface MapInterface {

    @GET(SEGMENT_MAPS)
    void getMaps(ApiCallback<Maps> callback);

    @GET(SEGMENT_MAPS)
    void getMaps(@Query("session") @SessionToken String sessionToken,
            ApiCallback<Maps> callback);

    @GET(SEGMENT_MAPS + "{map_id}")
    void getMap(@Path("map_id") long mapId, ApiCallback<Maps> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_OWNER)
    void getMapOwner(@Path("map_id") long mapId, ApiCallback<Owner> callback);


    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_OWNER + "{user_id}")
    void updateOwner(@Path("map_id") long mapId, @Path("user_id") long userId,
            ApiCallback<Owner> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS)
    void getCollaborators(@Path("map_id") long mapId, ApiCallback<Collaborators> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS + "{user_id}")
    void addCollaborator(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken,
            ApiCallback<Collaborators> callback);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS + "{user_id}")
    void removeCollaborator(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken,
            ApiCallback<Collaborators> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS)
    void getFollowers(@Path("map_id") long mapId, ApiCallback<Followers> callback);

    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS + "{user_id}")
    void followMap(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Field("session") @SessionToken String sessionToken, ApiCallback<Followers> callback);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS)
    void stopFollowingMap(@Path("map_id") long mapId,
            @Query("session") @SessionToken String sessionToken, ApiCallback<Followers> callback);

    // Tagging Maps
    @GET(SEGMENT_MAPS + SEGMENT_TAGS + "{tag}")
    void getTags(@Path("tag") String tag, ApiCallback<MapTags> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS + "{tag}")
    void getTags(@Path("map_id") long mapId, @Path("tag") String tag,
            ApiCallback<MapTags> callback);

    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS)
    void addTag(@Path("map_id") long mapId, String tag,
            @Field("session") @SessionToken String sessionToken, ApiCallback<MapTags> callback);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS + "{tag}")
    void deleteTag(@Path("map_id") long mapId, @Path("tag") String tag,
            @Query("session") @SessionToken String sessionToken, ApiCallback<MapTags> callback);

    //post on a map
    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS)
    void getPostOnMap(@Path("map_id") long mapId, ApiCallback<Posts> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{tag}")
    void getPostOnMapByTag(@Path("map_id") long mapId, @Path("tag") String tag,
            ApiCallback<Posts> callback);

    @PUT(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{post_id}")
    void approveOrDenyPostOnMap(@Path("map_id") long mapId, @Path("post_id") long postId,
            @SessionToken String sessionToken, ApiCallback<Posts> callback);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{post_id}")
    void removePostFromMap(@Path("map_id") long mapId, @Path("post_id") long postId,
            @SessionToken String sessionToken, ApiCallback<Posts> callback);

    @POST(SEGMENT_MAPS)
    void createMap(@Field("subdomain") String subdomain, @SessionToken String sessionToken,
            ApiCallback<Posts> callback);

    @Multipart
    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_BANNER)
    void createBanner(@Path("map_id") long mapId,
            @Part("banner") TypedFile banner,
            @SessionToken String sessionToken,
            ApiCallback<Maps> callback);

    @Multipart
    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_AVATAR)
    void createAvatar(@Path("map_id") long mapId, @Part("avatar") TypedFile avatar,
            @SessionToken String sessionToken,
            ApiCallback<Maps> callback);

    @POST(SEGMENT_MAPS + "{map_id}")
    void updateMap(@Path("map_id") long mapId,
            @Field("name") String name,
            @Field("description") String description,
            @SessionToken String sessionToken,
            ApiCallback<Maps> callback);

    @DELETE(SEGMENT_MAPS + "{map_id}")
    void deleteMap(@Path("map_id") long mapId,
            @SessionToken String sessionToken,
            ApiCallback<Maps> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS + "{setting}")
    void getMapSettings(@Path("map_id") long mapId, @Path("setting") String settingsName,
            ApiCallback<MapSettings> callback);

    @PUT(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS)
    void updateMapSettings(@Path("map_id") long mapId,
            @Field("setting") String settingsName,
            @Field("value") String settingsValue,
            @Field("session") @SessionToken String sessionToken, ApiCallback<MapSettings> callback);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS + "{setting}")
    void deleteMapSettings(@Path("map_id") long mapId, @Path("setting") String settingsName,
            @Field("session") @SessionToken String sessionToken, ApiCallback<MapSettings> callback);
}
