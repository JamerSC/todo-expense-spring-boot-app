package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.Todo;
import com.jamersc.springboot.todoexpense.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findTodoById(Integer id) {

        Optional<Todo> result = todoRepository.findById(id);

        Todo tempTodo = null;
        if (result.isPresent()) {
            tempTodo = result.get();
        } else {
            throw new RuntimeException("Did not find todo id -" + id);
        }
        return tempTodo;
    }

    @Override
    public void saveTodo(Todo todo) {

        todoRepository.save(todo);

    }

    @Override
    public void deleteTodoById(Integer id) {

        todoRepository.deleteById(id);
    }
}
