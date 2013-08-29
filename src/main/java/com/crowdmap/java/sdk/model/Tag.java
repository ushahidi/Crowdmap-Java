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
