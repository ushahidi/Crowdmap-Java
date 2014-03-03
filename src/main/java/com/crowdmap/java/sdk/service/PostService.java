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

import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.PostTags;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.PostInterface;

import retrofit.RestAdapter;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * Service for interacting with Crowdmap post API
 */
public class PostService extends CrowdmapService<PostService> {

    PostInterface mPostInterface;

    public PostService(RestAdapter restAdapter) {
        super(restAdapter);
        mPostInterface = restAdapter.create(PostInterface.class);
    }

    /**
     * Get all posts across crowdmap - GET /posts
     */
    public void getPosts(ApiCallback<Posts> callback) {
        mPostInterface.getPosts(callback);
    }


    /**
     * Get a specific post. GET /posts/:post_id
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Posts} response of the specific post
     */
    public void getPosts(long postId, ApiCallback<Posts> callback) {
        checkId(postId);
        mPostInterface.getPosts(postId, callback);
    }

    /**
     * Get all of the maps a specific post is featured on. GET /posts/:post_id/maps
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Maps} response for the specific post
     */
    public void getPostMaps(long postId, ApiCallback<Maps> callback) {
        checkId(postId);
        mPostInterface.getPostMaps(postId, callback);
    }

    /**
     * Gell all the comments associated with a specific post.
     *
     * GET /posts/:post_id/comments/
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Comments} response of the specific post
     */
    public void getPostComments(long postId, ApiCallback<Comments> callback) {
        checkId(postId);
        mPostInterface.getPostComments(postId, callback);
    }

    /**
     * Create a new post as an authenticated user.
     *
     * @param message The post fields to submitted.
     * @return The post created
     */
    //TODO: improve the paramter. Use MapForm field instead
    public void createPost(TypedString message,
            TypedString isPublic, TypedString locationName, TypedString lat, TypedString lon,
            TypedString geometry, TypedString fsqVenueId,

            TypedString mapId,

            TypedString tweet,

            TypedString externalUrl,

            TypedFile media,
            TypedString sessionToken,
            ApiCallback<Posts> callback) {
        mPostInterface
                .createPost(message, isPublic, locationName, lat, lon, geometry, fsqVenueId, mapId,
                        tweet, externalUrl, media, sessionToken, callback);
    }

    public void deletePost(long postId, String sessionToken, ApiCallback<Response> callback) {
        checkId(postId);
        mPostInterface.deletePost(postId, sessionToken, callback);
    }

    /**
     * Update an existing post
     *
     * @param postId  The ID of the post to be updated
     * @param message The post fields
     * @return The post updated
     */
    public void updatePost(long postId, TypedString message,
            TypedString isPublic, TypedString locationName, TypedString lat, TypedString lon,
            TypedString geometry, TypedString fsqVenueId,

            TypedString mapId,

            TypedString tweet,

            TypedString externalUrl,

            TypedFile media,
            TypedString sessionToken,
            ApiCallback<Posts> callback) {
        mPostInterface
                .updatePost(postId, message, isPublic, locationName, lat, lon, geometry, fsqVenueId,
                        mapId, tweet, externalUrl, media, sessionToken, callback);
    }

    /**
     * Get tags attached to a post
     *
     * @param tag The name of the tag. This can be CSV
     * @return The tags attached to a post
     */
    public void getPostTag(String tag, ApiCallback<PostTags> callback) {
        mPostInterface.getPostTag(tag, callback);
    }

    /**
     * Like a particular post
     *
     * @param postId The post to like
     * @return The liked posts.
     */
    public void likePost(long postId, String sessionToken, ApiCallback<Posts> callback) {
        checkId(postId);
        mPostInterface.likePost(postId, sessionToken, callback);
    }

    /**
     * Un-like a particular post
     *
     * @param postId The post to un-like
     * @return The un-liked posts
     */
    public void unLikePost(long postId, String sessionToken, ApiCallback<Posts> callback) {
        mPostInterface.unLikePost(postId, sessionToken, callback);
    }

    /**
     * Get the comments on a post from the context of a map the post is featured on. GET
     * /posts/:post_id/comments/:map_id
     *
     * @param postId The Post ID
     * @param mapId  The map ID
     * @return The {@link com.crowdmap.java.sdk.json.Comments} response of the specific post
     */
    public void getPostComments(long postId, long mapId, ApiCallback<Comments> callback) {
        checkId(postId);
        checkId(mapId);
        mPostInterface.getPostComments(postId, mapId, callback);
    }

    /**
     * Add a comment on a post.
     *
     * @param postId  The ID of the post to add the comment to.
     * @param mapId   The map ID
     * @param comment The comment form
     * @return The posted comment
     */
    public void postComment(long postId, long mapId, String comment, String sessionToken,
            ApiCallback<Comments> callback) {
        checkId(postId);
        checkId(mapId);
        mPostInterface.postComment(postId, mapId, comment, sessionToken, callback);
    }

    public void deletePostComments(long postId, long commentId, String sessionToken,
            ApiCallback<Comments> callback) {
        checkId(postId);
        checkId(commentId);
        mPostInterface.deletePostComments(postId, commentId, sessionToken, callback);
    }

    /**
     * Delete a post from a map
     *
     * @param postId The ID of the post to be deleted.
     * @return Post minus the deleted post
     */
    public void deletePostFromMap(long postId, String sessionToken, ApiCallback<Posts> callback) {
        checkId(postId);
        mPostInterface.deletePostFromMap(postId, sessionToken, callback);
    }

    /**
     * Add an existing post to a map
     *
     * @return Post
     */
    public void createPostMap(long postId, String sessionToken, ApiCallback<Posts> callback) {
        checkId(postId);
        mPostInterface.createPostMap(postId, sessionToken, callback);
    }
}
