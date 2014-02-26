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
import com.crowdmap.java.sdk.model.form.CommentForm;
import com.crowdmap.java.sdk.model.form.PostForm;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
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
            TypedFile media, @Part("session") TypedString sessionToken,
            ApiCallback<Posts> callback);

    @DELETE(SEGMENT_POSTS + "{post_id}")
    void deletePost(@Path("post_id") long postId, @Query("session") String sessionToken,
            ApiCallback<Response> callback);

    public Posts updatePost(long postId, PostForm form) {
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        //setApiKey(METHOD_PUT, url.toString());
        //return fromString(client.put(url.toString(), form.getParameters()), Posts.class);
        return null;
    }

    /**
     * Get tags attached to a post
     *
     * @param tag The name of the tag. This can be CSV
     * @return The tags attached to a post
     */
    public PostTags getPostTag(String tag) {
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(SEGMENT_TAGS);
        url.append(tag);
        url.append("/");
        //setApiKey(METHOD_PUT, url.toString());
        //return fromString(client.get(url.toString()), PostTags.class);
        return null;
    }

    /**
     * Like a particular post
     *
     * @param postId The post to like
     * @return The liked posts.
     */
    public Posts likePost(long postId) {
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_LIKE);
        //setApiKey(METHOD_POST, url.toString());
        //return fromString(client.post(url.toString()), Posts.class);
        return null;
    }

    /**
     * Un-like a particular post
     *
     * @param postId The post to un-like
     * @return The un-liked posts
     */
    public Posts unLikePost(long postId) {
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_LIKE);
        //setApiKey(METHOD_DELETE, url.toString());
        //return fromString(client.delete(url.toString()), Posts.class);
        return null;
    }

    /**
     * Get the comments on a post from the context of a map the post is featured on. GET
     * /posts/:post_id/comments/:map_id
     *
     * @param postId The Post ID
     * @param mapId  The map ID
     * @return The {@link com.crowdmap.java.sdk.json.Comments} response of the specific post
     */
    public Comments getPostComments(long postId, long mapId) {
        checkId(postId);
        checkId(mapId);
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_COMMENTS);
        url.append(mapId);

        return null;
    }

    /**
     * Add a comment on a post.
     *
     * @param postId The ID of the post to add the comment to.
     * @param mapId  The map ID
     * @param form   The comment form
     * @return The posted comment
     */
    public Comments postComment(long postId, long mapId, CommentForm form) {
        checkId(postId);
        checkId(mapId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_COMMENTS);
        url.append(mapId);
        url.append("/");
        return null;
    }

    public Comments deletePostComments(long postId, long commentId) {
        checkId(postId);
        checkId(commentId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_COMMENTS);
        url.append(commentId);
        url.append("/");
        return null;
    }

    /**
     * Delete a post from a map
     *
     * @param postId The ID of the post to be deleted.
     * @return Post minus the deleted post
     */
    public Posts deletePostFromMap(long postId) {
        checkId(postId);
        // validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_MAPS);
        return null;
    }

    /**
     * Add an existing post to a map
     *
     * @return Post
     */
    public Posts createPostMap(long postId) {
        checkId(postId);
        //validateSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_MAPS);

        return null;
    }

}
