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
 * Map Model class
 */
public class Maps implements Serializable {

	/**
	 * Seriala version UID
	 */
	private static final long serialVersionUID = 5567922863749709665L;

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

	@SerializedName("media_id_hero")
	private int mediaIdHero;

	/**
	 * The subdomain of crowdmap
	 */
	private String subdomain;

	/**
	 * The name of the map
	 */
	private String name;

	@SerializedName("public")
	private int pub;

	/**
	 * The latitude
	 */
	private double lat;

	/**
	 * The longitude
	 */
	private double lon;

	/**
	 * The zoom level
	 */
	private int zoom;

	private Users users;

	private Media media;

	/**
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(Media media) {
		this.media = media;
	}

	/**
	 * @return the mediaIdHero
	 */
	public int getMediaIdHero() {
		return mediaIdHero;
	}

	/**
	 * The date the map was created
	 */
	@SerializedName("date_created")
	private Date dateCreated;

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMediaIdHero(int mediaIdHero) {
		this.mediaIdHero = mediaIdHero;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int mediaIdHero() {
		return mediaIdHero;
	}

	public String getSubdomain() {
		return subdomain;
	}

	public int getPub() {
		return pub;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public int getZoom() {
		return zoom;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Map [id:" + id + ", user_id:" + userId + ", media_id_hero:"
				+ mediaIdHero + ", subdomain:" + subdomain + ", name:" + name
				+ ", pub:" + pub + ", lat:" + lat + ", lon:" + lon + ", zoom:"
				+ zoom + ", date_created:" + dateCreated + ", media: "
				+ media.toString() + ", users: " + users.toString() + " ]";
	}
}
