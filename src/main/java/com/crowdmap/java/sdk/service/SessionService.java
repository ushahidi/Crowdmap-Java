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

import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.SessionInterface;

import retrofit.RestAdapter;

/**
 * Login service
 */
public class SessionService extends CrowdmapService<SessionService> {

    private SessionInterface mSessionInterface;

    public SessionService(RestAdapter restAdapter) {
        super(restAdapter);
        mSessionInterface = restAdapter.create(SessionInterface.class);
    }

    /**
     * Login a user. POST /session/login
     *
     * @return {@link com.crowdmap.java.sdk.json.Session}
     */
    public Session login(String username, String password) {
        return mSessionInterface.login(username, password);
    }

}
