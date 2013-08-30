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

import com.crowdmap.java.sdk.CrowdmapException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.crowdmap.java.sdk.net.ICrowdmapConstants.DATE_FORMAT;

public class DateDeserializer implements JsonDeserializer<Date> {

    private static final SimpleDateFormat PARSER = new SimpleDateFormat(
            DATE_FORMAT, Locale.US);

    @Override
    public Date deserialize(JsonElement arg0, Type arg1,
            JsonDeserializationContext arg2) throws JsonParseException {
        try{
        return new Date(arg0.getAsLong() * 1000);
        }catch(NumberFormatException e){
            return null;
        }
    }

}
