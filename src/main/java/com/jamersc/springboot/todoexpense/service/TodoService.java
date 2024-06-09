package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dto.ManageTodo;
import com.jamersc.springboot.todoexpense.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAllTodo();

    ManageTodo findTodoById(Integer id);

    void saveTodo(ManageTodo todo);

    void deleteTodoById(Integer id);
}
