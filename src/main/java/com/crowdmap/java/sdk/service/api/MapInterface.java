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
    Maps getMaps();

    @GET(SEGMENT_MAPS)
    Maps getMaps(@Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_MAPS + "{map_id}")
    Maps getMaps(@Path("map_id") long mapId);

    @GET(SEGMENT_MAPS + "{map_id}")
    Maps getMaps(@Path("map_id") long mapId, @Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_OWNER)
    Owner getMapOwner(@Path("map_id") long mapId);


    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_OWNER + "{user_id}")
    Owner updateOwner(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS)
    Collaborators getCollaborators(@Path("map_id") long mapId);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS + "{user_id}")
    Collaborators addCollaborator(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Query("session") String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_COLLABORATORS + "{user_id}")
    Collaborators removeCollaborator(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Query("session") @SessionToken String sessionToken);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS)
    Followers getFollowers(@Path("map_id") long mapId);

    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS + "{user_id}")
    Followers followMap(@Path("map_id") long mapId, @Path("user_id") long userId,
            @Field("session") @SessionToken String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_FOLLOWERS)
    Followers stopFollowingMap(@Path("map_id") long mapId,
            @Query("session") @SessionToken String sessionToken);

    // Tagging Maps
    @GET(SEGMENT_MAPS + SEGMENT_TAGS + "{tag}")
    MapTags getTags(@Path("tag") String tag);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS + "{tag}")
    MapTags getTags(@Path("map_id") long mapId, @Path("tag") String tag);

    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS)
    MapTags addTag(@Path("map_id") long mapId, String tag,
            @Field("session") @SessionToken String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_TAGS + "{tag}")
    MapTags deleteTag(@Path("map_id") long mapId, @Path("tag") String tag,
            @Field("session") @SessionToken String sessionToken);

    //post on a map
    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS)
    Posts getPostOnMap(@Path("map_id") long mapId);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{tag}")
    Posts getPostOnMapByTag(@Path("map_id") long mapId, @Path("tag") String tag);

    @PUT(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{post_id}")
    Posts approveOrDenyPostOnMap(@Path("map_id") long mapId, @Path("post_id") long postId,
            @Field("session") String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_POSTS + "{post_id}")
    Posts removePostFromMap(@Path("map_id") long mapId, @Path("post_id") long postId,
            @Field("session") String sessionToken);

    @POST(SEGMENT_MAPS)
    Maps createMap(@Field("subdomain") String subdomain, @Field("name") String name,
            @Field("description") String description, @Field("session") String sessionToken);

    @Multipart
    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_BANNER)
    Maps createBanner(@Path("map_id") long mapId,
            @Part("banner") TypedFile banner,
            @Part("session") String sessionToken);

    @Multipart
    @POST(SEGMENT_MAPS + "{map_id}" + SEGMENT_AVATAR)
    Maps createAvatar(@Path("map_id") long mapId, @Part("avatar") TypedFile avatar,
            @Part("session") String sessionToken);

    @PUT(SEGMENT_MAPS + "{map_id}")
    Maps updateMap(@Path("map_id") long mapId,
            @Query("name") String name,
            @Query("description") String description,
            @Query("session") String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}")
    Maps deleteMap(@Path("map_id") long mapId,
            @Query("session") String sessionToken);

    @GET(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS + "{setting}")
    MapSettings getMapSettings(@Path("map_id") long mapId, @Path("setting") String settingsName,
            @Query("session") String sessionToken);

    @PUT(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS)
    MapSettings updateMapSettings(@Path("map_id") long mapId,
            @Query("setting") String settingsName,
            @Query("value") String settingsValue,
            @Query("session") @SessionToken String sessionToken);

    @DELETE(SEGMENT_MAPS + "{map_id}" + SEGMENT_SETTINGS + "{setting}")
    MapSettings deleteMapSettings(@Path("map_id") long mapId, @Path("setting") String settingsName,
            @Query("session") @SessionToken String sessionToken);
}
