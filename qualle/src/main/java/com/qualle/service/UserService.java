package com.qualle.service;

import com.qualle.model.dto.UserProfileDto;
import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.model.entity.User;

import java.util.Optional;

public interface UserService {

    User getById(long id);

    UserProfileDto getDtoById(long id);

    long getIdByLogin(String login);

    User getByLogin(String login);

    UserProfileDto getDtoByLogin(String login);

    void add(User user);

    void add(UserRegistrationDto user);

    void update(User user);

    void delete(User user);

    void delete(long id);
}

