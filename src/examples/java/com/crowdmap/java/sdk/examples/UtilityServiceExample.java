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

package com.crowdmap.java.sdk.examples;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.CrowdmapApiApp;
import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System;

import retrofit.RetrofitError;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.CHARSET_UTF8;

/**
 * This example code will show you how to information about the Crowmap API version
 */
public class UtilityServiceExample {

    private Crowdmap crowdmap;

    private CrowdmapApiApp mApiApp;

    public UtilityServiceExample(String pubKey, String privKey) {
        crowdmap  = new Crowdmap(pubKey, privKey);
        mApiApp = new CrowdmapApiApp(privKey,pubKey);
    }

    /**
     * Get the version number of crowdmap
     */
    public void getAbout() {
       // final String about = crowdmap.utilityService().about().toString();
        //System.out.println(about);
        System.out.println("from dagger");
        try{
        System.out.println(mApiApp.utilityService().about().toString());
    } catch (RetrofitError e) {
            try {
                System.out.println(streamToString(e.getResponse().getBody().in()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public String streamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(is, CHARSET_UTF8), 8192);
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /**
     * Check if crowdmap api service is up and running
     */
    public void hearbeat() {
        final String heartbeat = mApiApp.utilityService().heartbeat().toString();
        System.out.println(heartbeat);
    }

    public static void main(String[] args) throws Exception {
        if(args.length == 0 || args.length < 1) {

            System.out.println("Please provide your apps public key and private key respectively.");
        } else {
            UtilityServiceExample example  = new UtilityServiceExample(args[0], args[1]);
            example.getAbout();
            example.hearbeat();
        }
    }
}