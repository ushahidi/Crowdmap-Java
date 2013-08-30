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

import com.crowdmap.java.sdk.json.Externals;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_EXTERNALS;

/**
 * External service
 */
public class ExternalService extends CrowdmapService {

    /**
     * Get all externals. GET /externals
     */
    public Externals getExternals() {
        return fromString(client.get(SEGMENT_EXTERNALS),
                Externals.class);
    }

    /**
     * Get specific external. GET /externals/:external_id
     */
    public Externals getExternal(String id) {
        StringBuilder url = new StringBuilder(SEGMENT_EXTERNALS);
        url.append("/");
        url.append(id);

        return fromString(client.get(url.toString()),
                Externals.class);

    }
}
