package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    //
}
