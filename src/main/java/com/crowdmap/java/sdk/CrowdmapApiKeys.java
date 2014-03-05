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

/**
 * Both public and private api key
 */
public final class CrowdmapApiKeys {

    /**
     * private app key value *
     */
    public String privateKey;

    /**
     * public app key value *
     */
    public String publicKey;

    public CrowdmapApiKeys(String publicKey,String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }
}
