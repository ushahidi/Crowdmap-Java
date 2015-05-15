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

package com.crowdmap.java.sdk.util;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Various utility methods
 */
public class Util {

    private static final String ENCRYPTION_TYPE = "HmacSHA1";

    /**
     * Generate Crowdmap's api key signature. This is required by all request to the Crowdmap API
     *
     * @param method     The HTTP method being executed
     * @param uri        The uri segement of the crowdmap API
     * @param publicKey  The application public key
     * @param privateKey The application private key used as the HMAC's encryption cipher
     */
    public static String generateSignature(String method, String uri, String publicKey,
            String privateKey) {

        long timestamp = Math.round(new Date().getTime() / 1000);
        String requestMethod = method.toUpperCase();
        String hashIt = requestMethod + "\n" + timestamp + "\n" + uri + "\n";
        byte[] keyBytes = privateKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(keyBytes, ENCRYPTION_TYPE);

        Mac mac = null;
        try {
            mac = Mac.getInstance(ENCRYPTION_TYPE);
            mac.init(secretKey);
        } catch (NoSuchAlgorithmException  e ) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] text = hashIt.getBytes();
        StringBuilder builder = new StringBuilder("A");
        builder.append(publicKey);

        byte[] digest = mac.doFinal(text);
        BigInteger hash = new BigInteger(1, digest);
        String hashed = hash.toString(16);
        if (hashed.length() % 2 != 0) {
            hashed = "0" + hashed;
        }
        builder.append(hashed);

        return builder.toString();
    }

}
