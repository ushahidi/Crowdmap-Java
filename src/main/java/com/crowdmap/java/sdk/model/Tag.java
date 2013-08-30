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

import java.util.Arrays;

/**
 * Tag
 */
public class Tag {

    private String tag;

    private int usersCount;

    private int mapsCount;

    private int[] users;

    private int[] maps;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getMapsCount() {
        return mapsCount;
    }

    public void setMapsCount(int mapsCount) {
        this.mapsCount = mapsCount;
    }

    public int[] getUsers() {
        return users;
    }

    public void setUsers(int[] users) {
        this.users = users;
    }

    public int[] getMaps() {
        return maps;
    }

    public void setMaps(int[] maps) {
        this.maps = maps;
    }


    @Override
    public String toString() {
        return "Tag{" +
                "tag='" + tag + '\'' +
                ", usersCount=" + usersCount +
                ", mapsCount=" + mapsCount +
                ", users=" + Arrays.toString(users) +
                ", maps=" + Arrays.toString(maps) +
                '}';
    }
}
