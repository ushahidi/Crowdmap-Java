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
 * External model class
 */
public class External implements Serializable {

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
    private int serviceId;

    /**
     * The provider. The name of the site the content came from
     */
    private String provider;

    /**
     * The type. The type of content. Generally html or url to an image.
     */
    private String type;

    /**
     * The ID of the content on a given service.
     */
    private String idOnService;

    /**
     * The content from the external service.
     */
    private String content;

    /**
     * The date and time
     */
    private Date dateTime;


    /**
     * The Media URL
     */
    private List<Image> images;

    /**
     * The latitude
     */
    private Double lat;

    /**
     * The longitude
     */
    private Double lon;

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
    private String faviconUrl;

    /**
     * The embed type
     */
    private String embedHtml;

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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the idOnService
     */
    public String getIdOnService() {
        return idOnService;
    }

    /**
     * @param idOnService the idOnService to set
     */
    public void setIdOnService(String idOnService) {
        this.idOnService = idOnService;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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
     * @return the lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(Double lon) {
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

    @Override
    public String toString() {
        return "External{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", provider='" + provider + '\'' +
                ", type='" + type + '\'' +
                ", idOnService='" + idOnService + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", images='" + images + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", faviconUrl='" + faviconUrl + '\'' +
                ", embedHtml='" + embedHtml + '\'' +
                '}';
    }

    public static final class Image implements Serializable {

        private static final long serialVersionUID = -5764178939360495066L;

        private long externalsImagesId;

        private long externalId;

        private String url;

        public long getExternalsImagesId() {
            return externalsImagesId;
        }

        public void setExternalsImagesId(long externalsImagesId) {
            this.externalsImagesId = externalsImagesId;
        }

        public long getExternalId() {
            return externalId;
        }

        public void setExternalId(long externalId) {
            this.externalId = externalId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Image{" +
                    "externalsImagesId=" + externalsImagesId +
                    ", externalId=" + externalId +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
