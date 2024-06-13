package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dto.ManageTodo;
import com.jamersc.springboot.todoexpense.model.Todo;
import com.jamersc.springboot.todoexpense.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ManageTodo findTodoById(Integer id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            ManageTodo manageTodo = new ManageTodo();
            BeanUtils.copyProperties(todo, manageTodo);
            return manageTodo;
        }
        return null;
    }

    @Override
    public void saveTodo(ManageTodo manageTodo) {
        Todo todo;
        if (manageTodo.getId() != null) {
            todo = todoRepository.findById(manageTodo.getId()).orElse(new Todo());
        } else {
            todo = new Todo();
        }
        BeanUtils.copyProperties(manageTodo, todo, "createdAt");
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodoById(Integer id) {
        todoRepository.deleteById(id);
    }
}
