package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;
import com.crowdmap.java.sdk.util.ValidateUtil;

import java.io.File;

/**
 * Posts form
 */
public class PostForm extends Form {

    @FormField(name = "message")
    private String message;

    @FormField(name = "public")
    private boolean isPublic;

    @FormField(name = "locations[name]")
    private String locationName;

    @FormField(name = "locations[lat]")
    private double lat;

    @FormField(name = "locations[lon]")
    private double lon;

    @FormField(name = "locations[geometry]")
    private String geometry;

    @FormField(name = "locations[fsq_venue_id]")
    private int fsqVenueId;

    @FormField(name="map_id")
    private long mapId;

    @FormField(name = "tweet")
    private int tweet;

    @FormField(name = "externals[url]")
    private String externalUrl;

    @FormField(name = "media[file]")
    private File media;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (ValidateUtil.empty(message)) {
            throw new IllegalArgumentException("Message cannot be empty or null");
        }
        this.message = message;
    }

    public boolean getPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
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

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public File getMedia() {
        return media;
    }

    public void setMedia(File media) {
        this.media = media;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    @Override
    public String toString() {
        return "PostForm{" +
                "message='" + message + '\'' +
                ", isPublic=" + isPublic +
                ", locationName='" + locationName + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", geometry='" + geometry + '\'' +
                ", fsqVenueId=" + fsqVenueId +
                ", mapId=" + mapId +
                ", tweet=" + tweet +
                ", externalUrl='" + externalUrl + '\'' +
                ", media=" + media +
                '}';
    }
}
