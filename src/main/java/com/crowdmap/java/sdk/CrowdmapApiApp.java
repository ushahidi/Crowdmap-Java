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

package com.crowdmap.java.sdk;

import com.crowdmap.java.sdk.service.UtilityService;
import com.crowdmap.java.sdk.util.ValidateUtil;

/**
 * Crowdmap Api app
 */
public class CrowdmapApiApp {

    CrowdmapApiModule module;

    public CrowdmapApiApp(String privateKey, String publicKey) {
        if (ValidateUtil.empty(publicKey)) {
            throw new IllegalArgumentException(
                    "Public key cannot be null or empty. Please provide a valid public key");
        }

        if (ValidateUtil.empty(privateKey)) {
            throw new IllegalArgumentException(
                    "Private key cannot be null or empty. Please provide a valid private key");
        }

        module = new CrowdmapApiModule(new ApiKeys(privateKey, publicKey));
    }

    public UtilityService utilityService() {
        return module.utilityService();
    }
}
