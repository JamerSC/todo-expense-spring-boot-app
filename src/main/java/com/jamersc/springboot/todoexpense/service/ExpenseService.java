package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dto.RecordExpense;
import com.jamersc.springboot.todoexpense.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAllExpense();

    RecordExpense findExpenseById(Integer id);

    void saveRecord(RecordExpense recordExpense);

    void deleteExpenseById(Integer id);
}
