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

import com.crowdmap.java.sdk.json.Posts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test post
 */
public class PostServiceTest extends BaseServiceTest {

    PostService mPostService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mPostService = crowdmap.postService();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testGetPosts() throws Exception {
        Posts posts = mPostService.getPosts();
        assertNotNull(posts);
    }

    @Test
    public void testGetPostMaps() throws Exception {

    }

    @Test
    public void testGetPostComments() throws Exception {

    }

    @Test
    public void testCreatePost() throws Exception {

    }

    @Test
    public void testDeletePost() throws Exception {

    }

    @Test
    public void testUpdatePost() throws Exception {

    }

    @Test
    public void testGetPostTag() throws Exception {

    }

    @Test
    public void testLikePost() throws Exception {

    }

    @Test
    public void testUnLikePost() throws Exception {

    }

    @Test
    public void testGetPostComments1() throws Exception {

    }

    @Test
    public void testPostComment() throws Exception {

    }

    @Test
    public void testDeletePostComments() throws Exception {

    }

    @Test
    public void testDeletePostFromMap() throws Exception {

    }

    @Test
    public void testCreatePostMap() throws Exception {

    }
}
