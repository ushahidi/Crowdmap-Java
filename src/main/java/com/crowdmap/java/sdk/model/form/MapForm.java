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

package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;
import com.crowdmap.java.sdk.util.ValidateUtil;

import java.io.File;

/**
 * Form for creating fields for maps.
 */
public class MapForm extends Form {

    /**
     * The subdomain for the map.
     */
    @FormField(name = "subdomain")
    private String subdomain;

    /**
     * The name of the map.
     */
    @FormField(name = "name")
    private String name;

    /**
     * The description for the map.
     */
    @FormField(name = "description")
    private String description;

    /**
     * A URL for a banner image for the map.
     */
    @FormField(name = "banner")
    private String bannerUrl;

    /**
     * The URL for the avatar image for the map.
     */
    @FormField(name = "avatar")
    private String avatarUrl;

    /**
     * An image File to be uploaded as a banner image for the map.
     */
    private File uploadBanner;

    /**
     * An image File to be uploaded as an avatar for the map.
     */
    private File uploadAvatar;

    /**
     * The privacy of the map to be created
     */
    @FormField(name = "public")
    private boolean isPublic;

    /**
     * The moderation status for the map
     */
    @FormField(name = "moderation")
    private Moderation moderation;

    /**
     * Get the subdomain set for the map.
     *
     * @return The subdomain of the map.
     */
    public String getSubdomain() {
        return subdomain;
    }

    /**
     * Set the subdomain for the map.
     *
     * @param subdomain The subdomain to be created for the map.
     */
    public void setSubdomain(String subdomain) {
        if (ValidateUtil.empty(subdomain)) {
            throw new CrowdmapException(
                    "Subdomain is a required field. Please set a subdomain for the map");
        }

        this.subdomain = subdomain;
    }

    /**
     * Get the name of the map
     *
     * @return The maps name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the map.
     *
     * @param name The map's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the map
     *
     * @return The description of the map.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a description for the map to be created
     *
     * @param description The description to be set for the map
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the URL to an image to be set as a banner image for the map.
     *
     * @return The URL to the image.
     */
    public String getBannerUrl() {
        return bannerUrl;
    }

    /**
     * Set a URL to an image for the maps banner.
     *
     * @throws com.crowdmap.java.sdk.CrowdmapException If an invalid URL is provided for the image.
     */
    public void setBannerUrl(String bannerUrl) {
        if (!ValidateUtil.url(bannerUrl)) {
            throw new CrowdmapException(
                    "Please the provide URL to the banner image is not valid. Kindly provide a valid URL");
        }
        this.bannerUrl = bannerUrl;
    }

    /**
     * Get the URL to the avatar.
     *
     * @return The avatar URL.
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Set a URL to an image that will be used as the avatar for the map.
     *
     * <strong>Note:</strong> Once you set this, there is no need to set an image for file upload.
     * The file set for upload will be ignored during the submission process.
     *
     * @param avatarUrl The URL to the image
     * @throws com.crowdmap.java.sdk.CrowdmapException When an invalid URL is provided
     */
    public void setAvatarUrl(String avatarUrl) {
        if (!ValidateUtil.url(avatarUrl)) {
            throw new CrowdmapException(
                    "Please the provide URL to the avatar image is not valid. Kindly provide a valid URL");
        }

        this.avatarUrl = avatarUrl;
    }

    /**
     * Get the image to be uploaded.
     *
     * @return The image to be uploaded.
     */
    public File getUploadBanner() {
        return uploadBanner;
    }

    /**
     * Set a file to be uploaded as a banner for the map
     *
     * @param uploadBanner The file to be uploaded.
     * @throws com.crowdmap.java.sdk.CrowdmapException if a {@link #setBannerUrl(String)} is set
     */
    public void setUploadBanner(File uploadBanner) {
        if (!ValidateUtil.empty(getBannerUrl())) {
            throw new CrowdmapException(
                    "You cannot upload an image for the banner because you've set a URL for it.");
        }
        this.uploadBanner = uploadBanner;
    }

    /**
     * Get the set file to be uploaded as avatar.
     *
     * @return avatar file.
     */
    public File getUploadAvatar() {
        return uploadAvatar;
    }

    /**
     * Set a file to be uploaded as a banner for the map
     *
     * @param uploadAvatar The file to be uploaded.
     * @throws com.crowdmap.java.sdk.CrowdmapException if a {@link #setAvatarUrl(String)} is set
     */
    public void setUploadAvatar(File uploadAvatar) {
        if (!ValidateUtil.empty(getBannerUrl())) {
            throw new CrowdmapException(
                    "You cannot upload an image for the avatar because you've set a URL for it.");
        }
        this.uploadAvatar = uploadAvatar;
    }

    /**
     * Get the privacy set for the map
     */
    public boolean getPublic() {
        return isPublic;
    }

    /**
     * Set the privacy of the map
     */
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    /**
     * Get the maps moderation status.
     *
     * @return The moderation status.
     */
    public Moderation getModeration() {
        return moderation;
    }

    /**
     * Set moderation status.
     *
     * @param moderation The moderation staus. See {@link MapForm.Moderation}
     */
    public void setModeration(Moderation moderation) {

        this.moderation = moderation;
    }

    @Override
    public String toString() {
        return "MapForm{" +
                "isPublic=" + isPublic +
                ", uploadAvatar=" + uploadAvatar +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", uploadBanner=" + uploadBanner +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", subdomain='" + subdomain + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * Define the moderation types.
     *
     * Auto means, the map will auto approve all posts
     *
     * Collaborator means, all post have to be approved by a collaborator
     */
    public enum Moderation {

        Auto("auto"),
        Collaborator("collaborator");

        private final String value;

        Moderation(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
