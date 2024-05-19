package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User findUserById(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

}
