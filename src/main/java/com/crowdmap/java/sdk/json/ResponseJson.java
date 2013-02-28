/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 *****************************************************************************/

package com.crowdmap.java.sdk.json;

/**
 * The class represents the Main response returned as a result of a Crowdmap api
 * call.
 * 
 * 
 */
public class ResponseJson {

	/**
	 * URL to the next resource
	 */
	public String next;

	/**
	 * URL to the current resource
	 */
	public String curr;

	/**
	 * URL to the previous resource
	 */
	public String prev;

	public boolean success;

	/**
	 * The error message returned as a result of an API call
	 */
	public String error;

	/**
	 * The status of the response
	 */
	public int status;

	/**
	 * The timestamp received from the server as a result of an API call
	 */
	public String timestamp;

	/**
	 * The query count.
	 */
	public int qcount;

}
