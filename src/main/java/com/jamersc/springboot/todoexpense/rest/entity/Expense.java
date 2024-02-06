package com.jamersc.springboot.todoexpense.rest.entity;

import java.util.Date;

public class Expense {

    private int expenseId;
    private String description;
    private Double amount;
    private User user;
    private Date createdDate;
    private Date modifiedDate;

    public Expense() {

    }

    public Expense(int expenseId, String description, Double amount, User user, Date createdDate, Date modifiedDate) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.user = user;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Expense{" +
                "expenseId=" + expenseId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
