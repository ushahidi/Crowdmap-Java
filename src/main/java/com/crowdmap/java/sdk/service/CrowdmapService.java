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

import retrofit.RestAdapter;

/**
 * Base crowdmap service class
 */
public abstract class CrowdmapService<T> {

    protected int limit = 10;

    protected int offset = 0;

    RestAdapter restAdapter;

    public CrowdmapService(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    public RestAdapter getRestAdapter() {
        return restAdapter;
    }

    /**
     * Check that id is not null and not empty
     *
     * @param id The ID to check.
     */
    protected void checkId(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Id cannot be zero");
        }
    }

    @SuppressWarnings("unchecked")
    public T limit(int limit) {
        if (limit > 0) {
            this.limit = limit;
        }
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T offset(int offset) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Requires that a limit be set.");
        }

        this.offset = offset;

        return (T) this;
    }

}
