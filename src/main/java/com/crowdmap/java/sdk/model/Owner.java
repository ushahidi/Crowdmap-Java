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

import com.crowdmap.java.sdk.json.Response;

import java.io.Serializable;
import java.util.List;

/**
 * Owner model class
 */
public class Owner extends Response implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 2287672209635012925L;

    private List<Image> media;

    /**
     * The person ID
     */
    @SerializedName("user_id")
    private int id;

    /**
     * The person's crowdmap ID
     */
    @SerializedName("crowdmap_id")
    private String crowdmapId;

    /**
     * The person's username
     */
    private String username;

    /**
     * The person's name
     */
    private String name;

    /**
     * The person's profile status. 1 for public and 0 for private.
     */
    @SerializedName("public")
    private int pub;

    /**
     * The ID of the person's hero graphic
     */
    @SerializedName("media_id_hero")
    private int mediaIdHero;

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
     * @return the crowdmapId
     */
    public String getCrowdmapId() {
        return crowdmapId;
    }

    /**
     * @param crowdmapId the crowdmapId to set
     */
    public void setCrowdmapId(String crowdmapId) {
        this.crowdmapId = crowdmapId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pub
     */
    public int getPub() {
        return pub;
    }

    /**
     * @param pub the pub to set
     */
    public void setPub(int pub) {
        this.pub = pub;
    }

    /**
     * @return the mediaIdHero
     */
    public int getMediaIdHero() {
        return mediaIdHero;
    }

    /**
     * @param mediaIdHero the mediaIdHero to set
     */
    public void setMediaIdHero(int mediaIdHero) {
        this.mediaIdHero = mediaIdHero;
    }

    /**
     * Image items
     *
     * @return List of {@link Image}
     */
    public List<Image> getMedia() {
        return this.media;
    }
}
