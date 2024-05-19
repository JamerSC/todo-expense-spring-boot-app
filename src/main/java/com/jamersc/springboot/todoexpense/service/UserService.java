package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer theId);

    User save(User theUser);

    void deleteById(Integer theId);

}
