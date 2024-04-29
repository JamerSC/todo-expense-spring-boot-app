package com.jamersc.springboot.todoexpense.validation;

import com.jamersc.springboot.todoexpense.entity.ModeOfPayment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RecordExpense {

    @NotNull(message = "Expense date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recordExpenseDate;

    @NotNull(message = "Expense description is required!")
    @Size(min = 1, message = "Description is required!")
    private String recordExpenseDesc;

    private String recordExpenseRemarks;

    @NotNull(message = "Mode of payments is required!")
//    @Enumerated(EnumType.STRING)
    private ModeOfPayment recordModeOfPayment;

    @NotNull(message = "Expense amount is required!")
    private Double recordAmount;

    public RecordExpense() {
    }

    public RecordExpense(Date recordExpenseDate, String recordExpenseDesc, String recordExpenseRemarks,
                         ModeOfPayment recordModeOfPayment, Double recordAmount) {
        this.recordExpenseDate = recordExpenseDate;
        this.recordExpenseDesc = recordExpenseDesc;
        this.recordExpenseRemarks = recordExpenseRemarks;
        this.recordModeOfPayment = recordModeOfPayment;
        this.recordAmount = recordAmount;
    }

    public Date getRecordExpenseDate() {
        return recordExpenseDate;
    }

    public void setRecordExpenseDate(Date recordExpenseDate) {
        this.recordExpenseDate = recordExpenseDate;
    }

    public String getRecordExpenseDesc() {
        return recordExpenseDesc;
    }

    public void setRecordExpenseDesc(String recordExpenseDesc) {
        this.recordExpenseDesc = recordExpenseDesc;
    }

    public String getRecordExpenseRemarks() {
        return recordExpenseRemarks;
    }

    public void setRecordExpenseRemarks(String recordExpenseRemarks) {
        this.recordExpenseRemarks = recordExpenseRemarks;
    }

    public ModeOfPayment getRecordModeOfPayment() {
        return recordModeOfPayment;
    }

    public void setRecordModeOfPayment(ModeOfPayment recordModeOfPayment) {
        this.recordModeOfPayment = recordModeOfPayment;
    }

    public Double getRecordAmount() {
        return recordAmount;
    }

    public void setRecordAmount(Double recordAmount) {
        this.recordAmount = recordAmount;
    }

    @Override
    public String toString() {
        return "RecordExpense{" +
                "recordExpenseDate=" + recordExpenseDate +
                ", recordExpenseDesc='" + recordExpenseDesc + '\'' +
                ", recordExpenseRemarks='" + recordExpenseRemarks + '\'' +
                ", recordModeOfPayment=" + recordModeOfPayment +
                ", amount=" + recordAmount +
                '}';
    }
}
