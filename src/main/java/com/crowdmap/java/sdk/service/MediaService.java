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
package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.Media;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MEDIA;

/**
 * Service for interacting with crowdmap's media API
 */
public class MediaService extends CrowdmapService {

    /**
     * Get media in crowdmap. GET /media
     */
    public Media getMedia() {

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
        url.append("/");
        url.append(id);
        String response = client.get(url.toString());
        Media mediaJson = fromString(response, Media.class);
        return mediaJson;
    }
}
