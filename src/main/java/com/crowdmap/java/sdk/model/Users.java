/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
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
 *****************************************************************************/
package com.crowdmap.java.sdk.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class Users implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2131057553316089514L;

	/**
	 * The person ID
	 */
	@SerializedName("user_id")
	private int id;

	private String crowdmapId;

	/**
	 * The person's crowdmap ID H
	 */
	private String crowdmapIdH;

	private int plus;

	/**
	 * The person's username
	 */
	private String username;

	/**
	 * The person's name
	 */
	private String name;

	/**
	 * The person's bio
	 */
	private String bio;

	/**
	 * The person's profile status. 1 for public and 0 for private.
	 */
	@SerializedName("public")
	private int isPublic;

	private int mediaIdHero;

	/**
	 * The path to the person's avatar
	 */
	private String avatar;

	private List<Media> media;

	/**
	 * @return the media
	 */
	public List<Media> getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(List<Media> media) {
		this.media = media;
	}

	/**
	 * @return the crowdmapIdH
	 */
	public String getCrowdmapIdH() {
		return crowdmapIdH;
	}

	/**
	 * @param crowdmapIdH
	 *            the crowdmapIdH to set
	 */
	public void setCrowdmapIdH(String crowdmapIdH) {
		this.crowdmapIdH = crowdmapIdH;
	}

	/**
	 * @return the plus
	 */
	public int getPlus() {
		return plus;
	}

	/**
	 * @param plus
	 *            the plus to set
	 */
	public void setPlus(int plus) {
		this.plus = plus;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Set the person's ID
	 * 
	 * @param id
	 *            The ID of the person
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the person's crowdmap ID
	 * 
	 * @param crowdmapId
	 *            The crowdmap ID
	 */
	public void setCrowdmapId(String crowdmapId) {
		this.crowdmapId = crowdmapId;
	}

	/**
	 * Set the person's username
	 * 
	 * @param username
	 *            The person's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Set the person's name
	 * 
	 * @param name
	 *            The person's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the person's bio
	 * 
	 * @param bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Set the person's profile public status
	 * 
	 * @param isPublic
	 *            1 for public and 0 for private
	 */
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * Set the person's graphic hero ID
	 * 
	 * @param mediaIdHero
	 */
	public void setMediaIdHero(int mediaIdHero) {
		this.mediaIdHero = mediaIdHero;
	}

	/**
	 * Get the ID
	 * 
	 * @return int The ID
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Get the persons crowdmap id
	 * 
	 * @return String The crowdmap ID
	 */
	public String getCrowdmapId() {
		return this.crowdmapId;
	}

	/**
	 * Get the person's username
	 * 
	 * @return String The person's username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Get the person's name
	 * 
	 * @return String The person's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the person's bio
	 * 
	 * @return String The person's bio
	 */
	public String getBio() {
		return this.bio;
	}

	/**
	 * Get the person's public profile status
	 * 
	 * @return int 1 for public and 0 for private
	 */
	public int getIsPublic() {
		return this.isPublic;
	}

	/**
	 * Get the Media ID Hero
	 * 
	 * @return int
	 */
	public int getMediaIdHero() {
		return this.mediaIdHero;
	}

	/**
	 * Get the path to the person's avatar
	 * 
	 * @return String
	 */
	public String getAvatar() {
		return this.avatar;
	}
}
