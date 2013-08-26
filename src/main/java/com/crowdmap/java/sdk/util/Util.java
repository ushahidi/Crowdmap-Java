package com.crowdmap.java.sdk.util;

import java.io.UnsupportedEncodingException;
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
     * @param method The HTTP method being executed
     * @param uri The uri segement of the crowdmap API
     * @param publicKey The application public key
     * @param privateKey The application private key used as the HMAC's encryption cipher
     * @return
     */
    public static String generateSignature(String method, String uri, String publicKey, String privateKey) {

        long timestamp = Math.round(new Date().getTime() / 1000);
        String requestMethod = method.toUpperCase();
        String hashIt = requestMethod + "\n" + timestamp + "\n" + uri + "\n";
        byte[] keyBytes = privateKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(keyBytes, ENCRYPTION_TYPE);

        Mac mac = null;
        try {
            mac = Mac.getInstance(ENCRYPTION_TYPE);
            mac.init(secretKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        byte[] text = hashIt.getBytes();
        StringBuilder builder = new StringBuilder("A");
        builder.append(publicKey);

        byte[] digest = mac.doFinal(text);
        BigInteger hash = new BigInteger(1, digest);
        String hashed = hash.toString(16);
        if(hashed.length() % 2 != 0)
            hashed = "0" + hashed;
        builder.append(hashed);

        return builder.toString();
    }
}
