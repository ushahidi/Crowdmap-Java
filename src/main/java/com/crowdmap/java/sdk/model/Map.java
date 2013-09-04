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

import com.google.gson.annotations.SerializedName;

import com.crowdmap.java.sdk.json.Date;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Map Model class
 */
public class Map implements Serializable {

    /**
     * Seriala version UID
     */
    private static final long serialVersionUID = 5567922863749709665L;

    private Boolean approve;

    /**
     * The ID of the map.
     */
    @SerializedName("map_id")
    private int id;

    /**
     * The ID of the user
     */
    @SerializedName("user_id")
    private int userId;

    private List<User> users;

    private String subdomain;

    private String name;

    private String description;

    private String banner;

    private String avatar;

    @SerializedName("public")
    private Boolean isPublic;

    private String moderation;

    private Boolean marker;

    private String[] association;

    private int followers;

    private int posts;


    /**
     * The date the map was created
     */
    @SerializedName("date_created")
    private Date dateCreated;

    private Geometry center;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getModeration() {
        return moderation;
    }

    public void setModeration(String moderation) {
        this.moderation = moderation;
    }

    public Boolean getMarker() {
        return marker;
    }

    public void setMarker(Boolean marker) {
        this.marker = marker;
    }

    public String[] getAssociation() {
        return association;
    }

    public void setAssociation(String[] association) {
        this.association = association;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Geometry getCenter() {
        return center;
    }

    public void setCenter(Geometry center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "Map{" +
                "approve=" + approve +
                ", id=" + id +
                ", userId=" + userId +
                ", users=" + users +
                ", subdomain='" + subdomain + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", banner='" + banner + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isPublic=" + isPublic +
                ", moderation='" + moderation + '\'' +
                ", marker=" + marker +
                ", association=" + Arrays.toString(association) +
                ", followers=" + followers +
                ", posts=" + posts +
                ", dateCreated=" + dateCreated +
                ", center=" + center +
                '}';
    }
}
