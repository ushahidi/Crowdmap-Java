package com.crowdmap.java.sdk.model.form;

import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;

import java.io.File;

/**
 * The image file to be upload
 */
public class MediaForm extends Form {

    @FormField(name = "file")
    private File file;

    public MediaForm(File file) {
        if (file == null) {
            throw new IllegalArgumentException("The file to be uploaded canno't be null");
        }

        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
