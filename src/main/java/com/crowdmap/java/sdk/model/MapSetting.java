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

/**
 * Map Setting
 */
public class MapSetting implements Serializable {


    private static final long serialVersionUID = -2224153364312666596L;

    @SerializedName("maps_settings_id")
    private long id;

    private long mapId;

    private String setting;

    private String value;

    public MapSetting() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapSetting{" +
                "id=" + id +
                ", mapId=" + mapId +
                ", setting='" + setting + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
