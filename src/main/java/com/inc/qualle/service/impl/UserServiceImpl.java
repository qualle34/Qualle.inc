package com.inc.qualle.service.impl;

import com.inc.qualle.exception.UserNotFoundException;
import com.inc.qualle.model.dto.UserProfileDto;
import com.inc.qualle.model.dto.UserRegistrationDto;
import com.inc.qualle.repository.UserRepository;
import com.inc.qualle.model.entity.Credentials;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<UserProfileDto> getAllDto() {
        return getAll().stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public User getById(long id) {
        return toUser(userRepository.findById(id));
    }

    @Override
    public UserProfileDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public long getIdByLogin(String login) {
        return userRepository.findIdByLogin(login).orElse(0L);
    }

    @Override
    public User getByLogin(String login) {
        return toUser(userRepository.findByLoginFetchCreds(login));
    }

    @Override
    public UserProfileDto getDtoByLogin(String login) {
        return toDto(getByLogin(login));
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void add(UserRegistrationDto dto) {
        User user = new User(dto.getName(), null, dto.getPhone(), null, null);
        user.setCreds(new Credentials(dto.getLogin(), encoder.encode(dto.getPassword()), "USER"));
        add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    private User toUser(Optional<User> optional) {
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new UserNotFoundException();
    }

    private UserProfileDto toDto(User user) {
        UserProfileDto dto = new UserProfileDto(user.getName(), user.getLastname(), user.getCreds().getLogin(), user.getPhone(), user.getEmail());
        dto.setBirthday((user.getBirthday() != null) ? user.getBirthday().toString() : null);
        dto.setId(user.getId());
        return dto;
    }
}
