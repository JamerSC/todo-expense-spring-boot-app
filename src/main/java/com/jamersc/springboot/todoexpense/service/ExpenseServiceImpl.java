package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.Expense;
import com.jamersc.springboot.todoexpense.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> findAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense findExpenseById(Integer id) {

        Optional<Expense> result = expenseRepository.findById(id);

        Expense tempExpense = null;

        if(result.isPresent()) {
            tempExpense = result.get();
        } else {
            throw new RuntimeException("Cant find Expense with id: " + id);
        }

        return tempExpense;
    }

    @Override
    public void saveRecord(Expense expense) {
        expenseRepository.save(expense);

    }

    @Override
    public void deleteExpenseById(Integer id) {

        expenseRepository.deleteById(id);

    }
}
