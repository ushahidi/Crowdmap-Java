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
 * External model class
 */
public class Externals implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -2262064174864400454L;

	/**
	 * The external ID
	 */
	@SerializedName("external_id")
	private int id;
	
	/**
	 * The service ID
	 */
	@SerializedName("service_id")
	private int serviceId;
	
	/**
	 * The providier
	 */
	private String provider;
	
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
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * @return the idOnService
	 */
	public int getIdOnService() {
		return idOnService;
	}

	/**
	 * @param idOnService the idOnService to set
	 */
	public void setIdOnService(int idOnService) {
		this.idOnService = idOnService;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the faviconUrl
	 */
	public String getFaviconUrl() {
		return faviconUrl;
	}

	/**
	 * @param faviconUrl the faviconUrl to set
	 */
	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}

	/**
	 * @return the embedHtml
	 */
	public String getEmbedHtml() {
		return embedHtml;
	}

	/**
	 * @param embedHtml the embedHtml to set
	 */
	public void setEmbedHtml(String embedHtml) {
		this.embedHtml = embedHtml;
	}

	/**
	 * @return the embedHtmlSmall
	 */
	public String getEmbedHtmlSmall() {
		return embedHtmlSmall;
	}

	/**
	 * @param embedHtmlSmall the embedHtmlSmall to set
	 */
	public void setEmbedHtmlSmall(String embedHtmlSmall) {
		this.embedHtmlSmall = embedHtmlSmall;
	}

	/**
	 * The type
	 */
	private String html;
	
	@SerializedName("id_on_service")
	private int idOnService;
	
	/**
	 * The data from the external service
	 */
	private String data;
	
	/**
	 * The date and time
	 */
	private Date dateTime;
	
	
	/**
	 * The Image URL
	 */
	@SerializedName("image_url")
	private String imageUrl;
	
	/**
	 * The latitude
	 */
	private double lat;

	/**
	 * The longitude
	 */
	private double lon;
	
	/**
	 * The URL
	 */
	private String url;
	
	/**
	 * The title
	 */
	private String title;
	
	/**
	 * The favicon URL
	 */
	@SerializedName("favicon_url")
	private String faviconUrl;
	
	/**
	 * The embed html
	 */
	@SerializedName("embed_html")
	private String embedHtml;
	
	/**
	 * The embed html small
	 */
	@SerializedName("embed_html_small")
	private String embedHtmlSmall;
	
}
