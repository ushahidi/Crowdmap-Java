package com.crowdmap.java.sdk.model;

import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;

/**
 * User field
 */
public class UserForm extends Form {

    /**
     * Full name of the user
     */
    @FormField(name = "name")
    private String name;

    /**
     * Short description of the user
     */
    @FormField(name = "bio")
    private String bio;

    /**
     * The user's default base layer
     */
    @FormField(name = "baselayer")
    private String baseLayer;

    @FormField(name = "twitter_auto_post")
    private Boolean isTwitterAutoPost;

    @FormField(name = "instagram_auto_post")
    private Boolean isInstagramAutoPost;

    @FormField(name = "twitter_auto_post_retweets")
    private Boolean isTwitterAutoPostRetweets;

    public UserForm(String name, String bio, String baseLayer, Boolean isTwitterAutoPost,
            Boolean isInstagramAutoPost,
            Boolean isTwitterAutoPostRetweets) {
        this.name = name;
        this.bio = bio;
        this.baseLayer = baseLayer;
        this.isTwitterAutoPost = isTwitterAutoPost;
        this.isInstagramAutoPost = isInstagramAutoPost;
        this.isTwitterAutoPostRetweets = isTwitterAutoPostRetweets;

    }

}
