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
package com.crowdmap.java.sdk.net;

/**
 * Crowdmap constants for http related activities
 */
public interface ICrowdmapConstants {

	public String CHARSET_UTF8 = "UTF-8";

	public String CONTENT_TYPE_JSON = "application/json";

	public String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public String HOST_API = "api.crdmp3.com";

	public String API_VERSION = "v1";

	public String PROTOCOL_HTTPS = "https";

	public String PROTOCOL_HTTP = "http";

	public String API_URL = PROTOCOL_HTTP + "://" + HOST_API;
	
	public String USER_AGENT = "Crowdmap-Java/1.0.0";
	
	public String GZIP_DEFLATE = "gzip";
	
	public String REFERRER = "Referer";

	public String SEGMENT_MEDIA = "/media";

	public String SEGMENT_MAPS = "/maps";

	public String SEGMENT_LOCATIONS = "/locations";

	public String SEGMENT_POSTS = "/posts";

	public String SEGMENT_PEOPLE = "/people";

	public String SEGMENT_EXTERNALS = "/externals";

	public String SEGMENT_ABOUT = "/about";

	public String SEGMENT_HEARTBEAT = "/heartbeat";

	public String SEGMENT_PLACES_SEARCH = "/places/search";

}
