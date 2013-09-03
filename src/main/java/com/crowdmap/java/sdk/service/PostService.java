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
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.model.form.PostForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
/**
 * Service for interacting with Crowdmap post API
 */
public class PostService extends CrowdmapService {

    /**
     * Get all posts across crowdmap - GET /posts
     */
    public Posts getPosts() {
        setApiKey(METHOD_GET,SEGMENT_POSTS );
        return fromString(client.get(SEGMENT_POSTS),
                Posts.class);
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
        url.append("/");
        url.append(postId);
        url.append("/");
        // Add the segment
        if (segment != null && segment.length() > 0) {
            url.append(segment);
        }

        return fromString(client.get(url.toString()), cls);
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
        return fromString(client.post(SEGMENT_POSTS, form.getParameters()),Posts.class);
    }

    public Response deletePost(long postId) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()),Response.class);
    }

    /**
     * Update an existing post
     *
     * @param postId The ID of the post to be updated
     * @param form The post fields
     * @return The post updated
     */
    public Posts updatePost(long postId, PostForm form) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(postId);
        url.append("/");
        setApiKey(METHOD_PUT,url.toString() );
        return fromString(client.put(url.toString(), form.getParameters()),Posts.class);
    }

    /**
     * Get the comments on a post from the context of a map the post is featured on. GET
     * /posts/:post_id/comments/:map_id
     *
     * @param id    The Post ID
     * @param mapId The map ID
     * @return The {@link com.crowdmap.java.sdk.json.Comments} response of the specific post
     */
    public Comments getPostComments(long id, String mapId) {
        checkId(id);
        StringBuilder url = new StringBuilder(SEGMENT_POSTS);
        url.append(id);
        url.append(SEGMENT_COMMENTS);
        url.append(mapId);

        return fromString(client.get(url.toString()),
                Comments.class);
    }

}
