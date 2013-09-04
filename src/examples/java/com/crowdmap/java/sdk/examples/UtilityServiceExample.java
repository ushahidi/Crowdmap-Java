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
import com.crowdmap.java.sdk.model.form.PostForm;
import com.crowdmap.java.sdk.service.PostService;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.model.Post;
import com.crowdmap.java.sdk.json.Session;

import java.lang.System;
import java.util.Scanner;

/**
 * This example code will show you how to information about the Crowmap API version
 */
public class UtilityServiceExample {

    private Crowdmap crowdmap;

    public UtilityServiceExample(String pubKey, String privKey) {
        crowdmap  = new Crowdmap(pubKey, privKey);
    }

    /**
     * Get the version number of crowdmap
     */
    public void getAbout() {
        final String about = crowdmap.utilityService().about().toString();
        System.out.println(about);
    }

    /**
     * Check if crowdmap api service is up and running
     */
    public void hearbeat() {
        final String heartbeat = crowdmap.utilityService().hearbeat().toString();
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