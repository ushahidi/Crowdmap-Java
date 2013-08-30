package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.MapTags;
import com.crowdmap.java.sdk.json.Maps;
import com.crowdmap.java.sdk.json.Posts;
import com.crowdmap.java.sdk.json.Session;
import com.crowdmap.java.sdk.model.MapForm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Map service
 */
public class MapServiceTest extends BaseServiceTest {

    MapService mapService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mapService = crowdmap.mapService();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        mapService = null;
    }

    @Test
    public void testGetMaps() throws Exception {

    }

    @Test
    public void testGetMapsAsAuthenicatedUser() throws Exception {

    }

    @Test
    public void testGetMap() throws Exception {

    }

    @Test
    public void testGetMapAsAuthenicatedUser() throws Exception {

    }

    @Test
    public void testGetMapOwner() throws Exception {

    }

    @Test
    public void testGetFollowers() throws Exception {

    }

    @Test
    public void testGetCollaborators() throws Exception {

    }

    @Test
    public void CreateMapWithBannerUrlAndAvatarUrlSet() throws Exception {
        MapForm form = new MapForm();
        session = loginService.login(loginForm);
        form.setName("Crowdmap Java SDK Map");
        form.setSubdomain("crowdmapsdkmap");
        form.setBannerUrl("http://i.imgur.com/rZSVZNI.jpg");
        form.setAvatarUrl("http://www.gravatar.com/avatar/14be1d2463de4c1acc8b5a5f4d4eef70.png");
        form.setDescription("Crowdmap Java SDK Test Map");
        form.setPublic(true);
        form.setModeration(MapForm.Moderation.Auto);
        mapService.setSessionToken(session.getSessionToken());
        //Maps maps = mapService.createMap(form);
        //assertNotNull(maps);
    }

    @Test
    public void testGetTags() throws Exception {
        MapTags mapTags = mapService.getTags("book");
        assertNotNull(mapTags);
        assertNotNullOrEmpty("No maps tags", mapTags.getMapsTags());
    }

    @Test
    public void testGetPostOnMap() throws Exception {
        Posts posts = mapService.getPostOnMap(2006);
        assertNotNull(posts);
        assertNotNullOrEmpty("Post is empty", posts.getPosts());
    }

    @Test
    public void testGetPostOnMapByTag() throws Exception {
        Posts posts = mapService.getPostOnMapByTag(2006, "book");
        assertNotNull(posts);
        assertNotNullOrEmpty("Post is empty", posts.getPosts());
    }
}
