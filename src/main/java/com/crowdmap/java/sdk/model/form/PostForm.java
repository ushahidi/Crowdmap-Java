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

package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.util.ValidateUtil;

import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * Form for posting
 */
public class PostForm {

    private TypedString message;

    private boolean isPublic;

    private TypedString locationName;

    private double lat;

    private double lon;

    private TypedString geometry;

    private int fsqVenueId;

    private int tweet;

    private TypedString externalUrl;

    private TypedFile media;

    public TypedString getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (ValidateUtil.empty(message)) {
            throw new IllegalArgumentException("Message cannot be empty or null");
        }
        this.message = new TypedString(message);
    }

    public boolean getPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public TypedString getLocationName() {
        return locationName;
    }

    public void setLocationName(TypedString locationName) {
        this.locationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public TypedString getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = new TypedString(geometry);
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getFsqVenueId() {
        return fsqVenueId;
    }

    public void setFsqVenueId(int fsqVenueId) {
        this.fsqVenueId = fsqVenueId;
    }

    public int getTweet() {
        return tweet;
    }

    public void setTweet(int tweet) {
        this.tweet = tweet;
    }

    public TypedString getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = new TypedString(externalUrl);
    }

    public TypedFile getMedia() {
        return media;
    }

    public void setMedia(TypedFile media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "PostForm{" +
                "message=" + message +
                ", isPublic=" + isPublic +
                ", locationName=" + locationName +
                ", lat=" + lat +
                ", lon=" + lon +
                ", geometry=" + geometry +
                ", fsqVenueId=" + fsqVenueId +
                ", tweet=" + tweet +
                ", externalUrl=" + externalUrl +
                ", media=" + media +
                '}';
    }
}
