package com.jamersc.springboot.todoexpense.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user_todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;

    @Column(name="todo_name")
    private String todoName;

    @Column(name="todo_details")
    private String todoDetails;

//    @Column(name="user_id")
    private User user;

//    @Column(name="created_date")
    private Date createdDate;

//    @Column(name="modified_date")
    private Date modifiedDate;

    public Todo() {

    }

    public Todo(int todoId, String todoName, String todoDetails, User user, Date createdDate, Date modified ) {
        this.todoId = todoId;
        this.todoName = todoName;
        this.todoDetails =  todoDetails;
        this.user = user;
        this.createdDate = createdDate;
        this.modifiedDate = modified;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoIdId(int id) {
        this.todoId =  id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String title) {
        this.todoName = title;
    }

    public String getTodoDetails() {
        return todoDetails;
    }

    public void setTodoDetails(String todoDetails) {
        this.todoDetails = todoDetails;
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
                "todoId=" + todoId +
                ", todoName='" + todoName + '\'' +
                ", todoDetails='" + todoDetails + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

}