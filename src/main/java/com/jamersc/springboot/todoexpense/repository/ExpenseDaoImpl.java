package com.jamersc.springboot.todoexpense.repository;

import com.jamersc.springboot.todoexpense.model.Expense;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ExpenseDaoImpl implements ExpenseDao {

    private EntityManager entityManager;

    @Autowired
    public ExpenseDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Expense findById(Integer id) {
        return null;
    }

    @Override
    public List<Expense> findAll() {

        TypedQuery<Expense> query = entityManager.createQuery("FROM Expense ORDER BY dateOfPayment ASC", Expense.class);

        return query.getResultList();
    }

    // Save expenses
    @Override
    public void save(Expense expense) {
        entityManager.persist(expense);
    }

    @Override
    public void update(Expense expense) {

    }

    @Override
    public void delete(Integer id) {

    }
}
