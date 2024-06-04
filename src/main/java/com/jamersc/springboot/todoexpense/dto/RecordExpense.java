package com.jamersc.springboot.todoexpense.dto;

import com.jamersc.springboot.todoexpense.model.ModeOfPayment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RecordExpense {

    private Integer id;

    @NotNull(message = "Expense date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPayment;

    @NotNull(message = "Expense description is required!")
    @Size(min = 1, message = "Description is required!")
    private String itemDescription;

    private String remarks;

    @NotNull(message = "Mode of payments is required!")
//    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;

    @NotNull(message = "Expense amount is required!")
    private Double amount;

    public RecordExpense() {
    }

    public RecordExpense(Integer id, Date dateOfPayment, String itemDescription, String remarks,
                         ModeOfPayment modeOfPayment, Double amount) {
        this.id = id;
        this.dateOfPayment = dateOfPayment;
        this.itemDescription = itemDescription;
        this.remarks = remarks;
        this.modeOfPayment = modeOfPayment;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "RecordExpense{" +
                "id=" + id +
                ", dateOfPayment=" + dateOfPayment +
                ", itemDescription='" + itemDescription + '\'' +
                ", remarks='" + remarks + '\'' +
                ", modeOfPayment=" + modeOfPayment +
                ", amount=" + amount +
                '}';
    }
}
