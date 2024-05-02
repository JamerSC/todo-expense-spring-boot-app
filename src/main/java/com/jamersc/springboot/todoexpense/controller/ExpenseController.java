package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Expense;
import com.jamersc.springboot.todoexpense.validation.RecordExpense;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;

@Controller
public class ExpenseController {

    /* Expenses Page */
    @GetMapping("/expenses")
    public String showExpenses(Model model) {

        return "expenses";
    }

    @GetMapping("/recordExpense")
    public String showRecordExpenseForm(Model model) {

        model.addAttribute("recordExpense", new RecordExpense());

        return "/forms/record-expense-form";
    }

    @PostMapping("/recordExpense")
    public String recordExpenses(@Valid @ModelAttribute("recordExpense") RecordExpense recordExpense,
                                 BindingResult result, Model model) {

        System.out.println("Recorded expense: " + recordExpense);

        if (result.hasErrors()) {

           return "/forms/record-expense-form";
        }
        else {

            Expense expense = new Expense();

            expense.setExpenseDate(recordExpense.getRecordExpenseDate());
            expense.setExpenseDescription(recordExpense.getRecordExpenseDesc());
            expense.setExpenseRemarks(recordExpense.getRecordExpenseRemarks());
            expense.setModeOfPayment(recordExpense.getRecordModeOfPayment());
            expense.setAmount(recordExpense.getRecordAmount());

            model.addAttribute("expense", expense);

            return "expenses";
        }

    }
}
