package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TodoDaoImpl implements TodoDao {

    private EntityManager entityManager;

    @Autowired
    public TodoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Todo findById(Integer id) {
        return null;
    }

    @Override
    public List<Todo> findAll() {

        TypedQuery<Todo> query = entityManager.createQuery("FROM Todo ORDER BY startDate DESC", Todo.class);

        return query.getResultList();
    }

    @Override
    public void save(Todo todo) {
        entityManager.persist(todo);
    }

    @Override
    public void update(Todo todo) {

    }

    @Override
    public void delete(Integer id) {

    }
}
