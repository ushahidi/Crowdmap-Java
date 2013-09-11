package com.crowdmap.java.sdk.service;

import com.crowdmap.java.sdk.json.Media;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for Media service
 */
public class MediaServiceTest extends BaseServiceTest {

    MediaService mMediaService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mMediaService = crowdmap.mediaService();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testGetMedia() throws Exception {
        Media media = mMediaService.getMedia();
        assertNotNull(media);
    }

    @Test
    public void testGetMedia1() throws Exception {

    }

    @Test
    public void testCreateMedia() throws Exception {

    }

    @Test
    public void testDeleteMedia() throws Exception {

    }
}
