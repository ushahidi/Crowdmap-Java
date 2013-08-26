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
import com.crowdmap.java.sdk.model.UserForm;
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

    /**
     * Get users registered on Crowdmap
     *
     * @return Users detail
     */
    public Users getUsers() {

        //Send a post request to login
        setApiKey(METHOD_GET, SEGMENT_USERS);
        String json = client.get(SEGMENT_USERS);
        return fromString(json,
                Users.class);
    }

    /**
     * Get Posts a particular user has created
     *
     * @param userId The user's ID
     *
     * @return Posts the user has created
     */
    public Posts getUsersPosts(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);
        url.append(SEGMENT_POSTS);
        setApiKey(METHOD_GET, url.toString());
        return fromString(client.get(url.toString()), Posts.class);
    }

    /**
     * Update details of a particular user
     *
     * @param userId The user's ID
     * @param userFrom User fields;
     * @return
     */
    public User updateUser(int userId, UserForm userFrom) {
        StringBuilder url = new StringBuilder(SEGMENT_USERS);
        url.append(userId);

        setApiKey(METHOD_PUT, url.toString());
        return fromString(client.put(url.toString(), userFrom.getParameters()), User.class);
    }
}
