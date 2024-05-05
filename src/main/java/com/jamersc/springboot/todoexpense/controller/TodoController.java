package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Todo;
import com.jamersc.springboot.todoexpense.validation.CreateTodo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;

@Controller
public class TodoController {

    /* To do page*/
    @GetMapping("/todo")
    public String showTodo(Model model) {

        return "todo-expense/todo";

    }

    @GetMapping("/createTodo")
    public String showTodoForm(Model model) {

        model.addAttribute("createTodo", new CreateTodo());

        return "./forms/todo-form";
    }

    @PostMapping("/createTodo")
    public String createTodo(@Valid @ModelAttribute("createTodo") CreateTodo createTodo,
                             BindingResult result, Model model) {

        System.out.println("Create Todo: " + createTodo);

        if (result.hasErrors()) {

            return "./forms/todo-form";
        }
        else {

            Todo todo = new Todo();

            todo.setTodoName(createTodo.getCreateTodoName());
            todo.setTodoDetails(createTodo.getCreateTodoDetails());
            todo.setTodoStartDate(createTodo.getCreateTodoStartDate());
            todo.setTodoEndDate(createTodo.getCreateTodoEndDate());
            todo.setTodoStatus(createTodo.getCreateTodoStatus());

            model.addAttribute("todo", todo);

            return "todo-expense/todo";
        }

    }

}
