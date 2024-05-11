package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Search User ID
    @Override
    public User findById(Integer id) {

        return entityManager.find(User.class, id);
    }

    // Search All User
    @Override
    public List<User> findAll() {

        TypedQuery<User> query = entityManager.createQuery("FROM User ORDER BY Id ASC", User.class);

        return query.getResultList();
    }

    // Save Created user
    @Override
    public void save(User user) {

        entityManager.persist(user);

    }

    // Update User
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }


    // Delete User
    @Override
    public void deleteById(Integer id) {
        entityManager.remove(id);
    }

    @Override
    public List<User> findByUsername(String username) {

        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE username =: username", User.class);

        query.setParameter("username", username);

        return query.getResultList();
    }

    @Override
    public List<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE email =: email", User.class);

        query.setParameter("email", email);

        return query.getResultList();
    }

}
