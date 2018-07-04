package com.delta.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by Lakshit on 27-05-2018.
 */


public class DeltaUser {

    @NotNull
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
    private Integer defaultScriptId;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDefaultScriptId() {
        return defaultScriptId;
    }

    public void setDefaultScriptId(Integer defaultScriptId) {
        this.defaultScriptId = defaultScriptId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
