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

import java.io.Serializable;
import java.util.List;

/**
 * Collaborator model class
 */
public class Collaborator implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = -7737899846329046622L;

    private List<User> users;

    /**
     * The person ID
     */
    @SerializedName("user_id")
    private int id;

    /**
     * The ID of the map.
     */
    @SerializedName("map_id")
    private int mapId;

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
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
     * @return the mapId
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @param mapId the mapId to set
     */
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "users=" + users +
                ", id=" + id +
                ", mapId=" + mapId +
                '}';
    }
}
