package com.crowdmap.java.sdk.model;

import com.crowdmap.java.sdk.annotations.Form;
import com.crowdmap.java.sdk.annotations.FormField;

/**
 * Login form
 */
public class LoginForm extends Form {

    /**
     * The username
     */
    @FormField(name = "username")
    private String username;

    @FormField(name = "password")
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
