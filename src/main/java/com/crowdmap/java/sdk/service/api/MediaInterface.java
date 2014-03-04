/*******************************************************************************
 * Copyright (c) 2010 - 2014 Ushahidi Inc.
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

package com.crowdmap.java.sdk.service.api;

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Media;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MEDIA;

/**
 * Media Interface
 */
public interface MediaInterface {

    @GET(SEGMENT_MEDIA)
    Media getMedia();

    @GET(SEGMENT_MEDIA + "{media_id}")
    Media getMedia(@Path("media_id") long mediaId);

    @Multipart
    @POST(SEGMENT_MEDIA)
    Media createMedia(@Part("file") TypedFile photo);

    @DELETE(SEGMENT_MEDIA + "{media_id}")
    Media deleteMedia(@Path("media_id") long mediaId,
            @Query("session") @SessionToken String sessionToken);
}
