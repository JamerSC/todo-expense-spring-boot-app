package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //support component scanning, translate JDBC exc
@Transactional // annotation for create, update, delete
public class UserDAOImpl implements UserDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using contructor injection
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    /*
    @Override
    public void save(User theUser) {

        // Set createdDate and modifiedDate
        theUser.setCreatedDate(new Date());
        theUser.setModifiedDate(new Date());

        entityManager.persist(theUser);

        // Set createdByUserId and modifiedByUserId with the generated userId
        theUser.setCreatedBy(theUser.getUserId());
        theUser.setModifiedBy(theUser.getUserId());
    }
    */

    @Override
    public User findById(Integer theId) {

        // find User id
        User theUser = entityManager.find(User.class, theId);

        // return from the db
        return theUser;

        // Inline variable
        // return entityManager.find(User.class, theId);
    }

    @Override
    public List<User> findAll() {

        // create query for select all user
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User ORDER BY lastName ASC", User.class);
        //TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);

        // return the select user from db
        return theQuery.getResultList();
    }

    @Override
    public User save(User theUser) {

        // Save or Update the User
        User dbUser = entityManager.merge(theUser);

        // return the db user
        return dbUser;

        // return entityManager.merge(dbUser);
    }

    @Override
    public void deleteById(Integer theId) {

        // find the user id
        User dbUser = entityManager.find(User.class, theId);

        // delete the user reference user id
        entityManager.remove(dbUser);

    }

}
