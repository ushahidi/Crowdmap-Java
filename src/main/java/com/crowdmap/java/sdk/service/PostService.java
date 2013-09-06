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
import com.crowdmap.java.sdk.model.form.CommentForm;
import com.crowdmap.java.sdk.model.form.PostForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LIKE;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_TAGS;

/**
 * Service for interacting with Crowdmap post API
 */
public class PostService extends CrowdmapService {

    /**
     * Get all posts across crowdmap - GET /posts
     */
    public Posts getPosts() {
        setApiKey(METHOD_GET, SEGMENT_POSTS);
        String json = client.get(SEGMENT_POSTS);
        return fromString(json,Posts.class);
    }

    /**
     * Get posts based on the post ID and a segment of the URL passed to it
     *
     * @param postId  The ID of the post
     * @param segment The URL segment
     * @return The Object related to the JSON response
     */
    private <T> T get(long postId, String segment, Class<T> cls) {

        checkId(postId);
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        // Add the segment
        if (segment != null && segment.length() > 0) {
            url.append(segment);
        }
        setApiKey(METHOD_GET, url.toString());
        final String json = client.get(url.toString());
        return fromString(json, cls);
    }

    /**
     * Get a specific post. GET /posts/:post_id
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Posts} response of the specific post
     */
    public Posts getPosts(long postId) {

        return get(postId, null, Posts.class);
    }

    /**
     * Get all of the maps a specific post is featured on. GET /posts/:post_id/maps
     *
     * @param postId The post ID
     * @return The {@link com.crowdmap.java.sdk.json.Maps} response for the specific post
     */
    public Maps getPostMaps(long postId) {

        return get(postId, SEGMENT_MAPS, Maps.class);
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
        return get(postId, SEGMENT_COMMENTS, Comments.class);
    }

    /**
     * Create a new post as an authenticated user.
     *
     * @param form The post fields to submitted.
     * @return The post created
     */
    public Posts createPost(PostForm form) {
        initSession();
        setApiKey(METHOD_POST, SEGMENT_POSTS);
        return fromString(client.post(SEGMENT_POSTS, form.getParameters()), Posts.class);
    }

    public Response deletePost(long postId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()), Response.class);
    }

    /**
     * Update an existing post
     *
     * @param postId The ID of the post to be updated
     * @param form   The post fields
     * @return The post updated
     */
    public Posts updatePost(long postId, PostForm form) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.put(url.toString(), form.getParameters()), Posts.class);
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
        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.get(url.toString()), PostTags.class);
    }

    /**
     * Like a particular post
     *
     * @param postId The post to like
     * @return The liked posts.
     */
    public Posts likePost(long postId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_LIKE);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()), Posts.class);
    }

    /**
     * Un-like a particular post
     *
     * @param postId The post to un-like
     * @return The un-liked posts
     */
    public Posts unLikePost(long postId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_LIKE);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()), Posts.class);
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

        return fromString(client.get(url.toString()),
                Comments.class);
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
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_COMMENTS);
        url.append(mapId);
        url.append("/");
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()), Comments.class);
    }

    public Comments deletePostComments(long postId, long commentId) {
        checkId(postId);
        checkId(commentId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_COMMENTS);
        url.append(commentId);
        url.append("/");
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()),
                Comments.class);
    }

    /**
     * Delete a post from a map
     *
     * @param postId The ID of the post to be deleted.
     * @return Post minus the deleted post
     */
    public Posts deletePostFromMap(long postId) {
        checkId(postId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_MAPS);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()),
                Posts.class);
    }

    /**
     * Add an existing post to a map
     *
     * @return Post
     */
    public Posts createPostMap(long postId) {
        checkId(postId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append(SEGMENT_MAPS);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()),
                Posts.class);
    }
}
