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
import java.util.List;

/**
 * Media model class
 */
public class Media implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 6598496611618930055L;

    private List<User> users;

    /**
     * The media ID
     */
    @SerializedName("media_id")
    private int id;

    /**
     * The user ID
     */
    @SerializedName("user_id")
    private int userId;

    /**
     * The latitude
     */
    private Double lat;

    /**
     * The longitude
     */
    private Double lon;

    /**
     * The dominantColor of the media
     */
    private String dominantColor;

    /**
     * The date and time of the file
     */
    @SerializedName("file_datetime")
    private Date fileDatetime;

    /**
     * The date and time the file was uploaded
     */
    @SerializedName("upload_datetime")
    private Date uploadDatetime;

    /**
     * The file location
     */
    @SerializedName("file_location")
    private String fileLocation;

    /**
     * The original file name of the media
     */
    private String filename;

    /**
     * The original width of the media
     */
    private int width;

    /**
     * The original height of the media
     */
    private int height;

    /**
     * The large media file name
     */
    @SerializedName("filename_l")
    private String filenameLarge;

    /**
     * The width of large media
     */
    @SerializedName("l_width")
    private int largeWidth;

    /**
     * The height of the large media
     */
    @SerializedName("l_height")
    private int largeHeight;

    /**
     * The small media file name
     */
    @SerializedName("filename_s")
    private String filenameSmall;

    /**
     * The small media width
     */
    @SerializedName("s_width")
    private int smallWidth;

    /**
     * The small media height
     */
    @SerializedName("s_height")
    private int smallHeight;

    /**
     * The media's thumnail file name
     */
    @SerializedName("filename_t")
    private String filenameThumbnail;

    /**
     * The medai's thumbnail width
     */
    @SerializedName("t_width")
    private int thumbnailWidth;

    /**
     * The media's thumbnail height
     */
    @SerializedName("t_height")
    private int thumbnailHeight;

    /**
     * The media mime type
     */
    private String mime;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * @return the dominantColor
     */
    public String getDominantColor() {
        return dominantColor;
    }

    /**
     * @param dominantColor the dominantColor to set
     */
    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    /**
     * @return the fileDatetime
     */
    public Date getFileDatetime() {
        return fileDatetime;
    }

    /**
     * @param fileDatetime the fileDatetime to set
     */
    public void setFileDatetime(Date fileDatetime) {
        this.fileDatetime = fileDatetime;
    }

    /**
     * @return the uploadDatetime
     */
    public Date getUploadDatetime() {
        return uploadDatetime;
    }

    /**
     * @param uploadDatetime the uploadDatetime to set
     */
    public void setUploadDatetime(Date uploadDatetime) {
        this.uploadDatetime = uploadDatetime;
    }

    /**
     * @return the fileLocation
     */
    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * @param fileLocation the fileLocation to set
     */
    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the filenameLarge
     */
    public String getFilenameLarge() {
        return filenameLarge;
    }

    /**
     * @param filenameLarge the filenameLarge to set
     */
    public void setFilenameLarge(String filenameLarge) {
        this.filenameLarge = filenameLarge;
    }

    /**
     * @return the largeWidth
     */
    public int getLargeWidth() {
        return largeWidth;
    }

    /**
     * @param largeWidth the largeWidth to set
     */
    public void setLargeWidth(int largeWidth) {
        this.largeWidth = largeWidth;
    }

    /**
     * @return the largeHeight
     */
    public int getLargeHeight() {
        return largeHeight;
    }

    /**
     * @param largeHeight the largeHeight to set
     */
    public void setLargeHeight(int largeHeight) {
        this.largeHeight = largeHeight;
    }

    /**
     * @return the filenameSmall
     */
    public String getFilenameSmall() {
        return filenameSmall;
    }

    /**
     * @param filenameSmall the filenameSmall to set
     */
    public void setFilenameSmall(String filenameSmall) {
        this.filenameSmall = filenameSmall;
    }

    /**
     * @return the smallWidth
     */
    public int getSmallWidth() {
        return smallWidth;
    }

    /**
     * @param smallWidth the smallWidth to set
     */
    public void setSmallWidth(int smallWidth) {
        this.smallWidth = smallWidth;
    }

    /**
     * @return the smallHeight
     */
    public int getSmallHeight() {
        return smallHeight;
    }

    /**
     * @param smallHeight the smallHeight to set
     */
    public void setSmallHeight(int smallHeight) {
        this.smallHeight = smallHeight;
    }

    /**
     * @return the filenameThumbnail
     */
    public String getFilenameThumbnail() {
        return filenameThumbnail;
    }

    /**
     * @param filenameThumbnail the filenameThumbnail to set
     */
    public void setFilenameThumbnail(String filenameThumbnail) {
        this.filenameThumbnail = filenameThumbnail;
    }

    /**
     * @return the thumbnailWidth
     */
    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * @param thumbnailWidth the thumbnailWidth to set
     */
    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    /**
     * @return the thumbnailHeight
     */
    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * @param thumbnailHeight the thumbnailHeight to set
     */
    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * @return the mime
     */
    public String getMime() {
        return mime;
    }

    /**
     * @param mime the mime to set
     */
    public void setMime(String mime) {
        this.mime = mime;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", userId=" + userId +
                ", lat=" + lat +
                ", lon=" + lon +
                ", dominantColor='" + dominantColor + '\'' +
                ", fileDatetime=" + fileDatetime +
                ", uploadDatetime=" + uploadDatetime +
                ", fileLocation='" + fileLocation + '\'' +
                ", filename='" + filename + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", filenameLarge='" + filenameLarge + '\'' +
                ", largeWidth='" + largeWidth + '\'' +
                ", largeHeight='" + largeHeight + '\'' +
                ", filenameSmall='" + filenameSmall + '\'' +
                ", smallWidth=" + smallWidth +
                ", smallHeight=" + smallHeight +
                ", filenameThumbnail='" + filenameThumbnail + '\'' +
                ", thumbnailWidth='" + thumbnailWidth + '\'' +
                ", thumbnailHeight='" + thumbnailHeight + '\'' +
                ", mime='" + mime + '\'' +
                '}';
    }
}
