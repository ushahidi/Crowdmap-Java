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

import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.model.User;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_POST;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAP;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_USER;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MODERATE;

/**
 * Moderation service. Use for flagging content on Crowdmap for moderation by the Crowdmap team.
 */
public class ModerationService extends CrowdmapService {

    /**
     * Flag a comment for moderation.
     *
     * @param commentId The ID of the comment to be flagged for moderation.
     * @return List of comments
     */
    public Comments moderateComment(long commentId) {
        StringBuilder url = new StringBuilder(SEGMENT_MODERATE);
        url.append(SEGMENT_COMMENT);
        url.append(commentId);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()), Comments.class);
    }

    /**
     * Flag a map for moderation.
     *
     * @param mapId The ID of the map to be flagged for moderation.
     */
    public Maps moderateMaps(long mapId) {
        StringBuilder url = new StringBuilder(SEGMENT_MODERATE);
        url.append(SEGMENT_MAP);
        url.append(mapId);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()), Maps.class);
    }

    /**
     * Flag user for moderation.
     *
     * @param userId The ID of the user to be flagged for moderation.
     */
    public User moderateUser(long userId) {
        StringBuilder url = new StringBuilder(SEGMENT_MODERATE);
        url.append(SEGMENT_USER);
        url.append(userId);
        setApiKey(METHOD_POST, url.toString());
        return fromString(client.post(url.toString()), User.class);
    }
}
