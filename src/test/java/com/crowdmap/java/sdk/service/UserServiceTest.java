/*******************************************************************************
 ** Copyright (c) 2010 - 2013 Ushahidi Inc
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
 ******************************************************************************/

package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by eyedol on 8/17/13.
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



}
