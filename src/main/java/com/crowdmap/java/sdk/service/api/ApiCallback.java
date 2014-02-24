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

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * ApiCallback is a parameterized class that handles pagination
 */
public abstract class ApiCallback<T> implements Callback<T> {

    private boolean isNextPage = false;

    private boolean isCancelled = false;

    private boolean isFinished;

    private ErrorDelegate mErrorDelegate;

    private ApiStatusDelegate mApiStatusDelegate;

    public ApiCallback(ApiStatusDelegate statusDelegate, ErrorDelegate errorDelegate) {
        this.mApiStatusDelegate = statusDelegate;
        this.mErrorDelegate = errorDelegate;
    }

    private void finishLoading() {
        setFinished(true);
        mApiStatusDelegate.onCallbackFinished();
    }


    /**
     * onFailure is a way to handle a failure instead using the default error handling
     *
     * @return true if the failure was handled, false otherwise
     */
    public boolean onFailure(RetrofitError retrofitError) {
        return false;
    }

    /**
     * Returns the default Error Delegate
     */
    public ErrorDelegate getErrorDelgate() {
        return mErrorDelegate;
    }

    public ApiStatusDelegate getApiStatusDelegate() {
        return mApiStatusDelegate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * If you want caching and pagination, you must call this function using super or leave it
     * alone..
     */
    @Override
    public void success(T t, Response response) {
        // check if it's been cancelled or detached
        if (isCancelled || t == null) {
            return;
        }

        finishLoading();
    }

    /**
     * failure calls the correct method on the ErrorDelegate that's been set.
     */
    @Override
    public void failure(RetrofitError retrofitError) {
        // check if it's cancelled or detached
        if (isCancelled) {
            return;
        }

        finishLoading();

        // Return if the failure was already handled
        if (onFailure(retrofitError)) {
            return;
        }

        if (mErrorDelegate == null) {
            return;
        }

        if (retrofitError.isNetworkError()) {
            mErrorDelegate.noNetworkError(retrofitError);
        }

        com.crowdmap.java.sdk.json.Response crowdmapResponse = null;
        try {
            crowdmapResponse = (com.crowdmap.java.sdk.json.Response) retrofitError
                    .getBodyAs(com.crowdmap.java.sdk.json.Response.class);
        } catch (Exception exception) {
        }

        Response response = retrofitError.getResponse();
        if (response == null) {
            return;
        }

        if (response.getStatus() == 200) {
            mErrorDelegate.generalError(retrofitError, crowdmapResponse);
        } else if (response.getStatus() == 401) {
            mErrorDelegate.notAuthorizedError(retrofitError, crowdmapResponse);
        } else if (response.getStatus() >= 400 && response.getStatus() < 500) {
            mErrorDelegate.invalidUrlError(retrofitError);
        } else if (response.getStatus() >= 500 && response.getStatus() < 600) {
            mErrorDelegate.serverError(retrofitError);
        }
    }
}
