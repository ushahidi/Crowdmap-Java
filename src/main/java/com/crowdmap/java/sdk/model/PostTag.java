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

package com.crowdmap.java.sdk.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Post Tag
 */
public class PostTag implements Serializable {

    private static final long serialVersionUID = 5523825368925745125L;

    private String tag;

    private String color;

    private int usersCount;

    private int postsCount;

    private int[] users;

    private int[] posts;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public int[] getUsers() {
        return users;
    }

    public void setUsers(int[] users) {
        this.users = users;
    }

    public int[] getPosts() {
        return posts;
    }

    public void setPosts(int[] posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", usersCount=" + usersCount +
                ", postsCount=" + postsCount +
                ", users=" + Arrays.toString(users) +
                ", posts=" + Arrays.toString(posts) +
                '}';
    }

}
