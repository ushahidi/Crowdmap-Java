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
package com.crowdmap.java.sdk.net.content;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a form body that can be used as a part of multi-part encoded entities for
 * making a mulit-part HTTP request
 */
public class Body {

    private List<Field> formField;

    public Body() {
        formField = new ArrayList<Field>();
    }

    /**
     * Add a form field for them to be submitted via a HTTP request
     *
     * @param name  The form field name
     * @param value The form field value
     */
    @SuppressWarnings("unchecked")
    public void addField(String name, Object value) {
        if (value == null) {
            return;
        }
        List<Object> list;
        if (!(value instanceof List)) {
            list = new ArrayList<Object>();
            list.add(value);
        } else {
            list = (List<Object>) value;
        }
        for (Object o : list) {
            if (o instanceof File) {
                o = new FileBody((File) o);
            }
            Field field = new Field(name, o);
            formField.add(field);
        }
    }

    /**
     * Get The form fields to be submitted via a HTTP request
     *
     * @return The form fields
     */
    public List<Field> getFields() {
        return formField;
    }

}
