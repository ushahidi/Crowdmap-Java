package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;
import com.crowdmap.java.sdk.util.ValidateUtil;

import java.util.List;

/**
 * Tag form
 */
public class TagForm extends Form {

    @FormField(name="tag")
    private String tags;

    /**
     * Set a single tag for submission
     *
     * @param tag
     */
    public void setTags(String tag) {
        this.tags = ValidateUtil.empty(tag) ? tag : tags +","+tag;
    }

    /**
     * Set mutliple tags for submission
     *
     * @param tags
     */
    public void setTags(List<String> tags) {
        for(String tag : tags) {
            setTags(tag);
        }
    }

    /**
     * Get the set tag
     *
     * @return The tag set.
     */
    public String getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "TagForm{" +
                "tags='" + tags + '\'' +
                '}';
    }
}
