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

import com.crowdmap.java.sdk.json.About;
import com.crowdmap.java.sdk.json.Collaborators;
import com.crowdmap.java.sdk.json.Comments;
import com.crowdmap.java.sdk.json.Posts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the various
 */
public class CrowdmapServiceTest extends BaseServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAboutDeserialization() throws Exception {
        String aboutString = "{\n"
                + "    \"version\": 1,\n"
                + "    \"limit_min\": 0,\n"
                + "    \"limit_max\": 1000,\n"
                + "    \"success\": true,\n"
                + "    \"status\": 200,\n"
                + "    \"timestamp\": 1375336265,\n"
                + "    \"qcount\": 2,\n"
                + "    \"elapsed\": \"0.0458s\"\n"
                + "}";

        About about = CrowdmapService.fromString(aboutString, About.class);
        assertNotNull(about);
        assertEquals(1, about.getVersion());
        assertEquals(true, about.isSuccess());
    }

    @Test
    public void testCollaboratorsDeserialization() throws Exception {
        String json = "{\"maps_collaborators\":[{\"map_id\": 1910,\n"
                + "            \"users\": [\n"
                + "                {\n"
                + "                    \"user_id\": 3,\n"
                + "                    \"crowdmap_id\": \"eoAKIIKZLYW6RdvTK5IbJ9QCSuJKnNb8B5I75kBHUjn7tD13k7oSJ7ifWmrxGNFsnEQCvqB1OJqbj1ovDD8bKGMVWTn5ggQ7P16ty3R6KYaNpvXhF3gF4K0ZFnwsqTxM\",\n"
                + "                    \"crowdmap_id_h\": \"8be2ac7a1ce39e06e7043c02e23a1438\",\n"
                + "                    \"username\": \"brianherbert\",\n"
                + "                    \"name\": \"Brian Herbert\",\n"
                + "                    \"bio\": \"One of the men behind the curtain.\",\n"
                + "                    \"plus\": true,\n"
                + "                    \"baselayer\": \"crowdmap_cucumber\",\n"
                + "                    \"instagram_auto_post\": true,\n"
                + "                    \"twitter_auto_post\": false,\n"
                + "                    \"date_registered\": 1363603003,\n"
                + "                    \"banned\": \"0\",\n"
                + "                    \"avatar\": \"\\/\\/b25c7ada827abcbc0630-5454a9e6f7100566866dd221e5013c79.ssl.cf2.rackcdn.com\\/51b14da2c91ab2.71208892_c.png\"\n"
                + "                }\n"
                + "            ],\n"
                + "            \"user_id\": 3}]}";
        Collaborators collaborators = CrowdmapService.fromString(json, Collaborators.class);
        assertNotNull(collaborators);
        assertEquals(1910, collaborators.getCollaborators().get(0).getMapId());
        assertEquals(3, collaborators.getCollaborators().get(0).getUsers().get(0).getId());
        assertEquals("brianherbert",
                collaborators.getCollaborators().get(0).getUsers().get(0).getUsername());
    }

    @Test
    public void testCommentDeserialization() throws Exception {
        String json = "";
        Comments comments = CrowdmapService.fromString(json, Comments.class);
        assertNotNull(comments);
    }

    @Test
    public void testPostsDeserialization() throws Exception {
        String json = "{\"posts\":[{\"externals\":[],\"locations\":[{\"location_id\":21077,\"fsq_venue_id\":\"\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-122.40641784668,37.785835266113]},\"name\":\"\",\"region\":\"\"}],\"maps\":[],\"media\":[],\"post_id\":800,\"users\":[{\"user_id\":2,\"crowdmap_id\":\"8bcd236563e61dfd3b85d16ddcb1bbb3cc8a3d176aafd397e80a7de8e89c563aafa91cfb272578be5625f5a96be0af5803765a90210ec7c61cd195f82d261532\",\"crowdmap_id_h\":\"b753d5eb1bf2237cefb5b5fe4b42bef4\",\"username\":\"evansims\",\"name\":\"Evan Sims\",\"bio\":\"Senior Developer at Ushahidi. \\u2014 A software craftsman from the mid-west. \\u2014 #Entrepreneur, #designer, #minimalist, #caffeine enthusiast. \\u2014 http:\\/\\/evansims.com\\/about\\/\",\"plus\":true,\"baselayer\":\"crowdmap_satellite\",\"instagram_auto_post\":false,\"twitter_auto_post\":true,\"twitter_auto_post_retweets\":true,\"date_registered\":1363602996,\"banned\":false,\"avatar\":\"\\/\\/b25c7ada827abcbc0630-5454a9e6f7100566866dd221e5013c79.ssl.cf2.rackcdn.com\\/5216d928b0ff90.48923912_c.gif\",\"badges\":[]}],\"owner_map_id\":0,\"media_id\":0,\"location_id\":21077,\"external_id\":0,\"externals_images_id\":0,\"message\":\"<p>Test.<\\/p>\",\"date_posted\":1377635313,\"public\":true,\"permissions\":{\"edit\":false,\"delete\":false},\"stub\":\"test\",\"tags\":[],\"likes\":[],\"comments\":[]}]}";
        Posts post = CrowdmapService.fromString(json, Posts.class);
        assertNotNull(post);
        assertEquals(800,post.getPosts().get(0).getPostId());
        assertEquals("<p>Test.</p>",post.getPosts().get(0).getMessage());
        assertEquals(21077, post.getPosts().get(0).getLocations().get(0).getLocationId());
        assertEquals("Point", post.getPosts().get(0).getLocations().get(0).getGeometry().getType());
        assertEquals(-122.40641784668, post.getPosts().get(0).getLocations().get(0).getGeometry().getCoordinates()[0]);
        assertEquals(37.785835266113, post.getPosts().get(0).getLocations().get(0).getGeometry().getCoordinates()[0]);
        assertEquals("evansims",post.getPosts().get(0).getUsers().get(0).getUsername());
    }
}
