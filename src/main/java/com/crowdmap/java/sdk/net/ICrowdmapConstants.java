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
package com.crowdmap.java.sdk.net;

/**
 * Crowdmap constants for http related activities
 */
public interface ICrowdmapConstants {

    public static final String VERSION = "1.0.0";

    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String CONTENT_TYPE_JSON = "application/json";

    public static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String HOST_API = "api.crdmp3.com";

    public static final String API_VERSION = "v1";

    public static final String PROTOCOL_HTTPS = "https";

    public static final String API_KEY_PARAM = "apikey";

    public static final String SESSION = "session";

    public static final String LIMIT = "limit";

    public static final String OFFSET = "offset";

    public static final String CROWDMAP_API = HOST_API + "/" + API_VERSION;

    public static final String USER_AGENT = "Crowdmap-Java-SDK/" + VERSION;

    public static final String GZIP_DEFLATE = "gzip";

    public static final String REFERRER = "Referer";

    public static final String SEGMENT_MEDIA = "/media/";

    public static final String SEGMENT_MAPS = "/maps/";
    public static final String SEGMENT_MAP = "/map/";
    public static final String SEGMENT_COMMENTS = "/comments/";

    public static final String SEGMENT_OWNER = "/owner/";

    public static final String SEGMENT_FOLLOWERS = "/followers/";

    public static final String SEGMENT_MAPS_FOLLOWING = SEGMENT_MAPS + "following/";

    public static final String SEGMENT_LOCATIONS = "/locations/";

    public static final String SEGMENT_POSTS = "/posts/";

    public static final String SEGMENT_POST = "/post/";

    public static final String SEGMENT_PEOPLE = "/people/";

    public static final String SEGMENT_EXTERNALS = "/externals/";

    public static final String SEGMENT_ABOUT = "/about/";

    public static final String SEGMENT_HEARTBEAT = "/heartbeat/";

    public static final String SEGMENT_PLACES_SEARCH = "/places/search/";

    public static final String SEGMENT_TAGS = "/tags/";

    public static final String SEGMENT_SESSION = "/session";

    public static final String SEGMENT_LOGIN = "/login/";

    public static final String SEGMENT_USERS = "/users/";
    public static final String SEGMENT_USER = "/user/";
    public static final String SEGMENT_AVATAR = "/avatar/";

    public static final String SEGMENT_FOLLOWS = "/follows/";

    public static final String SEGMENT_MAPS_COLLABORATING = SEGMENT_MAPS + "collaborating/";

    public static final String SEGMENT_MAPS_OWNS = SEGMENT_MAPS + "owns/";

    public static final String SEGMENT_MAPS_ASSOCIATED = SEGMENT_MAPS + "associated/";

    public static final String SEGMENT_NOTIFICATIONS = "/notifications/";

    public static final String SEGMENT_COLLABORATORS = "/collaborators/";

    public static final String SEGMENT_BANNER = "/banner/";

    public static final String SEGMENT_SETTINGS = "/settings/";

    public static final String SEGMENT_OEMBED = "/oembed/";

    public static final String SEGMENT_REGISTEREDMAP = "/registeredmap/";

    public static final String SEGMENT_MODERATE = "/moderate/";

    public static final String SEGMENT_COMMENT = "/comment/";

    public static final String SEGMENT_LIKE = "/like/";
}
