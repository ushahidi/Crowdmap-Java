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
package com.crowdmap.java.sdk.resource;

import com.crowdmap.java.sdk.json.ExternalsJson;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_EXTERNALS;

/**
 * Externals service
 */
public class ExternalsResource extends CrowdmapResource {

    public ExternalsResource(CrowdmapHttpClient client) {
        super(client);
    }

    /**
     * Get all externals. GET /externals
     */
    public ExternalsJson getExternals() {
        return fromString(client.get(SEGMENT_EXTERNALS),
                ExternalsJson.class);
    }

    /**
     * Get specific external. GET /externals/:external_id
     */
    public ExternalsJson getExternal(String id) {
        StringBuilder url = new StringBuilder(SEGMENT_EXTERNALS);
        url.append("/");
        url.append(id);

        return fromString(client.get(url.toString()),
                ExternalsJson.class);

    }
}
