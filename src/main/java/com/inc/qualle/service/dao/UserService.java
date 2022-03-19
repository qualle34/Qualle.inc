package com.inc.qualle.service.dao;

import com.inc.qualle.model.dto.UserProfileDto;
import com.inc.qualle.model.dto.UserRegistrationDto;
import com.inc.qualle.model.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, Long>  {

    List<UserProfileDto> getAllDto();

    UserProfileDto getDtoById(long id);

    long getIdByLogin(String login);

    User getByLogin(String login);

    UserProfileDto getDtoByLogin(String login);
}

