package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.repository.UserRepository;
import com.jamersc.springboot.todoexpense.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        this.userRepository = theUserRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {

        Optional<User> result = userRepository.findById(id);

        User tempUser = null;
        if (result.isPresent()) {
            tempUser = result.get();
        } else {
            throw new RuntimeException("Did not find employee id -" + id);
        }

        return tempUser;

    }

    @Override
    public void saveUser(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteUserById(Integer theId) {
        userRepository.deleteById(theId);
    }
}
