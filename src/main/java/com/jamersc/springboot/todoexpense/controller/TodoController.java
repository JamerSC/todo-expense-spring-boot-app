package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.dao.TodoDao;
import com.jamersc.springboot.todoexpense.entity.Todo;
import com.jamersc.springboot.todoexpense.validation.ManageTodo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoDao todoDao;

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    public TodoController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    /* To do page*/
    @GetMapping("/todo")
    public String showTodo(Model model) {

        // Display all todo
        List<Todo> todos = todoDao.findAll();

        model.addAttribute("todo", todos);

        for (Todo tempTodo : todos) {
            System.out.println(tempTodo);
        }

        return "todo-expense/todo";

    }

    @GetMapping("/createTodo")
    public String showTodoForm(Model model) {

        model.addAttribute("todo", new ManageTodo());

        return "./forms/todo-form";
    }

    @PostMapping("/createTodo")
    public String createTodo(@Valid @ModelAttribute("todo") ManageTodo createTodo,
                             BindingResult result, Model model) {

        System.out.println("Create Todo: " + createTodo);

        if (result.hasErrors()) {

            return "./forms/todo-form";
        }
        else {

            Todo todo = new Todo();

            todo.setTitle(createTodo.getTitle());
            todo.setDetails(createTodo.getDetails());
            todo.setStartDate(createTodo.getStartDate());
            todo.setEndDate(createTodo.getEndDate());
            todo.setStatus(createTodo.getStatus());

            // Save todo
            todoDao.save(todo);

            model.addAttribute("todo", todo);

            return "redirect:/todos/todo";
        }

    }

    @GetMapping("/updateTodo")
    public String updateTodo(@RequestParam("todoId") Integer todoId, Model model) {

        Todo todo = todoDao.findById(todoId);

        model.addAttribute("todo", todo);

        return "./forms/todo-update-form";
    }

    @PostMapping("/updateTodo")
    public String processUpdateTodo(@Valid @ModelAttribute("todo") ManageTodo updateTodo,
                                    BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "./forms/todo-update-form";
        }
        return "redirect:/todos/todo";
    }


    @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("todoId") Integer id, Model model) {

/*        logger.debug("Received request to delete Todo with id: {}", id);
        try {
            // Check if Todo with the specified ID exists
            Todo todo = todoDao.findById(id);
            if (todo == null) {
                // If Todo does not exist, return an error message
                logger.warn("Todo not found with id: {}", id);
                model.addAttribute("error", "Todo not found with id " + id);
                return "error";
            }
            // Delete the Todo
            todoDao.deleteById(todo.getId());
            logger.debug("Successfully deleted Todo with id: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting Todo with id: {}", id, e);
            model.addAttribute("error", "Error deleting Todo with id " + id);
            return "error";
        }*/
        Todo todo = todoDao.findById(id);
        if (todo != null) {
            todoDao.deleteById(todo.getId());
            logger.debug("Deleted successfully todo with id: {}", id);
            return "redirect:/todos/todo";
        } else  {
            logger.warn("Error! on deleting todo with id: {}", id);
            model.addAttribute("error", "Error on deleting todo with id: {}" + id);
            return "error";
        }


    }

}
