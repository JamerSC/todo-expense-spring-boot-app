package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.dao.UserRepository;
import com.jamersc.springboot.todoexpense.entity.User;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer theId) {

        // link: www.luv2code.com/java-optional-tutorial
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;
        if(result.isPresent()){
            theUser = result.get();
        } else {
            throw new RuntimeException("Did not find the User id - " + theId);
        }

        return theUser;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(Integer theId) {
        userRepository.deleteById(theId);
    }
}
