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
import java.util.List;

/**
 * Post modle class
 */
public class Post implements Serializable {

    /**
     * Seria version UID
     */
    private static final long serialVersionUID = -396616833938909039L;

    private External externals;

    private Location locations;

    private List<Image> media;

    private int postId;

    private int mediaId;

    private int locationId;

    private int externalId;

    private String message;

    private Date datePosted;

    @SerializedName("public")
    private int isPublic;

    private String userIp;

    private User users;

    private Permission permissions;

    private List<Context> contexts;

    /**
     * @return the externals
     */
    public External getExternals() {
        return externals;
    }

    /**
     * @param externals the externals to set
     */
    public void setExternals(External externals) {
        this.externals = externals;
    }

    /**
     * @return the locations
     */
    public Location getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Location locations) {
        this.locations = locations;
    }

    /**
     * @return the media
     */
    public List<Image> getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(List<Image> media) {
        this.media = media;
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
     * @return the mediaId
     */
    public int getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId the mediaId to set
     */
    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the externalId
     */
    public int getExternalId() {
        return externalId;
    }

    /**
     * @param externalId the externalId to set
     */
    public void setExternalId(int externalId) {
        this.externalId = externalId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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

    /**
     * @return the isPublic
     */
    public int getIsPublic() {
        return isPublic;
    }

    /**
     * @param isPublic the isPublic to set
     */
    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the userIp
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * @param userIp the userIp to set
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

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
     * @return the contexts
     */
    public List<Context> getContexts() {
        return contexts;
    }

    /**
     * @param contexts the contexts to set
     */
    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

}
