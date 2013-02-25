/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 *****************************************************************************/
package com.crowdmap.java.sdk.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crowdmap.java.sdk.json.CommentsJson;
import com.crowdmap.java.sdk.json.MapsJson;
import com.crowdmap.java.sdk.json.PostsJson;

/**
 * Posts Service Test case
 */
public class PostsServiceTest extends BaseServiceTest {

	private PostsService postsService;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		postsService = new PostsService(client);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		postsService = null;
	}

	/**
	 * Test method for
	 * {@link com.crowdmap.java.sdk.service.PostsService#getPosts()}.
	 */
	@Test
	public void testGetPosts() {

		PostsJson postsJson = postsService.getPosts();

		assertNotNull("Post cannot be null ", postsJson.posts);

	}

	@Test
	public void testGetPostMaps() {
		MapsJson mapsJson = postsService.getPostMaps(String.valueOf(1));
		assertNotNull("Maps cannot be null", mapsJson);
	}

	@Test
	public void testGetPostComments() {
		// TODO check for nulls
		CommentsJson commentsJson = postsService.getPostComments(String
				.valueOf(1));
	}

	@Test
	public void getPostComments() {
		// TODO check for nulls
		CommentsJson commentsJson = postsService.getPostComments(
				String.valueOf(1), String.valueOf(1));
	}

}
