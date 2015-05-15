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

import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.Comment;
import com.crowdmap.java.sdk.model.Post;
import com.crowdmap.java.sdk.model.form.PostForm;
import com.crowdmap.java.sdk.service.PostService;

/**
 * This example code will show you how to pull post as unauthenticated user and also show you
 *
 * how to make a post as an authenticated user.
 */
public class PostServiceExample extends BaseServiceExample {

    PostService mPostService;

    String mUserName;
    String mPassword;
    public PostServiceExample(String pubKey, String privKey, String userName, String password) {
        super(pubKey, privKey);
        mPostService = mModule.postService();
        mUserName = userName;
        mPassword = password;
    }

    /**
     * Attempt to login
     *
     * @return Session
     */
    public Session login() {
        return mModule.sessionService().login(mUserName, mPassword);
    }


    /**
     * Get recent posts as anonymous user
     */
    public void getPosts() {

        Posts posts = mPostService.getPosts();
        //System.out.println(posts.toString());

        // Print the details of the post
        for (Post post : posts.getPosts()) {
            //System.out.println(post.toString());
        }
    }

    /**
     * Example on how to make paginated queries
     */
    public void getTwoPosts() {
        //mPostService = crowdmap.postService();
        Posts posts = mPostService.offset(0).limit(1).getPosts();
        System.out.println("Size " + posts.getPosts().size());
    }

    /**
     * Get comments on a post
     */
    public void getPost() {
        //mPostService = crowdmap.postService();
        Comments comments = mPostService.getPostComments(17097);
        for (Comment comment : comments.getComments()) {
            System.out.println(comment.toString());
        }
    }

    public void createPost() {

        // Set post fields for submission
        PostForm form = new PostForm();
        form.setMessage("Let's communication easy");
        form.setPublic(true);

        // Login to obtain the session token
        Session session = login();

        // Pass the session token for authenticated requests
        if (session != null) {

            // Create a new post
            Posts posts = mPostService.createPost(form, session.getSessionToken());

            //Print the details of the post
             for (Post post : posts.getPosts()) {
                System.out.println(post.toString());
             }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args.length < 1) {

            System.out.println("Please provide your apps public key and private key respectively.");
        } else {
            PostServiceExample example = new PostServiceExample(args[0], args[1], args[2], args[3]);
            example.getPosts();
            try {
                example.createPost();
            }catch(retrofit.RetrofitError error) {
                System.out.println("Messages: "+error.getBody().toString()+ " Reason "+error.getResponse().getReason());
            }

            try {
                example.getPost();
            }catch(retrofit.RetrofitError error) {
                System.out.println("Messages: "+error.getBody().toString()+ " Reason "+error.getResponse().getReason());
            }
            example.getTwoPosts();
        }
    }
}