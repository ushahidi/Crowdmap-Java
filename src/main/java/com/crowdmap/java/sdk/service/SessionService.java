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

import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.LoginForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_LOGIN;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_SESSION;

/**
 * Login service
 */
public class SessionService extends CrowdmapService {

    public SessionService() {
    }

    /**
     * Login a user. POST /session/login
     *
     * @param form The login form.
     * @return {@link com.crowdmap.java.sdk.json.Session}
     */
    public Session login(LoginForm form) {

        // Build the URL for the login endpoint
        StringBuilder url = new StringBuilder(SEGMENT_SESSION);
        url.append(SEGMENT_LOGIN);

        setApiKey(METHOD_POST, url.toString());
        // Send a post request to login
        return fromString(client.multipartPost(url.toString(), form.getParameters()),
                Session.class);
    }
}
