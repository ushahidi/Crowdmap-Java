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

package com.crowdmap.java.sdk.json;

import com.crowdmap.java.sdk.model.Tag;

import java.util.List;

/**
 * Post tags
 */
public class PostTags extends  Response{

    private static final long serialVersionUID = 36455760364885900L;

    private List<Tag> postTags;

    public List<Tag> getPostTags() {
        return postTags;
    }

    @Override
    public String toString() {
        return "MapTags{" +
                "mapsTags=" + postTags +
                '}';
    }
}
