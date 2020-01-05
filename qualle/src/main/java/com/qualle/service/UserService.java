package com.qualle.service;

import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.model.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getById(long id);

    User getUserByLogin(String login);

    void add(User user);

    void add(UserRegistrationDto user);

    void update(User user);

    void delete(User user);
}
