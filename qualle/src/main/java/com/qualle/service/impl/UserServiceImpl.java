package com.qualle.service.impl;

import com.qualle.model.dto.UserProfileDto;
import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.model.entity.Creds;
import com.qualle.model.entity.User;
import com.qualle.repository.UserRepository;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User getById(long id) {
        return toUser(userRepository.findById(id));
    }

    @Override
    public UserProfileDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLoginFetchCreds(login);
    }

    @Override
    public UserProfileDto getDtoByLogin(String login) {
        return toDto(getByLogin(login));
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    // @Transactional
    public void add(UserRegistrationDto dto) {
        User user = new User(dto.getName(), "", dto.getPhone());
        user.setCreds(new Creds(dto.getLogin(), encoder.encode(dto.getPassword()), "USER"));
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

    private User toUser(Optional<User> optional) {
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NullPointerException();
    }

    private UserProfileDto toDto(User user) {
        return new UserProfileDto(user.getName(), user.getLastname(), user.getCreds().getLogin(), user.getPhone());
    }
}