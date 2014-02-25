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

import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.service.api.ApiCallback;

import retrofit.http.POST;
import retrofit.http.Path;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_COMMENT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MAP;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_MODERATE;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_POST;

/**
 * Interface for moderation service
 */
public interface ModerationInterface {

    @POST(SEGMENT_MODERATE + SEGMENT_COMMENT + "{comment_id}")
    void reportComment(@Path("comment_id") long commentId, ApiCallback<Comments> callback);

    @POST(SEGMENT_MODERATE + SEGMENT_POST + "{post_id}")
    void reportPost(@Path("post_id") long postId, ApiCallback<Posts> callback);

    @POST(SEGMENT_MODERATE + SEGMENT_MAP + "{map_id}")
    void reportMap(@Path("map_id") long mapId, ApiCallback<Maps> callback);

    @POST(SEGMENT_MODERATE + SEGMENT_POST + "{post_id}")
    void reportUser(@Path("post_id") long postId, ApiCallback<Maps> callback);
}
