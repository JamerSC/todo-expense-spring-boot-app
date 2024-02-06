package com.jamersc.springboot.todoexpense.rest.entity;

import java.util.Date;

public class WebUser {

    // preparing for validation
    private int webId;
    private String username;
    private String password;
    private String email;
    private Date createdDate;
    private Date modifiedDate;
    public WebUser() {

    }

    public WebUser(int webId, String username, String password, String email, Date createdDate, Date modifiedDate) {
        this.webId = webId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return webId;
    }

    public void setId(int id) {
        this.webId = id;
    }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "WebUser{" +
                "webId=" + webId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
