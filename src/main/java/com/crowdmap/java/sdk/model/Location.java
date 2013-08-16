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

import java.io.Serializable;

/**
 * Location model class
 */
public class Location implements Serializable {

    /**
     * Seria version UID
     */
    private static final long serialVersionUID = -4499118399170068867L;

    private int locationId;

    private int fsqVenueId;

    private Geometry geometry;

    private String name;

    private String region;

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the fsqVenueId
     */
    public int getFsqVenueId() {
        return fsqVenueId;
    }

    /**
     * @param fsqVenueId the fsqVenueId to set
     */
    public void setFsqVenueId(int fsqVenueId) {
        this.fsqVenueId = fsqVenueId;
    }

    /**
     * @return the geometry
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     * @param geometry the geometry to set
     */
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
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
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", fsqVenueId=" + fsqVenueId +
                ", geometry=" + geometry +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
