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
package com.crowdmap.java.sdk.service;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.API_URL;
import static com.crowdmap.java.sdk.net.ICrowdmapConstants.API_VERSION;

import com.crowdmap.java.sdk.net.CrowdmapHttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.crowdmap.java.sdk.json.Date;
import com.crowdmap.java.sdk.json.DateDeserializer;

/**
 * Base crowdmap service class
 */
public class BaseService {

	public static Gson gson;

	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new DateDeserializer());
		gson = builder.create();
	}

	protected CrowdmapHttpClient client;

	protected String apiUrl;

	/**
	 * Create a the task using the default {@link CrowdmapHttpClient}
	 * 
	 * @param client
	 *            The HttpClient
	 */
	public BaseService(CrowdmapHttpClient client) {

		if (client == null) {
			throw new IllegalArgumentException("Client cannot be null");
		}

		apiUrl = API_URL + "/" + API_VERSION + "/";
	}

	/**
	 * Create a service using a default {@link CrowdmapHttpClient}
	 * 
	 */
	public BaseService() {
		this(new CrowdmapHttpClient());
	}

	/**
	 * Get the configured HTTP client
	 * 
	 */
	public CrowdmapHttpClient getClient() {
		return client;
	}

	/**
	 * Deserialise the JSON string into Java objects representing the various
	 * Crowdmap models.
	 * 
	 * @param json
	 *            the json string to be converted
	 * @param cls
	 *            the class for the model
	 * @return The Object related to the Crowdmap API model
	 */
	public static <T> T fromString(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}
}
