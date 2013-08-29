package com.crowdmap.java.sdk.json;

import com.crowdmap.java.sdk.model.Tag;

import java.io.Serializable;
import java.util.List;

/**
 * MapTags
 */
public class MapTags extends Response {

    private List<Tag> mapsTags;

    public List<Tag> getMapsTags() {
        return mapsTags;
    }

    @Override
    public String toString() {
        return "MapTags{" +
                "mapsTags=" + mapsTags +
                '}';
    }
}
