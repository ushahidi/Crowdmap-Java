/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
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
 *****************************************************************************/
package com.crowdmap.java.sdk.model;

import java.io.Serializable;

import com.crowdmap.java.sdk.json.Date;
import com.google.gson.annotations.SerializedName;

/**
 * Media model class
 */
public class Media implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 6598496611618930055L;

	/**
	 * The media ID
	 */
	@SerializedName("user_id")
	private int id;

	/**
	 * The user ID
	 */
	@SerializedName("user_id")
	private int userId;

	/**
	 * The latitude
	 */
	private double lat;

	/**
	 * The longitude
	 */
	private double lon;

	/**
	 * The source of the media
	 */
	private String source;

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
	private String largeWidth;

	/**
	 * The height of the large media
	 */
	@SerializedName("l_height")
	private String largeHeight;

	/**
	 * The small media file name
	 */
	@SerializedName("filename_l")
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
	private String thumbnailWidth;

	/**
	 * The media's thumbnail height
	 */
	@SerializedName("t_height")
	private String thumbnailHeight;

	/**
	 * The media mime type
	 */
	private String mime;

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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
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
	public String getLargeWidth() {
		return largeWidth;
	}

	/**
	 * @param largeWidth the largeWidth to set
	 */
	public void setLargeWidth(String largeWidth) {
		this.largeWidth = largeWidth;
	}

	/**
	 * @return the largeHeight
	 */
	public String getLargeHeight() {
		return largeHeight;
	}

	/**
	 * @param largeHeight the largeHeight to set
	 */
	public void setLargeHeight(String largeHeight) {
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
	public String getThumbnailWidth() {
		return thumbnailWidth;
	}

	/**
	 * @param thumbnailWidth the thumbnailWidth to set
	 */
	public void setThumbnailWidth(String thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	/**
	 * @return the thumbnailHeight
	 */
	public String getThumbnailHeight() {
		return thumbnailHeight;
	}

	/**
	 * @param thumbnailHeight the thumbnailHeight to set
	 */
	public void setThumbnailHeight(String thumbnailHeight) {
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

	
}
