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

package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Followers;
import com.crowdmap.java.sdk.json.MapTags;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Owner;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.model.form.MapForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Map service
 */
public class MapServiceTest extends BaseServiceTest {

    MapService mapService;

    long mapId;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mapService = crowdmap.mapService();
        session = loginService.login(loginForm);
        mapId = 30;
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        mapService = null;
    }

    @Test
    public void testGetMaps() throws Exception {
        Maps map = mapService.getMaps();
        assertNotNull(map);
        assertNotNullOrEmpty("No maps", map.getMaps());
        assertNotNull(map.getMaps().get(0).getId());
    }

    @Test
    public void testGetMapsAsAuthenicatedUser() throws Exception {
        mapService.setSessionToken(session.getSessionToken());
        Maps map = mapService.getMapsAsAuthenicatedUser();
        assertNotNull(map);
        assertNotNullOrEmpty("No maps", map.getMaps());
        assertNotNull(map.getMaps().get(0).getId());
    }

    @Test
    public void testGetMapByID() throws Exception {
        Maps map = mapService.getMap(mapId);
        assertNotNull(map);
        assertNotNullOrEmpty("No maps", map.getMaps());
        assertNotNull(map.getMaps().get(0).getId());
    }

    @Test
    public void testGetMapAsAuthenicatedUser() throws Exception {
        mapService.setSessionToken(session.getSessionToken());
        Maps map = mapService.getMapAsAuthenicatedUser(mapId);
        assertNotNull(map);
        assertNotNullOrEmpty("No maps", map.getMaps());
        assertNotNull(map.getMaps().get(0).getId());
    }

    @Test
    public void testGetFollowers() throws Exception {
        Followers followers = mapService.getFollowers(mapId);
        assertNotNull(followers);
        assertNotNullOrEmpty("", followers.getFollowers());
    }

    @Test
    public void testGetCollaborators() throws Exception {
        Collaborators collaborators = mapService.getCollaborators(mapId);
        assertNotNull(collaborators);
    }

    @Test
    public void testGetTags() throws Exception {
        MapTags mapTags = mapService.getTags("externado");
        assertNotNull(mapTags);
        assertNotNullOrEmpty("No maps tags", mapTags.getMapsTags());
    }

}
