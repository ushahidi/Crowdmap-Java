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

import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.json.Users;
import com.crowdmap.java.sdk.model.LoginForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserService test cases
 */
public class UserServiceTest extends BaseServiceTest {

    UserService userService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userService = crowdmap.userService();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        userService = null;
    }

    @Test
    public void testGetUsers() throws Exception{
        Users user = userService.getUsers();
        assertNotNull(user);
        assertNotNullOrEmpty("Shouldn't be empty", user.getUsers());
    }

    @Test
    public void testGetUsersPosts() throws Exception {
        Posts posts = userService.getUsersPosts(3);
        assertNotNull(posts);
        assertNotNullOrEmpty("Post is empty", posts.getPosts());
    }

    @Test
    public void testUpdateUser() throws Exception {
        //TODO: write test code for updating existing user
    }

    @Test
    public void testGetUser() throws Exception {
        Users user = userService.getUser(23);
        assertNotNull(user);
        assertNotNullOrEmpty("User details is empty", user.getUsers());
    }

    @Test
    public void testGetUsersFollowedBy() throws  Exception {
        Users users = userService.getUsersFollowedBy(23);
        assertNotNull(users);
        assertNotNullOrEmpty("No followers",users.getUsers());
    }

    @Test
    public void testVerifyUsersFollowing() throws Exception {
        Users users = userService.verifyUsersFollowing(23, 2);
        assertNotNull(users);
        assertNotNullOrEmpty("Not following",users.getUsers());
    }

    @Test
    public void testGetUsersFollowers() throws Exception {
        Users users = userService.getUsersFollowers(23);
        assertNotNull(users);
        assertNotNullOrEmpty("No users to follow", users.getUsers());
    }

    @Test
    public void testFollowUser() throws Exception {
        session = loginService.login(loginForm);
        userService.setSessionToken(session.getSessionToken());
        Users users = userService.followUser(2);
        assertNotNull(users);
    }

    @Test
    public void testGetNotification() throws Exception {

        session = loginService.login(loginForm);
        userService.setSessionToken(session.getSessionToken());

        //Maps maps = userService.getNotifications(23);
        //assertNotNull(maps);
    }

    @Test
    public void testGetUsersAssociatedMaps() throws Exception {
        session = loginService.login(loginForm);
        userService.setSessionToken(session.getSessionToken());

        Maps maps = userService.getUsersAssociatedMaps(23);
        assertNotNull(maps);
    }
}
