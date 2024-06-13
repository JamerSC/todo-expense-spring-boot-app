package com.jamersc.springboot.todoexpense.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE) // Assuming expenseDate is a date without time
    private Date dateOfPayment;
    private String itemDescription;
    private String remarks;
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Getters and setters, constructors, and other methods

    public Expense() {
    }

    public Expense(Integer id, Date dateOfPayment, String itemDescription, String remarks, ModeOfPayment modeOfPayment,
                   Double amount, User createdBy, Date createdAt, User updatedBy, Date updatedAt) {
        this.id = id;
        this.dateOfPayment = dateOfPayment;
        this.itemDescription = itemDescription;
        this.remarks = remarks;
        this.modeOfPayment = modeOfPayment;
        this.amount = amount;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Add JPA annotations for createdDate and modifiedDate
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", dateOfPayment=" + dateOfPayment +
                ", itemDescription='" + itemDescription + '\'' +
                ", remarks='" + remarks + '\'' +
                ", modeOfPayment=" + modeOfPayment +
                ", amount=" + amount +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                '}';
    }
}