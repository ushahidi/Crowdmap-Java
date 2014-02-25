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

import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.service.api.ApiCallback;
import com.crowdmap.java.sdk.service.api.ExternalInterface;

import retrofit.RestAdapter;

/**
 * External service
 */
public class ExternalService extends CrowdmapService<ExternalService> {

    private final ExternalInterface mExternalInterface;

    public ExternalService(RestAdapter restAdapter) {
        super(restAdapter);
        mExternalInterface = restAdapter.create(ExternalInterface.class);
    }

    /**
     * Create a new external
     *
     * @param serviceId The external form
     * @return The created external
     */
    public void createExternal(long serviceId, String idOnService,
            @SessionToken String sessionToken, ApiCallback<Externals> callback) {
        checkId(serviceId);
        mExternalInterface.createExternal(serviceId, idOnService, sessionToken, callback);
    }

    /**
     * Get specific external. GET /externals/:external_id
     *
     * @param externalId The external ID
     * @return The externals
     */
    public void getExternal(long externalId, ApiCallback<Externals> callback) {
        checkId(externalId);
        mExternalInterface.getExternal(externalId, limit, offset, callback);
    }
}
