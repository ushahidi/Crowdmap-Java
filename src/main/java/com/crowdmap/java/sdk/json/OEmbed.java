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

package com.crowdmap.java.sdk.json;

import java.io.Serializable;

/**
 * oEmbed resource. Oembed information returned in accordance with the oEmbed standard. You can find
 * the embed code for any URL on Crowdmap by reading meta data in the source of any page.
 */
public class OEmbed implements Serializable {

    private static final long serialVersionUID = 8554246772718214922L;

    private float version;

    private String type;

    private String title;

    private String url;

    private String authorName;

    private String authorUrl;

    private String providerName;

    private String providerUrl;

    private int width;

    private int height;

    private String html;

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "OEmbed{" +
                "version=" + version +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerUrl='" + providerUrl + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", html='" + html + '\'' +
                '}';
    }
}
