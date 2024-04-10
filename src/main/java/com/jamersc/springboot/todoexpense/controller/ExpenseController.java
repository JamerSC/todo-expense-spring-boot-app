package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    /* Expenses Page */
    @GetMapping("/showExpenses")
    public String showExpenses(Model model) {

        // New expense
        Expense expense = new Expense();
        // expense model
        model.addAttribute("expense", expense);

        return "expenses";
    }

}
