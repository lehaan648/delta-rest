package com.delta.form;

import javax.validation.constraints.NotNull;

/**
 * Created by Lakshit on 27-05-2018.
 */

public class LoginForm {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
