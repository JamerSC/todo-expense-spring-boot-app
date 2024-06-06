package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.model.Expense;
import com.jamersc.springboot.todoexpense.dto.RecordExpense;
import com.jamersc.springboot.todoexpense.service.ExpenseService;
import jakarta.validation.Valid;
import org.hibernate.sql.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

        // Read all expenses
        List<Expense> expenses = expenseService.findAllExpense();

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

            BeanUtils.copyProperties(recordExpense, expense);

            expenseService.saveRecord(expense);

            return "redirect:/expenses/expense";
        }

    }

    @GetMapping("/updateExpense")
    public String updateExpense(@RequestParam("expenseId") Integer expenseId, Model model) {

        Expense expense = expenseService.findExpenseById(expenseId);

        model.addAttribute("expense", expense);

        return "./forms/expense-update-form";

    }

    @PostMapping("/updateExpense")
    public String processUpdateExpense(@Valid @ModelAttribute("expense") RecordExpense updateExpense,
                                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "./forms/expense-update-form";
        }
        else {

            Expense expense = expenseService.findExpenseById(updateExpense.getId());

            if (expense != null) {

                BeanUtils.copyProperties(updateExpense, expense);

                expenseService.saveRecord(expense);

                model.addAttribute("expense", expense);
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
