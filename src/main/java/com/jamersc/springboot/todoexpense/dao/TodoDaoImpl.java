package com.jamersc.springboot.todoexpense.dao;

import com.jamersc.springboot.todoexpense.entity.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TodoDaoImpl implements TodoDao {

    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);

    @Autowired
    public TodoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Todo findById(Integer id) {

        return entityManager.find(Todo.class, id);
    }

    @Override
    public List<Todo> findAll() {

        TypedQuery<Todo> query = entityManager.createQuery("FROM Todo ORDER BY id ASC", Todo.class);

        return query.getResultList();
    }

    @Override
    public void save(Todo todo) {
        entityManager.persist(todo);
    }

    @Override
    public void update(Todo todo) {
        entityManager.merge(todo);

    }

    @Override
    public void deleteById(Integer id) {

        Todo todo = entityManager.find(Todo.class, id);
        if (todo == null) {
            throw new EntityNotFoundException("Todo not found with id: " + id);
        }
        entityManager.remove(todo);
    }


}
