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

package com.crowdmap.java.sdk.mock;

import com.crowdmap.java.sdk.net.ICrowdmapConstants;

public enum Endpoints {
    PRODUCTION("Production", ICrowdmapConstants.CROWDMAP_API),
    MOCK_MODE("MockCrowdmap Mode", "mock://");

    public final String name;
    public final String url;

    Endpoints(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override public String toString() {
        return name;
    }

    public static Endpoints from(String endpoint) {
        for (Endpoints value : values()) {
            if (value.url != null && value.url.equals(endpoint)) {
                return value;
            }
        }
        return null;
    }

    public static boolean isMockMode(String endpoint) {
        return from(endpoint) == MOCK_MODE;
    }
}