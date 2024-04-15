package com.jamersc.springboot.todoexpense.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "user_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "expense_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE) // Assuming expenseDate is a date without time
    private Date expenseDate;

    @Column(name = "expense_description", nullable = false)
    private String expenseDescription;

    @Column(name = "expense_remarks", length = 255) // Setting max length for remarks
    private String expenseRemarks;

    @Column(name = "mode_of_payment", nullable = false)
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;

    @Column(name = "amount", nullable = false)
    private Double amount;

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

    public Expense() {
    }

    public Expense(Date expenseDate, String expenseDescription, String expenseRemarks, ModeOfPayment modeOfPayment,Double amount, User createdBy, User modifiedBy) {
        this.expenseDate = expenseDate;
        this.expenseDescription = expenseDescription;
        this.expenseRemarks = expenseRemarks;
        this.modeOfPayment = modeOfPayment;
        this.amount = amount;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public String getExpenseRemarks() {
        return expenseRemarks;
    }

    public void setExpenseRemarks(String expenseRemarks) {
        this.expenseRemarks = expenseRemarks;
    }

    public ModeOfPayment getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(ModeOfPayment modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "Expense{" +
                "expenseId=" + expenseId +
                ", expenseDate=" + expenseDate +
                ", expenseDescription='" + expenseDescription + '\'' +
                ", expenseRemarks='" + expenseRemarks + '\'' +
                ", modeOfPayment=" + modeOfPayment +
                ", amount=" + amount +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

}