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

package com.crowdmap.java.sdk.model;

import java.io.Serializable;

/**
 * Notification class. Notifications in Crowdmap are a very simple type of inbox intended to inform
 * a user of actions that have taken place, like new followers or a comment passed on a post.
 */
public class Notification implements Serializable {

    private static final long serialVersionUID = 4336532175324391627L;

    private long id;

    private long senderId;

    private String message;

    private boolean unread;

    private String callbackUrl;

    private long created;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", message='" + message + '\'' +
                ", unread=" + unread +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", created=" + created +
                '}';
    }
}
