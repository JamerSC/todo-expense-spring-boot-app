package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.entity.Todo;
import com.jamersc.springboot.todoexpense.entity.TodoStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        String formattedStartDate = todo.getTodoStartDate().toGMTString();
        System.out.println("Todo start date: " + formattedStartDate);

        // Format end date
        String formattedEndDate = todo.getTodoEndDate().toGMTString();
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
