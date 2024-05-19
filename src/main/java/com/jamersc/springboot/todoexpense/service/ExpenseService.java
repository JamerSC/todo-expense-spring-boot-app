package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAllExpense();

    Expense findExpenseById(Integer id);

    void saveRecord(Expense expense);

    void deleteExpenseById(Integer id);
}
