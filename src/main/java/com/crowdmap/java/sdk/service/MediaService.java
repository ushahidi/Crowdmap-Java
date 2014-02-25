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
package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Media;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.MediaInterface;

import retrofit.RestAdapter;
import retrofit.mime.TypedFile;

/**
 * Service for interacting with crowdmap's media API
 */
public class MediaService extends CrowdmapService<MediaService> {

    private MediaInterface mMediaInterface;

    public MediaService(RestAdapter restAdapter) {
        super(restAdapter);
        mMediaInterface = restAdapter.create(MediaInterface.class);
    }

    /**
     * Get media in crowdmap. GET /media
     */
    public void getMedia(ApiCallback<Media> callback) {
        mMediaInterface.getMedia(callback);
    }

    /**
     * Get a specific media
     *
     * @param mediaId The ID of the media
     * @return Media Object
     */
    public void getMedia(long mediaId, ApiCallback<Media> callback) {
        checkId(mediaId);
        mMediaInterface.getMedia(mediaId, callback);
    }

    public void createMedia(TypedFile photo, ApiCallback<Media> callback) {
        mMediaInterface.createMedia(photo, callback);
    }

    public void deleteMedia(long mediaId, @SessionToken String sessionToken,
            ApiCallback<Response> callback) {
        checkId(mediaId);
        mMediaInterface.deleteMedia(mediaId, sessionToken, callback);
    }
}
