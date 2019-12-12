package com.qualle.api.dao;

import com.qualle.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao {

    User getUserByLogin(String login);
}
