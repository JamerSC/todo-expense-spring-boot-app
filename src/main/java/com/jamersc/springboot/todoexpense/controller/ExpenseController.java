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

@Controller
public class ExpenseController {

    /* Expenses Page */
    @GetMapping("/expenses")
    public String showExpenses(Model model) {

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

            model.addAttribute("expense", expense);

            return "todo-expense/expenses";
        }

    }
}
