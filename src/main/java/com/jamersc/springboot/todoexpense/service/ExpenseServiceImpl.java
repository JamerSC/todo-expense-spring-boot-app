package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dto.RecordExpense;
import com.jamersc.springboot.todoexpense.model.Expense;
import com.jamersc.springboot.todoexpense.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public RecordExpense findExpenseById(Integer id) {
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
         RecordExpense recordExpense = new RecordExpense();
            BeanUtils.copyProperties(expense, recordExpense);
            return recordExpense;
        }
        return null;
    }

    @Override
    public void saveRecord(RecordExpense recordExpense) {
        Expense expense;
        if (recordExpense.getId() != null) {
            expense = expenseRepository.findById(recordExpense.getId()).orElse(new Expense());
        } else {
            expense = new Expense();
        }
        // recordExpense object source to expense object target.
        BeanUtils.copyProperties(recordExpense, expense, "createdAt");
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpenseById(Integer id) {
        expenseRepository.deleteById(id);

    }
}
