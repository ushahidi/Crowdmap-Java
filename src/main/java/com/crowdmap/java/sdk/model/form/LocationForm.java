package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;
import com.crowdmap.java.sdk.model.Geometry;
import com.crowdmap.java.sdk.util.ValidateUtil;

/**
 * Location form. Represents the form fields when submitting a new location.
 */
public class LocationForm extends Form {

    @FormField(name = "location_id")
    private int locationId;

    @FormField(name = "fsq_venue_id")
    private String fsqVenueId;

    @FormField(name = "geometry")
    private String geometry;

    @FormField(name = "name")
    private String name;

    @FormField(name = "region")
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
    public String getFsqVenueId() {
        return fsqVenueId;
    }

    /**
     * Set the four square venue ID
     *
     * @param fsqVenueId the fsqVenueId to set
     */
    public void setFsqVenueId(String fsqVenueId) {
        if(!ValidateUtil.empty(geometry)) {
            throw new CrowdmapException("You cannot set four square venue ID if Geomerty has been set.");
        }
        this.fsqVenueId = fsqVenueId;
    }

    /**
     * Get the string representation of the geometry
     *
     * @return the geometry
     */
    public String getGeometry() {
        return geometry;
    }

    /**
     * Set the geometry.
     *
     * @param geometry the geometry to set
     */
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry.toString();
    }

    /**
     * Get the name of the location
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the location
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the region the location belongs to.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set the region the location is.
     *
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
