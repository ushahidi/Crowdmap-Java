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
 *
 */
public class User implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 2131057553316089514L;

    /**
     * The person ID
     */
    @SerializedName("user_id")
    private long id;

    private String crowdmapId;

    /**
     * The ID used to identify each Crowdmap user in Ushahidi's global authentication system
     * called CrowdmapID
     */
    private String crowdmapIdH;


    /**
     * The person's username
     */
    private String username;

    /**
     * The person's name
     */
    private String name;

    /**
     * The person's bio
     */
    private String bio;

    /**
     * Indicates if the user is a paying Crowdmap Plus user.
     */
    private boolean plus;

    /**
     * This is the users default baselayer that they use around Crowdmap when baselayers
     * aren't otherwise defined by maps and other users.
     */
    private String baselayer;

    /**
     * Indicates if the user automatically posts photos from their Instagram account to Crowdmap.
     */
    private boolean instagramAutoPost;

    /**
     * Indicates if the user automatically posts tweets from their Twitter account to Crowdmap.
     */
    private boolean twitterAutoPost;

    /**
     * Indicates if the user automatically posts retweets from their Twitter account to Crowdmap.
     */
    private boolean twitterAutoPostRetweets;

    /**
     * The date the user account was created.
     */
    private Date dateRegistered;

    /**
     * Indicate if the account has been suspended.
     */
    private boolean banned;

    /**
     * The path to the person's avatar
     */
    private String avatar;

    private List<Badge> badges;

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public void setId(long id) {
        this.id = id;
    }



    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrowdmapId() {
        return crowdmapId;
    }

    public void setCrowdmapId(String crowdmapId) {
        this.crowdmapId = crowdmapId;
    }

    public String getCrowdmapIdH() {
        return crowdmapIdH;
    }

    public void setCrowdmapIdH(String crowdmapIdH) {
        this.crowdmapIdH = crowdmapIdH;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isPlus() {
        return plus;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }

    public String getBaselayer() {
        return baselayer;
    }

    public void setBaselayer(String baselayer) {
        this.baselayer = baselayer;
    }

    public boolean isInstagramAutoPost() {
        return instagramAutoPost;
    }

    public void setInstagramAutoPost(boolean instagramAutoPost) {
        this.instagramAutoPost = instagramAutoPost;
    }

    public boolean isTwitterAutoPost() {
        return twitterAutoPost;
    }

    public void setTwitterAutoPost(boolean twitterAutoPost) {
        this.twitterAutoPost = twitterAutoPost;
    }

    public boolean isTwitterAutoPostRetweets() {
        return twitterAutoPostRetweets;
    }

    public void setTwitterAutoPostRetweets(boolean twitterAutoPostRetweets) {
        this.twitterAutoPostRetweets = twitterAutoPostRetweets;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", crowdmapId='" + crowdmapId + '\'' +
                ", crowdmapIdH='" + crowdmapIdH + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", plus=" + plus +
                ", baselayer='" + baselayer + '\'' +
                ", instagramAutoPost=" + instagramAutoPost +
                ", twitterAutoPost=" + twitterAutoPost +
                ", twitterAutoPostRetweets=" + twitterAutoPostRetweets +
                ", dateRegistered=" + dateRegistered +
                ", banned=" + banned +
                ", avatar='" + avatar + '\'' +
                ", badges=" + badges +
                '}';
    }
}
