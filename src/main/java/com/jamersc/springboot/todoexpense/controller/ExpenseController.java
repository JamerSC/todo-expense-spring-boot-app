package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.repository.ExpenseDao;
import com.jamersc.springboot.todoexpense.model.Expense;
import com.jamersc.springboot.todoexpense.model.RecordExpense;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExpenseController {

    private ExpenseDao expenseDao;

    @Autowired
    public ExpenseController(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    /* Expenses Page */
    @GetMapping("/expenses")
    public String showExpenses(Model model) {

        // Read all expenses
        List<Expense> expenses = expenseDao.findAll();

        model.addAttribute("expense", expenses);

        // Display expenses
        System.out.println("List of Expenses:");

        for (Expense tempExpenses : expenses) {
            System.out.println(tempExpenses);
        }

        return "todo-expense/expenses";
    }

    @GetMapping("/recordExpense")
    public String showRecordExpenseForm(Model model) {

        model.addAttribute("expense", new RecordExpense());

        return "./forms/record-expense-form";
    }

    @PostMapping("/recordExpense")
    public String recordExpenses(@Valid @ModelAttribute("expense") RecordExpense recordExpense,
                                 BindingResult result, Model model) {

        System.out.println("Recorded expense: " + recordExpense);

        if (result.hasErrors()) {

           return "./forms/record-expense-form";
        }
        else {

            Expense expense = new Expense();

            expense.setDateOfPayment(recordExpense.getDateOfPayment());
            expense.setItemDescription(recordExpense.getItemDescription());
            expense.setRemarks(recordExpense.getRemarks());
            expense.setModeOfPayment(recordExpense.getModeOfPayment());
            expense.setAmount(recordExpense.getAmount());

            expenseDao.save(expense);
            model.addAttribute("expense", expense);


            return "redirect:/expenses";
        }

    }
}
