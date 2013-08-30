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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.model.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Deserialize users based on what's returned.
 */
public class UsersDeserializer implements JsonDeserializer<List<User>>{


    @Override
    public List<User> deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        List<User> users = new ArrayList<User>();
        if(json.isJsonArray()) {
            for (JsonElement e : json.getAsJsonArray()) {
                users.add((User) context.deserialize(e, User.class));
            }
        } else if(json.isJsonObject()){
            users.add((User) context.deserialize(json, User.class));
        } else {
            throw new CrowdmapException("Unexpected JSON type"+json.getClass());
        }

        return users;
    }
}
