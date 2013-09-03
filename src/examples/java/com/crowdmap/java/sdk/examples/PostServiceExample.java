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
import com.crowdmap.java.sdk.service.PostService;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.model.Post;
import com.crowdmap.java.sdk.json.Session;

import java.lang.System;
import java.util.Scanner;

/**
 * This example code will show you how to pull post as unauthenticated user and also show you
 *
 * how to make a post as an authenticated user.
 */
public class PostServiceExample {

    private Crowdmap crowdmap;

    private PostService mPostService;

    public PostServiceExample(String pubKey, String privKey) {
        crowdmap  = new Crowdmap(pubKey, privKey);
    }

    /**
     * Attempt to login
     *
     * @return Session
     */
    public Session login() {
        System.out.println("Enter your crowdmap username. Its mostly your username:");
        Scanner scanIn = new Scanner(System.in);
        final String username = scanIn.nextLine();
        System.out.println("Enter your crowdmap password:");
        final String password = scanIn.nextLine();
        return crowdmap.login(username, password);
    }

    public void getPosts() {
        mPostService = crowdmap.postService();
        Posts posts = mPostService.getPosts();
        System.out.println(posts.toString());

        for(Post post : posts.getPosts()) {
            System.out.print(post.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        if(args.length == 0 || args.length < 1) {

            System.out.println("Please provide your apps public key and private key respectively.");
        } else {
            PostServiceExample example  = new PostServiceExample(args[0], args[1]);
            example.getPosts();
        }
    }
}