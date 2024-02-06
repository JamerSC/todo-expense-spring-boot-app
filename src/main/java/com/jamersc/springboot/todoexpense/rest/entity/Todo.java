package com.jamersc.springboot.todoexpense.rest.entity;

import java.util.Date;

public class Todo {

    private int listId;
    private String title;
    private String status;
    private User user;
    private Date createdDate;
    private Date modifiedDate;

    public Todo() {

    }

    public Todo(int listId, String title, String status, User user, Date createdDate, Date modified ) {
        this.listId = listId;
        this.title = title;
        this.status = status;
        this.user = user;
        this.createdDate = createdDate;
        this.modifiedDate = modified;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int id) {
        this.listId =  id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Todo{" +
                "listId=" + listId +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + user +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}