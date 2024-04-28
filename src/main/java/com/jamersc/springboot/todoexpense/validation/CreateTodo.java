package com.jamersc.springboot.todoexpense.validation;

import com.jamersc.springboot.todoexpense.entity.TodoStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateTodo {

    @NotNull(message = "Todo title is required!")
    @Size(min = 1, message = "Todo title is required!")
    private String createTodoName;

    @NotNull(message = "Details is required!")
    @Size(min = 1, message = "Details is required!")
    private String createTodoDetails;

    @NotNull(message = "Start date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTodoStartDate;

    @NotNull(message = "End date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTodoEndDate;

    @NotNull(message = "Status is required!")
    private TodoStatus createTodoStatus;

    public CreateTodo() {
    }

    public CreateTodo(String createTodoName, String createTodoDetails, Date createTodoStartDate,
                      Date createTodoEndDate, TodoStatus createTodoStatus) {
        this.createTodoName = createTodoName;
        this.createTodoDetails = createTodoDetails;
        this.createTodoStartDate = createTodoStartDate;
        this.createTodoEndDate = createTodoEndDate;
        this.createTodoStatus = createTodoStatus;
    }

    public String getCreateTodoName() {
        return createTodoName;
    }

    public void setCreateTodoName(String createTodoName) {
        this.createTodoName = createTodoName;
    }

    public String getCreateTodoDetails() {
        return createTodoDetails;
    }

    public void setCreateTodoDetails(String createTodoDetails) {
        this.createTodoDetails = createTodoDetails;
    }

    public Date getCreateTodoStartDate() {
        return createTodoStartDate;
    }

    public void setCreateTodoStartDate(Date createTodoStartDate) {
        this.createTodoStartDate = createTodoStartDate;
    }

    public Date getCreateTodoEndDate() {
        return createTodoEndDate;
    }

    public void setCreateTodoEndDate(Date createTodoEndDate) {
        this.createTodoEndDate = createTodoEndDate;
    }

    public TodoStatus getCreateTodoStatus() {
        return createTodoStatus;
    }

    public void setCreateTodoStatus(TodoStatus createTodoStatus) {
        this.createTodoStatus = createTodoStatus;
    }

    @Override
    public String toString() {
        return "CreateTodo{" +
                "createTodoName='" + createTodoName + '\'' +
                ", createTodoDetails='" + createTodoDetails + '\'' +
                ", createTodoStartDate=" + createTodoStartDate +
                ", createTodoEndDate=" + createTodoEndDate +
                ", createTodoStatus=" + createTodoStatus +
                '}';
    }
}
