package com.qualle.api.service;

import com.qualle.entity.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> getById(long id);

    User getUserByLogin(String login);

    void add(User user);

    void update(User user);

    void delete(User user);
}
