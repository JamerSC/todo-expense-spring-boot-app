package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.dto.RecordExpense;
import com.jamersc.springboot.todoexpense.model.Expense;
import com.jamersc.springboot.todoexpense.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /* Expenses Page */
    @GetMapping("/expense")
    public String showExpenses(Model model) {
        List<Expense> expenses = expenseService.findAllExpense();
        model.addAttribute("expense", expenses);
        // Console log display expenses
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
        if (result.hasErrors()) {
           return "./forms/record-expense-form";
        } else {
            expenseService.saveRecord(recordExpense);
            return "redirect:/expenses/expense";
        }

    }

    @GetMapping("/updateExpense")
    public String updateExpense(@RequestParam("expenseId") Integer expenseId, Model model) {
        RecordExpense recordExpense = expenseService.findExpenseById(expenseId);
        if (recordExpense != null) {
            model.addAttribute("expense", recordExpense);
            return "./forms/expense-update-form";
        }
        // null value redirect to expenses page
        return "redirect:/expenses/expense";
    }

    @PostMapping("/updateExpense")
    public String processUpdateExpense(@Valid @ModelAttribute("expense") RecordExpense updateExpense,
                                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "./forms/expense-update-form";
        } else {
            RecordExpense recordExpense = expenseService.findExpenseById(updateExpense.getId());
            if (recordExpense != null) {
                expenseService.saveRecord(updateExpense);
            }
            return "redirect:/expenses/expense";
        }
    }

    @PostMapping("/deleteExpense")
    public String deleteExpense(@RequestParam("expenseId") Integer id, Model model) {
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses/expense";
    }

}
