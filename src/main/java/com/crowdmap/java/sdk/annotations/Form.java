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

package com.crowdmap.java.sdk.annotations;

import com.crowdmap.java.sdk.net.content.Body;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 * Form parameters to be sent.
 */
public abstract class Form {

    /**
     * Get the form parameters to be submitted
     *
     * @return The Map objection that has the forms variable names and values
     */
    public Body getParameters() {
        Body body = new Body();
        // get all declared files
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            // get all the annotations
            try {
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof FormField) {
                        FormField formField = (FormField) annotation;
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        // add the form fields

                        body.addField(formField.name(), field.get(this));
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}
