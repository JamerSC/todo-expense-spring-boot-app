package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.Expense;

import java.util.List;

public interface ExpenseDao {

    Expense findById(Integer id);

    List<Expense> findAll();

    void save(Expense expense);

    void update(Expense expense);

    void delete(Integer id);
}
