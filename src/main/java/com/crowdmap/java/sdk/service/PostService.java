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
    public Posts getPosts() {
        return mPostInterface.getPosts(limit, offset);
    }


    /**
     * Get a specific post. GET /posts/:post_id
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Posts} response of the specific post
     */
    public Posts getPosts(long postId) {
        checkId(postId);
        return mPostInterface.getPosts(postId,limit, offset);
    }

    /**
     * Get all of the maps a specific post is featured on. GET /posts/:post_id/maps
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Maps} response for the specific post
     */
    public Maps getPostMaps(long postId) {
        checkId(postId);
        return mPostInterface.getPostMaps(postId,limit, offset);
    }

    /**
     * Gell all the comments associated with a specific post.
     *
     * GET /posts/:post_id/comments/
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Comments} response of the specific post
     */
    public Comments getPostComments(long postId) {
        checkId(postId);
        return mPostInterface.getPostComments(postId,limit, offset);
    }

    /**
     * Create a new post as an authenticated user.
     *
     * @param message The post fields to submitted.
     * @return The post created
     */
    //TODO: improve the paramter. Use MapForm field instead
    public Posts createPost(TypedString message,
            TypedString isPublic, TypedString locationName, TypedString lat, TypedString lon,
            TypedString geometry, TypedString fsqVenueId,

            TypedString mapId,

            TypedString tweet,

            TypedString externalUrl,

            TypedFile media,
            TypedString sessionToken) {
        return mPostInterface
                .createPost(message, isPublic, locationName, lat, lon, geometry, fsqVenueId, mapId,
                        tweet, externalUrl, media, sessionToken);
    }

    public Response deletePost(long postId, String sessionToken) {
        checkId(postId);
        return mPostInterface.deletePost(postId, sessionToken);
    }

    /**
     * Update an existing post
     *
     * @param postId  The ID of the post to be updated
     * @param message The post fields
     * @return The post updated
     */
    public Posts updatePost(long postId, TypedString message,
            TypedString isPublic, TypedString locationName, TypedString lat, TypedString lon,
            TypedString geometry, TypedString fsqVenueId,

            TypedString mapId,

            TypedString tweet,

            TypedString externalUrl,

            TypedFile media,
            TypedString sessionToken) {
        return mPostInterface
                .updatePost(postId, message, isPublic, locationName, lat, lon, geometry, fsqVenueId,
                        mapId, tweet, externalUrl, media, sessionToken);
    }

    /**
     * Get tags attached to a post
     *
     * @param tag The name of the tag. This can be CSV
     * @return The tags attached to a post
     */
    public PostTags getPostTag(String tag) {
        return mPostInterface.getPostTag(tag,limit, offset);
    }

    /**
     * Like a particular post
     *
     * @param postId The post to like
     * @return The liked posts.
     */
    public Posts likePost(long postId, String sessionToken) {
        checkId(postId);
        return mPostInterface.likePost(postId, sessionToken);
    }

    /**
     * Un-like a particular post
     *
     * @param postId The post to un-like
     * @return The un-liked posts
     */
    public Posts unLikePost(long postId, String sessionToken) {
        return mPostInterface.unLikePost(postId, sessionToken);
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
        return mPostInterface.getPostComments(postId, mapId,limit, offset);
    }

    /**
     * Add a comment on a post.
     *
     * @param postId  The ID of the post to add the comment to.
     * @param mapId   The map ID
     * @param comment The comment form
     * @return The posted comment
     */
    public Comments postComment(long postId, long mapId, String comment, String sessionToken) {
        checkId(postId);
        checkId(mapId);
        return mPostInterface.postComment(postId, mapId, comment, sessionToken);
    }

    public Comments deletePostComments(long postId, long commentId, String sessionToken) {
        checkId(postId);
        checkId(commentId);
        return mPostInterface.deletePostComments(postId, commentId, sessionToken);
    }

    /**
     * Delete a post from a map
     *
     * @param postId The ID of the post to be deleted.
     * @return Post minus the deleted post
     */
    public Posts deletePostFromMap(long postId, String sessionToken) {
        checkId(postId);
        return mPostInterface.deletePostFromMap(postId, sessionToken);
    }

    /**
     * Add an existing post to a map
     *
     * @return Post
     */
    public Posts createPostMap(long postId, String sessionToken) {
        checkId(postId);
        return mPostInterface.createPostMap(postId, sessionToken);
    }
}
