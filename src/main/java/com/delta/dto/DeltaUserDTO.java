package com.delta.dto;

/**
 * Created by Lakshit on 27-05-2018.
 */


public class DeltaUserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String token;
    private Integer defaultScriptId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getDefaultScriptId() {
        return defaultScriptId;
    }

    public void setDefaultScriptId(Integer defaultScriptId) {
        this.defaultScriptId = defaultScriptId;
    }

    @Override
    public String toString() {
        return "DeltaUserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", defaultScriptId=" + defaultScriptId +
                '}';
    }
}
