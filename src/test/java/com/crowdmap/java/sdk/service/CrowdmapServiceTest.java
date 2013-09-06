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
import com.crowdmap.java.sdk.json.Media;
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
        String json = " {\"comments\":[{\"comment_id\":678,\"users\":[{\"user_id\":4,\"crowdmap_id\":\"K8HoFEFIN5JRp4a8K6XRxGjomLVH1snBBQXHw3hkW00v9xmQZmNNLi52P3Nq19daGpUcQ9O4JF0nZtnlGj3cZQ7L06E00LEiO31MnhCHNI82biiZ2eKyQkQ0NQAU6jT5\",\"crowdmap_id_h\":\"e4c4c42febb92a6264a4e9d80473884c\",\"username\":\"whiteafrican\",\"name\":\"Erik Hersman\",\"bio\":\"The @WhiteAfrican. Co-founder of Ushahidi and the iHub in Nairobi.\",\"plus\":true,\"baselayer\":\"crowdmap_cucumber\",\"instagram_auto_post\":true,\"twitter_auto_post\":false,\"twitter_auto_post_retweets\":false,\"date_registered\":1363603003,\"banned\":false,\"avatar\":\"\\/\\/www.gravatar.com\\/avatar\\/dd7a1c066790ac8dcab4ca43bb2ba9d9?r=PG&s=200&d=404\",\"badges\":[]}],\"post_id\":17097,\"map_id\":0,\"user_id\":4,\"comment\":\"<p>Ugh!<\\/p>\",\"date_posted\":1377838894,\"permissions\":{\"edit\":false,\"delete\":false},\"map\":null}],\"next\":false,\"curr\":\"https:\\/\\/api.crowdmap.com\\/v1\\/posts\\/17097\\/comments\\/?apikey=AmcoSiLOiRUXiiAPv4109d2a099ee87ba73f69b8d2e590d4f44c8df1a\",\"prev\":false,\"success\":true,\"status\":200,\"timestamp\":1378470104,\"qcount\":6,\"elapsed\":\"0.0506s\"} ";
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
        assertEquals(37.785835266113, post.getPosts().get(0).getLocations().get(0).getGeometry().getCoordinates()[1]);
        assertEquals("evansims",post.getPosts().get(0).getUsers().get(0).getUsername());
    }

    @Test
    public void testExternalsDeserialization() throws Exception {

    }

    @Test
    public void testMediaDeserialization() throws Exception {
        String json = "{\"media\":[{\"media_id\":644,\"users\":[{\"user_id\":1,\"crowdmap_id\":\"\",\"crowdmap_id_h\":\"d41d8cd98f00b204e9800998ecf8427e\",\"username\":\"anonymous\",\"name\":\"Anonymous\",\"bio\":\"\",\"plus\":false,\"baselayer\":\"crowdmap_satellite\",\"instagram_auto_post\":false,\"twitter_auto_post\":false,\"twitter_auto_post_retweets\":false,\"date_registered\":1363602996,\"banned\":\"0\"}],\"user_id\":1,\"lat\":null,\"lon\":null,\"file_datetime\":null,\"upload_datetime\":1377027689,\"file_location\":\"https:\\/\\/b25c7ada827abcbc0630-5454a9e6f7100566866dd221e5013c79.ssl.cf2.rackcdn.com\\/\",\"filename\":\"5213c65f1682f7.87923465_o.jpg\",\"width\":\"779\",\"height\":\"580\",\"filename_l\":\"5213c65f1682f7.87923465_o.jpg\",\"l_width\":\"779\",\"l_height\":\"580\",\"filename_s\":\"5213c65f1682f7.87923465_o.jpg\",\"s_width\":\"779\",\"s_height\":\"580\",\"filename_t\":\"5213c668d19c9624944926.jpg\",\"t_width\":\"134\",\"t_height\":\"100\",\"mime\":\"image\\/png\",\"dominant_color\":\"203010\",\"webp\":false}]}";
        Media media = CrowdmapService.fromString(json, Media.class);
        assertNotNull(media);
        assertEquals(644, media.getMedia().get(0).getId());
        assertEquals(1, media.getMedia().get(0).getUsers().get(0).getId());
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", media.getMedia().get(0).getUsers().get(0).getCrowdmapIdH());
        assertEquals("",media.getMedia().get(0).getUsers().get(0).getCrowdmapId());
        assertEquals("anonymous", media.getMedia().get(0).getUsers().get(0).getUsername());
        assertEquals("5213c65f1682f7.87923465_o.jpg", media.getMedia().get(0).getFilename());
        assertEquals("580", media.getMedia().get(0).getLargeHeight());
        assertEquals("779", media.getMedia().get(0).getLargeWidth());
        assertEquals("203010", media.getMedia().get(0).getDominantColor());
    }
}
