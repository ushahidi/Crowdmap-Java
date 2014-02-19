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

import com.crowdmap.java.sdk.ApiKeys;
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.model.form.ExternalForm;

import static com.crowdmap.java.sdk.net.CrowdmapHttpClient.METHOD_GET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.LIMIT;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.OFFSET;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.SEGMENT_EXTERNALS;

/**
 * External service
 */
public class ExternalService extends CrowdmapService {

    public ExternalService(ApiKeys keys) {
        super(keys);
    }

    /**
     * Create a new external
     *
     * @param form The external form
     * @return The external
     */
    public Externals createExternal(ExternalForm form) {
        validateSession();
        return fromString(client.post(SEGMENT_EXTERNALS, form.getParameters()),
                Externals.class);
    }

    /**
     * Get specific external. GET /externals/:external_id
     *
     * @param externalId The external ID
     * @return The externals
     */
    public Externals getExternal(long externalId) {
        checkId(externalId);
        StringBuilder url = new StringBuilder(SEGMENT_EXTERNALS);
        url.append(externalId);
        url.append("/");
        setApiKey(METHOD_GET, url.toString());
        final String json = client.get(url.toString());
        return fromString(json, Externals.class);

    }

    public ExternalService limit(int limit) {
        if (limit > 0) {
            getHttpClient().setRequestParameters(LIMIT, String.valueOf(limit));
        }
        return this;
    }

    public ExternalService offset(int offset) {
        if (getHttpClient().getRequestParameters().containsKey(LIMIT)) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        getHttpClient().setRequestParameters(OFFSET, String.valueOf(offset));
        return this;
    }

    @Override
    public ExternalService setSessionToken(String sessionToken) {
        if ((sessionToken == null) || (sessionToken.length() == 0)) {
            throw new IllegalArgumentException("Session token cannot be null or empty");
        }
        getHttpClient().setSessionToken(sessionToken);
        return this;
    }
}
