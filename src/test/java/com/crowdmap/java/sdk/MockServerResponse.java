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

import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.json.OEmbed;
import com.crowdmap.java.sdk.json.RegisteredMap;
import com.crowdmap.java.sdk.json.Response;
import com.crowdmap.java.sdk.model.Collaborator;
import com.crowdmap.java.sdk.model.External;
import com.crowdmap.java.sdk.model.Follower;
import com.crowdmap.java.sdk.model.Geometry;
import com.crowdmap.java.sdk.model.Location;
import com.crowdmap.java.sdk.model.Map;
import com.crowdmap.java.sdk.model.MapSetting;
import com.crowdmap.java.sdk.model.Media;
import com.crowdmap.java.sdk.model.Notification;
import com.crowdmap.java.sdk.model.Permission;
import com.crowdmap.java.sdk.model.Post;
import com.crowdmap.java.sdk.model.Tag;
import com.crowdmap.java.sdk.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Server Response
 */
public class MockServerResponse {

    Response mResponse;

    About mAbout;

    Collaborator mCollaborator;

    External mExternal;

    Follower mFollower;

    Geometry mGeometry;

    Location mLocation;

    Permission mPermission;

    Map mMap;

    MapSetting mMapSetting;

    Media mMedia;

    Notification mNotification;

    Post mPost;

    Tag mTag;

    User mUser;

    OEmbed mOEmbed;

    Externals mExternals;

    RegisteredMap mRegisteredMap;

    List<User> mUsers;

    List<External> mExternalList;

    public MockServerResponse() {
        mExternalList = new ArrayList<External>();
    }

    private void initAbout() {
        mAbout = new About();
        mAbout.setEnvironment("Demo");
        mAbout.setVersion(1);
        mAbout.setLimitMax(1000);
        mAbout.setLimitMin(0);
        mAbout.setStatus(200);
        mAbout.setTimestamp(new Date(1375336265));
        mAbout.setQcount(2);
    }

    private void initResponse() {
        mResponse = new Response();
        mResponse.setSuccess(true);
        mResponse.setStatus(200);
        mResponse.setTimestamp(new Date(1375336170));
        mResponse.setQcount(2);
        mResponse.setElapsed("0.1135s");
    }

    private void initOEmbed() {
        mOEmbed = new OEmbed();
        mOEmbed.setVersion(1.0f);
        mOEmbed.setType("rich");
        mOEmbed.setTitle("Henry's Post on Crowdmap");
        mOEmbed.setAuthorName("eyedol");
        mOEmbed.setUrl("https://crowdmap.com/user/eyedol");
    }

    private void initCollaborator() {
        mCollaborator = new Collaborator();
        mCollaborator.setId(1);
        mCollaborator.setMapId(1);
        mCollaborator.setUsers(getUsers());
    }

    private void initListUsers() {

        User brianherbert = new User();
        brianherbert.setId(3292);
        brianherbert.setCrowdmapId("12Y3vkSlgLKC4cxm5atkFzoBz1Eyjtzi");
        brianherbert.setCrowdmapIdH("f4d1f526e2fb3e10445d04737ce75faf");
        brianherbert.setUsername("brian");
        brianherbert.setName("brian herbert");
        brianherbert.setBaselayer("crowdmap_satellite");

        mUsers = new ArrayList<User>();
        mUsers.add(getUser());
        mUsers.add(brianherbert);
    }

    private void initUser() {
        mUser = new User();
        mUser.setId(3293);
        mUser.setCrowdmapId("12Y3vkSlgLKC4cxm5atkFzoBz1Eyjtzi");
        mUser.setCrowdmapIdH("f4d1f526e2fb3e10445d04737ce75faf");
        mUser.setUsername("eyedol");
        mUser.setName("henry");
        mUser.setBaselayer("crowdmap_satellite");
    }

    private void initExternal() {
        mExternal = new External();
        mExternal.setId(1);
        mExternal.setServiceId(1);
        mExternal.setIdOnService("365695488227409921");
        mExternal.setContent(
                "Just completed a 3.94 km bike with @RunKeeper. Check it out! http://t.co/IEB4h7wgb1 #RunKeeper");
        mExternal.setDateTime(new Date(1376023573));
        mExternal.setEmbedHtml(
                "<blockquote class=\"twitter-tweet\"><p>Just completed a 3.94 km bike with <a href=\"https://twitter.com/RunKeeper\">@RunKeeper</a>. Check it out! <a href=\"http://t.co/IEB4h7wgb1\">http://t.co/IEB4h7wgb1</a> <a href=\"https://twitter.com/search?q=%23RunKeeper&amp;src=hash\">#RunKeeper</a></p>&mdash; Tetsuya Sato - 佐藤哲也 (@satetsu) <a href=\"https://twitter.com/satetsu/statuses/365695488227409921\">August 9, 2013</a></blockquote>\n");
        mExternal.setFaviconUrl("https://twitter.com/favicons/faviico");
    }

    private void initListExternals() {
        External external = new External();
        external.setId(1);
        external.setServiceId(1);
        external.setIdOnService("365695488227409921");
        external.setContent(
                "Just completed a 3.94 km bike with @RunKeeper. Check it out! http://t.co/IEB4h7wgb1 #RunKeeper");
        external.setDateTime(new Date(1376023573));
        external.setEmbedHtml(
                "<blockquote class=\"twitter-tweet\"><p>Just completed a 3.94 km bike with <a href=\"https://twitter.com/RunKeeper\">@RunKeeper</a>. Check it out! <a href=\"http://t.co/IEB4h7wgb1\">http://t.co/IEB4h7wgb1</a> <a href=\"https://twitter.com/search?q=%23RunKeeper&amp;src=hash\">#RunKeeper</a></p>&mdash; Tetsuya Sato - 佐藤哲也 (@satetsu) <a href=\"https://twitter.com/satetsu/statuses/365695488227409921\">August 9, 2013</a></blockquote>\n");
        external.setFaviconUrl("https://twitter.com/favicons/faviico");
        mExternalList = new ArrayList<External>();
        mExternalList.add(getExternal());
        mExternalList.add(external);
    }

    private void initExternals() {
        mExternals = new Externals();
        mExternals.setExternals(getExternalList());
        Response response = getResponse();
        mExternals.setQcount(response.getQcount());
        mExternals.setStatus(response.getStatus());
        mExternals.setSuccess(response.isSuccess());
        mExternals.setElapsed(response.getElapsed());
    }

    private void initRegisteredMap() {
        mRegisteredMap = new RegisteredMap();
        mRegisteredMap.setRegistered(true);
        Response response = getResponse();
        mRegisteredMap.setQcount(response.getQcount());
        mRegisteredMap.setStatus(response.getStatus());
        mRegisteredMap.setSuccess(response.isSuccess());
        mRegisteredMap.setElapsed(response.getElapsed());
    }

    public RegisteredMap getRegisteredMap() {
        initRegisteredMap();
        return mRegisteredMap;
    }

    public Externals getExternals() {
        initExternals();
        return mExternals;
    }

    public List<External> getExternalList() {
        initListExternals();
        return mExternalList;
    }

    public Externals addExternaList(External external) {
        List<External> list = getExternalList();
        list.add(external);
        initExternal();
        Externals externals = getExternals();
        externals.setExternals(list);
        return externals;
    }

    public External getExternal() {
        initExternal();
        return mExternal;
    }


    public User getUser() {
        initUser();
        return mUser;
    }

    public List<User> getUsers() {
        initListUsers();
        return mUsers;
    }

    public Collaborator getCollaborator() {
        initCollaborator();
        return mCollaborator;
    }

    public OEmbed getOEmbed() {
        initOEmbed();
        return mOEmbed;
    }

    public Response getResponse() {
        initResponse();
        return mResponse;
    }

    public About getAbout() {
        initAbout();
        return mAbout;
    }
}
