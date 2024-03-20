package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository //support component scanning, translate JDBC exc
@Transactional // annotation for create, update, delete
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
    public void save(User theUser) {

        // Set createdDate and modifiedDate
        theUser.setCreatedDate(new Date());
        theUser.setModifiedDate(new Date());

        entityManager.persist(theUser);

        // Set createdByUserId and modifiedByUserId with the generated userId
        theUser.setCreatedBy(theUser.getUserId());
        theUser.setModifiedBy(theUser.getUserId());
    }

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {

        //TypedQuery<User> theQuery = entityManager.createQuery("FROM User", User.class);
        TypedQuery<User> theQuery = entityManager.createQuery("FROM User ORDER BY lastName ASC", User.class);

        return theQuery.getResultList();
    }

    @Override
    public List<User> findByLastName(String theLastName) {

        // create query
        TypedQuery<User> theQuery = entityManager.createQuery(
                                    "FROM User WHERE lastName=:theData", User.class);
        // set query parameter
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }
}
