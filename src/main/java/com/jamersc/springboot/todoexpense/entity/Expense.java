package com.jamersc.springboot.todoexpense.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;

    @Column(name="expense_name")
    private String expenseName;

    @Column(name="amount")
    private Double amount;


    // @Column(name="user_id")
    private User user;

    // @Column(name="created_date")
    private Date createdDate;

    // @Column(name="modified_date")
    private Date modifiedDate;

    public Expense() {

    }

    public Expense(int expenseId, String expenseName, Double amount, User user, Date createdDate, Date modifiedDate) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
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

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String description) {
        this.expenseName = expenseName;
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
                ", description='" + expenseName + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
