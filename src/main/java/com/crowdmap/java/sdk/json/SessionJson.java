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

import java.io.Serializable;

/**
 * Session JSON response
 */
public class SessionJson extends ResponseJson implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 4355738142694543892L;

	private String userId;

	private String sessionId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Get the login user's session ID
	 * 
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Set the login user's session ID
	 * 
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {

		return "SessionJson [userId:" + userId + ", sessionId:" + sessionId
				+ ", success:" + success + ", status:" + status + ", error:"
				+ error + ", timestamp:" + timestamp + ", qcount:" + qcount
				+ "]";
	}
}
