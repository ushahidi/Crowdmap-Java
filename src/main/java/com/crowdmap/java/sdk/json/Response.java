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

package com.crowdmap.java.sdk.json;

/**
 * The class represents the Main response returned as a result of a Crowdmap api call.
 */
public class Response {

    /**
     * URL to the next service
     */
    public String next;

    /**
     * URL to the current service
     */
    public String curr;

    /**
     * URL to the previous service
     */
    public String prev;

    public boolean success;

    /**
     * The error message returned as a result of an API call
     */
    public String error;

    public String message;

    /**
     * The status of the response
     */
    public int status;

    /**
     * The timestamp received from the server as a result of an API call
     */
    public long timestamp;

    /**
     * The query count.
     */
    public int qcount;

    /**
     * The time it took the request to load
     */
    public String elapsed;

    /**
     * Minimum rate limit
     */
    public int limitMin;

    /**
     * Maximum rate limit
     */
    public int limitMax;

}
