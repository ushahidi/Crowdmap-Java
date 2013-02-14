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
package com.crowdmap.java.sdk.json;

import com.crowdmap.java.sdk.model.Person;
import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class Maps {

	/**
	 * The ID of the map.
	 */
	@SerializedName("map_id")
	private int id;

	// public List<Media> media;

	public Person users;

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

}
