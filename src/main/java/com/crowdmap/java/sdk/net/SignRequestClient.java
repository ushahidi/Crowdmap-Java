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

package com.crowdmap.java.sdk.net;

import com.crowdmap.java.sdk.ApiKey;
import com.crowdmap.java.sdk.CrowdmapApiKeys;
import com.crowdmap.java.sdk.RequestVariable;
import com.crowdmap.java.sdk.util.Util;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;

/**
 * Heavily based on the Orignal UrlConnectionClient from the retrofit project.
 *
 * This is to get api signature added to every request.
 */
public class SignRequestClient extends UrlConnectionClient implements Client {

    static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s

    static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s

    CrowdmapApiKeys mCrowdmapApiKeys;

    final OkHttpClient client;

    public SignRequestClient(OkHttpClient client, CrowdmapApiKeys crowdmapApiKeys) {
        this.client = client;
        this.mCrowdmapApiKeys = crowdmapApiKeys;
    }

    public SignRequestClient(CrowdmapApiKeys crowdmapApiKeys) {
        this(generateDefaultOkHttp(), crowdmapApiKeys);
    }

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        return client;
    }

    @Override
    protected HttpURLConnection openConnection(Request request) throws IOException {
        final URL url = new URL(request.getUrl());
        final String path = url.getPath().substring(
                ICrowdmapConstants.API_VERSION.length()
                        + 1); // Remove the version number from the returned path. plus 1 to take care of the leading slash
        final @ApiKey String key = Util
                .generateSignature(request.getMethod(), path, mCrowdmapApiKeys.getPublicKey(),
                        mCrowdmapApiKeys.getPrivateKey());

        final RequestVariable requestVariable = new RequestVariable("apikey", key);

        return client.open(new URL(request.getUrl() + requestVariable.toString()));
    }

}
