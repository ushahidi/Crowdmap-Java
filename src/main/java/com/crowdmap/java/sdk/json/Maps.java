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

import com.crowdmap.java.sdk.model.Map;

import java.io.Serializable;
import java.util.List;

/**
 * Map response model class
 */
public class Maps extends Response implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 6835878593630432210L;

    private List<Map> maps;

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "Maps{" +
                "maps=" + maps.toString() +
                '}';
    }
}
