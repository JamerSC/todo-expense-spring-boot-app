package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository //support component scanning, translate JDBC exc
public class TodoexpenseDAOImpl implements TodoexpenseDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using contructor injection
    @Autowired
    public TodoexpenseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(User theUser) {

        // Set createdByUserId and modifiedByUserId with the generated userId
        //theUser.setCreatedBy(theUser.getUserID());
        //theUser.setModifiedBy(theUser.getUserID());

        // Set createdDate and modifiedDate
        theUser.setCreatedDate(new Date());
        theUser.setModifiedDate(new Date());

        entityManager.persist(theUser);

        // Set createdByUserId and modifiedByUserId with the generated userId
        theUser.setCreatedBy(theUser.getUserID());
        theUser.setModifiedBy(theUser.getUserID());
    }
}
