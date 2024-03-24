package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dao.UserDAO;
import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO){
        this.userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Integer theId) {
        return userDAO.findById(theId);
    }

    @Override
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Override
    public void deleteById(Integer theId) {
        userDAO.deleteById(theId);
    }
}
