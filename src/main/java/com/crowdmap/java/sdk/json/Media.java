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

import java.io.Serializable;
import java.util.List;

/**
 * Media Json response
 */
public class Media extends Response implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 8498886833164100022L;


    private List<com.crowdmap.java.sdk.model.Media> media;

    public List<com.crowdmap.java.sdk.model.Media> getMedia() {
        return media;
    }

    public void setMedia(List<com.crowdmap.java.sdk.model.Media> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Media{" +
                ", media=" + media +
                '}';
    }
}
