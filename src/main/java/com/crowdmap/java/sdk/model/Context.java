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

package com.crowdmap.java.sdk.model;

import java.io.Serializable;

/**
 * Context model class
 */
public class Context implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 1579356097608997292L;

    private int postId;

    private int madId;

    private String iconId;

    private String context;

    private int approved;

    /**
     * @return the postId
     */
    public int getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * @return the madId
     */
    public int getMadId() {
        return madId;
    }

    /**
     * @param madId the madId to set
     */
    public void setMadId(int madId) {
        this.madId = madId;
    }

    /**
     * @return the iconId
     */
    public String getIconId() {
        return iconId;
    }

    /**
     * @param iconId the iconId to set
     */
    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * @return the approved
     */
    public int getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(int approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Context{" +
                "postId=" + postId +
                ", madId=" + madId +
                ", iconId='" + iconId + '\'' +
                ", context='" + context + '\'' +
                ", approved=" + approved +
                '}';
    }
}
