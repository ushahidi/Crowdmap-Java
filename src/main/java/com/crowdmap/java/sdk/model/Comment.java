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

import com.google.gson.annotations.SerializedName;

import com.crowdmap.java.sdk.json.Date;

import java.io.Serializable;

/**
 * Comment model class
 */
public class Comment implements Serializable {

    /**
     * Serialized version number
     */
    private static final long serialVersionUID = -7021417619206532086L;

    @SerializedName("comment_id")
    private int Id;

    private int postId;

    private int mapId;

    private int userId;

    private String comment;

    private Date datePosted;

    private User users;

    private Permission permissions;

    private Map map;

    /**
     * @return the users
     */
    public User getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     * @return the permissions
     */
    public Permission getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * @return the commentId
     */
    public int getId() {
        return Id;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setId(int commentId) {
        this.Id = commentId;
    }

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
     * @return the mapId
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @param mapId the mapId to set
     */
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the datePosted
     */
    public Date getDatePosted() {
        return datePosted;
    }

    /**
     * @param datePosted the datePosted to set
     */
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", postId=" + postId +
                ", mapId=" + mapId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", datePosted=" + datePosted +
                ", users=" + users +
                ", permissions=" + permissions +
                ", map=" + map +
                '}';
    }
}
