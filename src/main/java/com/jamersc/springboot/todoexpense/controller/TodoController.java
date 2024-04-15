package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;

@Controller
public class TodoController {

    //@Value("${todo_status}")
    //private List<String> todoStatuses;

    /* To do page*/
    @GetMapping("/showTodo")
    public String showTodo(Model model) {

        // New to do object
        Todo todo = new Todo();
        // create a model
        model.addAttribute("todo", todo);
        // model for status
        //model.addAttribute("todoStatuses", todoStatuses);
        // redirect to do page
        return "todo";
    }

    @PostMapping("/createTodo")
    public String createTodo(@ModelAttribute("todo") Todo todo, Model model) {
        // Print values for debugging
        System.out.println("Todo title: " + todo.getTodoName());
        System.out.println("Todo details: " + todo.getTodoDetails());

        // Format start date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy");
        String formattedStartDate = dateFormatter.format(todo.getTodoStartDate());
        System.out.println("Todo start date: " + formattedStartDate);

        // Format end date
        String formattedEndDate = dateFormatter.format(todo.getTodoEndDate());
        System.out.println("Todo end date: " + formattedEndDate);

        System.out.println("Todo status: " + todo.getTodoStatus());

        // You can save the todo object or perform other operations here

        // Add the todo object to the model
        model.addAttribute("todo", todo);
        model.addAttribute("formattedStartDate", formattedStartDate);
        model.addAttribute("formattedEndDate", formattedEndDate);

        // Redirect to a suitable page
        return "todo";
    }

}
