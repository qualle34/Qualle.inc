package com.qualle.repository.custom;

public interface CustomUserRepository<T> {

    T getUserBysdLogin(String login);
}
