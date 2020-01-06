package com.qualle.service.impl;

import com.qualle.model.dto.UserProfileDto;
import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.model.entity.Creds;
import com.qualle.model.entity.User;
import com.qualle.repository.UserRepository;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserProfileDto getDtoById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseGet(User::new);
        return new UserProfileDto(user.getName(), user.getLastname(), "login", user.getPhone());
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLoginFetchCreds(login);
    }

    @Override
    public UserProfileDto getDtoByLogin(String login) {
        User user = getByLogin(login);
        return new UserProfileDto(user.getName(), user.getLastname(), user.getCreds().getLogin(), user.getPhone());
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
   // @Transactional
    public void add(UserRegistrationDto dto) {
        User user = new User(dto.getName(), "", dto.getPhone());
        user.setCreds(new Creds(dto.getLogin(), dto.getPassword(), "USER"));
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}