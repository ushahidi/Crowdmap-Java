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

import com.crowdmap.java.sdk.json.Response;

import retrofit.RetrofitError;

/**
 * Error delegate
 */
public interface ErrorDelegate {

    // No Network
    public void noNetworkError(RetrofitError error);

    // HTTP 401
    public void notAuthorizedError(RetrofitError error, Response response);

    // HTTP 400-500
    public void invalidUrlError(RetrofitError error);

    // HTTP 500-600
    public void serverError(RetrofitError error);

    // HTTP 200 OK but unknown error.
    public void generalError(RetrofitError error, Response response);
}
