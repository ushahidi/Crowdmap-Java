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
package com.crowdmap.java.sdk.model;

import java.io.Serializable;

/**
 * Permission model classes
 */
public class Permission implements Serializable {

    /**
     * Serial version UID
     */
    private static final long serialVersionUID = 3524581235515348880L;

    private boolean delete;

    private boolean edit;

    /**
     * @return the delete
     */
    public boolean isDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    /**
     * @return the edit
     */
    public boolean isEdit() {
        return edit;
    }

    /**
     * @param edit the edit to set
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "delete=" + delete +
                ", edit=" + edit +
                '}';
    }
}
