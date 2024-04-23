package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;

@Controller
public class ExpenseController {

    /* Expenses Page */
    @GetMapping("/showExpenses")
    public String showExpenses(Model model) {

        model.addAttribute("message", "Record your expense.");

        // New expense
        // Expense expense = new Expense();

        // expense model
        // model.addAttribute("expense", expense);

        return "expenses";
    }

    @GetMapping("/showRecordExpenseForm")
    public String showRecordExpenseForm(Model model) {

        model.addAttribute("expense", new Expense());

        return "record-expense-form";
    }

    @PostMapping("/recordExpenses")
    public String recordExpenses(@ModelAttribute("expense")
                                 Expense expense, Model model) {

        System.out.println("Date of expense: " + expense.getExpenseDate());
        System.out.println("Description:" + expense.getExpenseDescription());
        System.out.println("Remarks: " + expense.getExpenseRemarks());
        System.out.println("Mode of payment: " + expense.getModeOfPayment());
        System.out.println("Amount: " + expense.getAmount());

        model.addAttribute("expense", expense);

        return "expenses";
    }
}
