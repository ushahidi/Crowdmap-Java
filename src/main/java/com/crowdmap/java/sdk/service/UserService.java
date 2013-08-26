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

import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Users;
import com.crowdmap.java.sdk.model.User;
import com.crowdmap.java.sdk.net.content.Body;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_PUT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAPS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POSTS;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_USERS;

/**
 * User service
 */
public class UserService extends CrowdmapService {

    public Users getUsers() {

        // Send a post request to login
        setApiKey(METHOD_GET, SEGMENT_USERS);
        String json = client.get(SEGMENT_USERS);
        return fromString(json,
                Users.class);
    }

    public Posts getUsersPosts(int userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_POSTS);
        setApiKey(METHOD_GET, SEGMENT_USERS);
        return fromString(client.get(url.toString()), Posts.class);
    }

    public User updateUser(int userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);

        // Do body content
        Body body = new Body();
        setApiKey(METHOD_PUT, SEGMENT_USERS);
        return fromString(client.put(url.toString(), body), User.class);
    }
}
