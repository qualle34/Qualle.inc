package com.qualle.repository.impl;

import com.qualle.model.entity.User;
import com.qualle.repository.custom.CustomUserRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomUserRepositoryImpl implements CustomUserRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserBysdLogin(String login) {
        return entityManager.createQuery("FROM User u JOIN FETCH Creds c where c.login = :login ", User.class).setParameter("login", login).getSingleResult();
    }
}
