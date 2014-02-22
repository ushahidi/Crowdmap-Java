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
import com.crowdmap.java.sdk.model.External;
import com.crowdmap.java.sdk.service.provider.ExternalInterface;

/**
 * External service
 */
public class ExternalService extends CrowdmapService<ExternalService> {

    private final ExternalInterface mExternalInterface;

    public ExternalService(ExternalInterface externalInterface) {
        mExternalInterface = externalInterface;
    }
    /**
     * Create a new external
     *
     * @param External The external form
     * @return The created external
     */
    public Externals createExternal(External external) {
        return mExternalInterface.createExternal(external, getSessionToken());
    }

    /**
     * Get specific external. GET /externals/:external_id
     *
     * @param externalId The external ID
     * @return The externals
     */
    public Externals getExternal(long externalId) {
        checkId(externalId);
        StringBuilder url = new StringBuilder(String.valueOf(externalId));
        url.append("/");
        return mExternalInterface.getExternal(url.toString(), limit, offset);
    }
}
