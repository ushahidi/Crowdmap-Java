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

package com.crowdmap.java.sdk.service.api;

import com.crowdmap.java.sdk.MockServerResponse;
import com.crowdmap.java.sdk.SessionToken;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.Externals;
import com.crowdmap.java.sdk.model.External;

import retrofit.http.Field;
import retrofit.http.Query;

/**
 * Mock external service
 */
public class MockExternalService implements ExternalInterface {

    MockServerResponse mMockServerResponse;

    public MockExternalService(MockServerResponse mMockServerResponse) {
        this.mMockServerResponse = mMockServerResponse;
    }

    @Override
    public Externals getExternal(@Query("external_id") long externalId, @Query("limit") int limit,
            @Query("offset") int offset) {
        for (External external : mMockServerResponse.getExternals().getExternals()) {
            if (external.getId() == externalId) {
                return mMockServerResponse.getExternals();
            }
        }
        return null;
    }

    @Override
    public Externals createExternal(@Field("service_id") long serviceId,
            @Field("id_on_service") String idOnService,
            @Field("session_token") @SessionToken String sessionToken) {
        External external = new External();
        external.setId(1);
        external.setServiceId(serviceId);
        external.setIdOnService(idOnService);
        external.setContent(
                "Just completed a 3.94 km bike with @RunKeeper. Check it out! http://t.co/IEB4h7wgb1 #RunKeeper");
        external.setDateTime(new Date(1376023573));
        external.setEmbedHtml(
                "<blockquote class=\"twitter-tweet\"><p>Just completed a 3.94 km bike with <a href=\"https://twitter.com/RunKeeper\">@RunKeeper</a>. Check it out! <a href=\"http://t.co/IEB4h7wgb1\">http://t.co/IEB4h7wgb1</a> <a href=\"https://twitter.com/search?q=%23RunKeeper&amp;src=hash\">#RunKeeper</a></p>&mdash; Tetsuya Sato - 佐藤哲也 (@satetsu) <a href=\"https://twitter.com/satetsu/statuses/365695488227409921\">August 9, 2013</a></blockquote>\n");
        external.setFaviconUrl("https://twitter.com/favicons/faviico");

        Externals externals = mMockServerResponse.addExternaList(external);

        return externals;
    }
}
