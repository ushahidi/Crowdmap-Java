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

import com.crowdmap.java.sdk.json.Date;

import java.io.Serializable;
import java.util.List;

/**
 * Map Model class
 */
public class Map implements Serializable {

    /**
     * Seriala version UID
     */
    private static final long serialVersionUID = 5567922863749709665L;

    private Boolean approve;

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

    private List<User> users;

    private String subdomain;

    private String name;

    private String description;

    private String banner;

    private String avatar;

    @SerializedName("public")
    private Boolean isPublic;

    private String moderation;

    private Boolean marker;

    private String [] association;

    private int followers;

    private int posts;


    /**
     * The date the map was created
     */
    @SerializedName("date_created")
    private Date dateCreated;

    private Geometry center;

}
