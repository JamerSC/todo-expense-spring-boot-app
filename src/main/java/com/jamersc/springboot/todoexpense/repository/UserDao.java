package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.User;

import java.util.List;

public interface UserDao {

    User findById(Integer id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteById(Integer id);

    List<User> findByUsername(String username);

    List<User> findByEmail(String email);

}
