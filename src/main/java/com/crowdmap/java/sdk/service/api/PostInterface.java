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

import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.PostTags;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;

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
import retrofit.mime.TypedString;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LIKE;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_TAGS;

/**
 * Post Interface
 */
public interface PostInterface {


    @GET(SEGMENT_POSTS)
    void getPosts(ApiCallback<Posts> callback);


    public void getPosts(@Path("post_id") long postId);

    @GET(SEGMENT_POSTS + "{post_id}")
    void getPostMaps(long postId, ApiCallback<Maps> callback);

    @GET(SEGMENT_POSTS + "{post_id}" + SEGMENT_COMMENTS)
    void getPostComments(long postId, ApiCallback<Maps> callback);

    @Multipart
    @POST(SEGMENT_POSTS)
    public Posts createPost(@Part("message") TypedString message,
            @Part("public") TypedString isPublic,

            @Part("locations[name]") TypedString locationName,

            @Part("locations[lat]") TypedString lat,

            @Part("locations[lon]")
            TypedString lon,

            @Part("locations[geometry]")
            TypedString geometry,

            @Part("locations[fsq_venue_id]")
            TypedString fsqVenueId,

            @Part("map_id")
            TypedString mapId,

            @Part("tweet")
            TypedString tweet,

            @Part("externals[url]")
            TypedString externalUrl,

            @Part("file")
            TypedFile media,
            @Part("session") TypedString sessionToken,
            ApiCallback<Posts> callback);

    @DELETE(SEGMENT_POSTS + "{post_id}")
    void deletePost(@Path("post_id") long postId, @Query("session") String sessionToken,
            ApiCallback<Response> callback);

    @Multipart
    @PUT(SEGMENT_POSTS + "{post_id}")
    void updatePost(@Path("post_id") long postId, @Part("message") TypedString message,
            @Part("public") TypedString isPublic,

            @Part("locations[name]") TypedString locationName,

            @Part("locations[lat]") TypedString lat,

            @Part("locations[lon]")
            TypedString lon,

            @Part("locations[geometry]")
            TypedString geometry,

            @Part("locations[fsq_venue_id]")
            TypedString fsqVenueId,

            @Part("map_id")
            TypedString mapId,

            @Part("tweet")
            TypedString tweet,

            @Part("externals[url]")
            TypedString externalUrl,

            @Part("file")
            TypedFile media, @Part("session") TypedString sessionToken,
            ApiCallback<Posts> callback);

    /**
     * Get tags attached to a post
     *
     * @param tag The name of the tag. This can be CSV
     * @return The tags attached to a post
     */
    @GET(SEGMENT_POSTS + "{tag}" + SEGMENT_TAGS)
    public void getPostTag(String tag, ApiCallback<PostTags> callback);

    @POST(SEGMENT_POSTS + "{post_id}")
    void likePost(@Path("post_id") long postId, @Field("session") String sessionToken,
            ApiCallback<Posts> callback);

    @DELETE(SEGMENT_POSTS + "{post_id}" + SEGMENT_LIKE)
    void unLikePost(@Path("post_id") long postId, @Query("session") String sessionToken,
            ApiCallback<Posts> callback);

    @GET(SEGMENT_POSTS + "{post_id}" + SEGMENT_COMMENTS + "{map_id}")
    void getPostComments(@Path("post_id") long postId, @Path("map_id") long mapId,
            ApiCallback<Comments> callback);

    @POST(SEGMENT_POSTS + "{post_id}" + SEGMENT_COMMENTS + "{map_id}")
    void postComment(@Path("post_id") long postId, @Path("map_id") long mapId,
            @Field("comment") String comment,
            @Field("session") String sessionToken, ApiCallback<Comments> callback);

    @DELETE(SEGMENT_POSTS + "{post_id}" + SEGMENT_COMMENTS + "{comment_id}")
    void deletePostComments(@Path("post_id") long postId, @Path("comment_id") long commentId,
            @Query("session") String sessionToken, ApiCallback<Comments> callback);

    @DELETE(SEGMENT_POSTS + "{post_id}" + SEGMENT_MAPS)
    void deletePostFromMap(@Path("post_id") long postId, @Query("session") String sessionToken,
            ApiCallback<Posts> callback);

    @POST(SEGMENT_POSTS + "{post_id}" + SEGMENT_MAPS)
    void createPostMap(@Path("post_id") long postId, @Field("session") String sessionToken,
            ApiCallback<Posts> callback);
}
