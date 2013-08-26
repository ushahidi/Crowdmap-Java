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
import com.crowdmap.java.sdk.json.Externals;

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

    private List<Externals> externals;

    private List<Location> locations;

    private List<Media> media;

    private List<Map> maps;

    private long postId;

    private List<User> users;

    private long mediaId;

    private long locationId;

    private long externalId;

    private long externalsImagesId;

    private String message;

    private Date datePosted;

    @SerializedName("public")
    private boolean isPublic;

    private String userIp;

    private Permission permissions;

    private String stub;

    private List<Tag> tags;

    private List<Comment> comments;

    //TODO:: add likes field

    public List<Externals> getExternals() {
        return externals;
    }

    public void setExternals(List<Externals> externals) {
        this.externals = externals;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public long getExternalsImagesId() {
        return externalsImagesId;
    }

    public void setExternalsImagesId(long externalsImagesId) {
        this.externalsImagesId = externalsImagesId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    public String getStub() {
        return stub;
    }

    public void setStub(String stub) {
        this.stub = stub;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "externals=" + externals +
                ", locations=" + locations +
                ", media=" + media +
                ", maps=" + maps +
                ", postId=" + postId +
                ", users=" + users +
                ", mediaId=" + mediaId +
                ", locationId=" + locationId +
                ", externalId=" + externalId +
                ", externalsImagesId=" + externalsImagesId +
                ", message='" + message + '\'' +
                ", datePosted=" + datePosted +
                ", isPublic=" + isPublic +
                ", userIp='" + userIp + '\'' +
                ", permissions=" + permissions +
                ", stub='" + stub + '\'' +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }
}
