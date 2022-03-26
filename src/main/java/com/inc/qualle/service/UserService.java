package com.inc.qualle.service;

import com.inc.qualle.model.dto.ProfileDto;
import com.inc.qualle.model.dto.RegistrationDto;
import com.inc.qualle.model.dto.UserDto;

public interface UserService extends BaseService<UserDto, Long>  {

    long getIdByLogin(String login);

    UserDto getWithCredentialsByLogin(String login);

    ProfileDto getProfileByLogin(String login);

    void addProductToCart(String login, long productId);

    void addProductsToPurchases(String login);

    void clearCart(String login);

    void removeProductFromCart(String login, long productId);

    void register(RegistrationDto dto);
}

