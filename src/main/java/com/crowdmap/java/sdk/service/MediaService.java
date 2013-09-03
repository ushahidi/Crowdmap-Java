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

import com.crowdmap.java.sdk.json.Media;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.model.form.MediaForm;
import com.crowdmap.java.sdk.util.Util;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_DELETE;
import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MEDIA;

/**
 * Service for interacting with crowdmap's media API
 */
public class MediaService extends CrowdmapService {

    /**
     * Get media in crowdmap. GET /media
     */
    public Media getMedia() {
        //Crowdmap requires a new api signature every 2 minutes
        // so before a request is made, generate a new key
        //generate the api key
        final String apiKey = Util
                .generateSignature("GET", SEGMENT_MEDIA, getPublicKey(), getPrivateKey());

        // set the apikey for the request
        client.setApiKey(apiKey);
        String response = client.get(SEGMENT_MEDIA);
        Media mediaJson = fromString(response, Media.class);
        return mediaJson;
    }

    /**
     * Get a specific media
     *
     * @param id The ID of the media
     * @return Media Object
     */
    public Media getMedia(String id) {
        StringBuilder url = new StringBuilder(SEGMENT_MEDIA);
        url.append(id);
        String response = client.get(url.toString());
        Media mediaJson = fromString(response, Media.class);
        return mediaJson;
    }

    public Media createMedia(MediaForm form) {
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MEDIA);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.multipartPost(url.toString(), form.getParameters()), Media.class);
    }

    public Response deleteMedia(long mediaId) {
        checkId(mediaId);
        initSession();
        StringBuilder url = new StringBuilder(SEGMENT_MEDIA);
        url.append(mediaId);
        setApiKey(METHOD_DELETE, url.toString());
        return fromString(client.delete(url.toString()), Response.class);
    }
}