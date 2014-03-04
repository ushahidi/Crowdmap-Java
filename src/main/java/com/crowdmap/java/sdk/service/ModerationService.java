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
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.ModerationInterface;

import retrofit.RestAdapter;

/**
 * Moderation service. Use for flagging content on Crowdmap for moderation by the Crowdmap team.
 */
public class ModerationService extends CrowdmapService<ModerationService> {

    private ModerationInterface mModerationInterface;

    public ModerationService(RestAdapter restAdapter) {
        super(restAdapter);
        mModerationInterface = restAdapter.create(ModerationInterface.class);
    }

    /**
     * Flag a comment for moderation.
     *
     * @param commentId The ID of the comment to be flagged for moderation.
     * @return List of comments
     */
    public Comments reportComment(long commentId) {
        checkId(commentId);
        return mModerationInterface.reportComment(commentId);
    }

    /**
     * Flag a map for moderation.
     *
     * @param mapId The ID of the map to be flagged for moderation.
     */
    public Maps reportMaps(long mapId) {
        checkId(mapId);
        return mModerationInterface.reportMap(mapId);
    }

    /**
     * Flag user for moderation.
     *
     * @param userId The ID of the user to be flagged for moderation.
     */
    public Maps reportUser(long userId) {
        checkId(userId);
       return mModerationInterface.reportUser(userId);
    }

}
