package com.crowdmap.java.sdk.model.form;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Post tag
 */
public class PostTag  implements Serializable {

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
