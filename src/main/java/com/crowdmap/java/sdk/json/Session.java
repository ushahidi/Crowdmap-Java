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
package com.crowdmap.java.sdk.json;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Session JSON response
 */
public class Session extends Response implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 4355738142694543892L;

    /**
     * User's ID
     */
    private String userId;

    /**
     * The session token
     */
    private String session;

    /**
     * Determine whether is a crowdmap ID or not
     */
    @SerializedName("cmid")
    private boolean cmId;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get the login user's session token
     *
     * @return the sessionId
     */
    public String getSessionToken() {
        return session;
    }

    /**
     * Set the login user's session ID
     *
     * @param session the sessionId to set
     */
    public void setSessionToken(String session) {
        this.session = session;
    }

    public void setCmId(boolean cmId) {
        this.cmId = cmId;
    }

    public boolean getCmId() {
        return this.cmId;
    }

    @Override
    public String toString() {

        return "Session [userId:" + userId + ", session:" + session + ", cmid:" + cmId
                + ", success:" + success + ", status:" + status + ", error:"
                + error + ", timestamp:" + timestamp + ", qcount:" + qcount
                + "]";
    }
}
