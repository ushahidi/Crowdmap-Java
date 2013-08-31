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

import java.io.Serializable;

/**
 * The class represents the Main response returned as a result of a Crowdmap api call.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 5923710369064540315L;

    /**
     * URL to the next service
     */
    private String next;

    /**
     * URL to the current service
     */
    private String curr;

    /**
     * URL to the previous service
     */
    private String prev;

    private boolean success;

    /**
     * The error message returned as a result of an API call
     */
    private String error;

    public String message;

    /**
     * The status of the response
     */
    private int status;

    /**
     * The timestamp received from the server as a result of an API call
     */
    private long timestamp;

    /**
     * The query count.
     */
    private int qcount;

    /**
     * The time it took the request to load
     */
    private String elapsed;

    /**
     * Minimum rate limit
     */
    private int limitMin;

    /**
     * Maximum rate limit
     */
    private int limitMax;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getQcount() {
        return qcount;
    }

    public void setQcount(int qcount) {
        this.qcount = qcount;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public int getLimitMin() {
        return limitMin;
    }

    public void setLimitMin(int limitMin) {
        this.limitMin = limitMin;
    }

    public int getLimitMax() {
        return limitMax;
    }

    public void setLimitMax(int limitMax) {
        this.limitMax = limitMax;
    }

    @Override
    public String toString() {
        return "Response{" +
                "next='" + getNext() + '\'' +
                ", curr='" + getCurr() + '\'' +
                ", prev='" + getPrev() + '\'' +
                ", success=" + isSuccess() +
                ", error='" + getError() + '\'' +
                ", message='" + getMessage() + '\'' +
                ", status=" + getStatus() +
                ", timestamp=" + getTimestamp() +
                ", qcount=" + getQcount() +
                ", elapsed='" + getElapsed() + '\'' +
                ", limitMin=" + getLimitMin() +
                ", limitMax=" + getLimitMax() +
                '}';
    }
}
