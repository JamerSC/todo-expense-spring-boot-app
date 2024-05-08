package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.Expense;

import java.util.List;

public interface ExpenseDao {

    Expense findById(Integer id);

    List<Expense> findAll();

    void save(Expense expense);

    void update(Expense expense);

    void delete(Integer id);
}
