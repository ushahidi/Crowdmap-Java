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
    public Media getMedia() {
       return  mMediaInterface.getMedia();
    }

    /**
     * Get a specific media
     *
     * @param mediaId The ID of the media
     * @return Media Object
     */
    public Media getMedia(long mediaId) {
        checkId(mediaId);
        return mMediaInterface.getMedia(mediaId);
    }

    public Media createMedia(TypedFile photo) {
        return mMediaInterface.createMedia(photo);
    }

    public Media deleteMedia(long mediaId, @SessionToken String sessionToken) {
        checkId(mediaId);
        return mMediaInterface.deleteMedia(mediaId, sessionToken);
    }
}
