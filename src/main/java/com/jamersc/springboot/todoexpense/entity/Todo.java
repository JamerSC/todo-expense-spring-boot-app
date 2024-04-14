package com.jamersc.springboot.todoexpense.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "user_todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;

    @Column(name = "todo_name", nullable = false)
    private String todoName;

    @Column(name = "todo_details", nullable = false)
    private String todoDetails;

    @Column(name = "todo_start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE) // Assuming End Date is a date without time
    private Date todoStartDate;

    @Column(name = "todo_end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE) // Assuming End Date is a date without time
    private Date todoEndDate;

    @Column(name = "todo_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "modified_by", nullable = false)
    private User modifiedBy;

    @Column(name = "modified_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    // Getters and setters, constructors, and other methods

    public Todo() {
    }

    public Todo(String todoName, String todoDetails, Date todoStartDate, Date todoEndDate,TodoStatus todoStatus, User createdBy, User modifiedBy) {
        this.todoName = todoName;
        this.todoDetails = todoDetails;
        this.todoStartDate = todoStartDate;
        this.todoEndDate = todoEndDate;
        this.todoStatus = todoStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDetails() {
        return todoDetails;
    }

    public void setTodoDetails(String todoDetails) {
        this.todoDetails = todoDetails;
    }

    public TodoStatus getTodoStatus() {
        return todoStatus;
    }

    public Date getTodoStartDate() {
        return todoStartDate;
    }

    public void setTodoStartDate(Date todoStartDate) {
        this.todoStartDate = todoStartDate;
    }

    public Date getTodoEndDate() {
        return todoEndDate;
    }

    public void setTodoEndDate(Date todoEndDate) {
        this.todoEndDate = todoEndDate;
    }

    public void setTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    // Add JPA annotations for createdDate and modifiedDate
    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todoName='" + todoName + '\'' +
                ", todoDetails='" + todoDetails + '\'' +
                ", todoStartDate=" + todoStartDate +
                ", todoEndDate=" + todoEndDate +
                ", todoStatus=" + todoStatus +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}