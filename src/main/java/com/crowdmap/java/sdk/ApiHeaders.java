/*******************************************************************************
 * Copyright (c) 2010 - 2014 Ushahidi Inc.
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

package com.crowdmap.java.sdk;

import com.crowdmap.java.sdk.util.ValidateUtil;

import retrofit.RequestInterceptor;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.USER_AGENT;

/**
 * HTTP Headers
 */
public final class ApiHeaders implements RequestInterceptor {

    /**
     * The user agent to use
     */
    private String userAgent = USER_AGENT;

    public ApiHeaders() {
        this(null);
    }

    public ApiHeaders(String agent) {
        if (!ValidateUtil.empty(agent)) {
            userAgent = agent;
        }
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("User-Agent", getUserAgent());
    }


    public void setUserAgent(String agent) {

    }

    public String getUserAgent() {
        return userAgent;
    }
}
