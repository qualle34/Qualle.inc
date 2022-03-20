package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.exception.UserNotFoundException;
import com.inc.qualle.model.dto.UserProfileDto;
import com.inc.qualle.repository.UserRepository;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.service.dao.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

    private final UserRepository repository;

    @Override
    protected CrudRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public List<UserProfileDto> getAllDto() {
        return getAll().stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserProfileDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public long getIdByLogin(String login) {
        return repository.findIdByLogin(login).orElse(0L);
    }

    @Override
    public User getByLogin(String login) {
        return toUser(repository.findByLoginFetchCreds(login));
    }

    @Override
    public UserProfileDto getDtoByLogin(String login) {
        return toDto(getByLogin(login));
    }

    private User toUser(Optional<User> optional) {
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new UserNotFoundException();
    }

    private UserProfileDto toDto(User user) {
        UserProfileDto dto = new UserProfileDto(user.getName(), user.getLastname(), user.getCredentials().getLogin(), user.getPhone(), user.getEmail());
        dto.setBirthday((user.getBirthday() != null) ? user.getBirthday().toString() : null);
        dto.setId(user.getId());
        return dto;
    }
}
