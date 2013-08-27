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
 * Deserialize users based on what's returned
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
