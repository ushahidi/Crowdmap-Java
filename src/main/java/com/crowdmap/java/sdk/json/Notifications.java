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

package com.crowdmap.java.sdk.json;

import com.crowdmap.java.sdk.model.Notification;

import java.io.Serializable;
import java.util.List;

/**
 * List
 */
public class Notifications extends Response implements Serializable {

    private static final long serialVersionUID = 2829203893532337914L;

    private int count;

    private int unread;

    private List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "count=" + count +
                ", unread=" + unread +
                ", notifications=" + notifications +
                '}';
    }
}
