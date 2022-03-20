package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.UserRegistrationDto;
import com.inc.qualle.model.entity.Credentials;
import com.inc.qualle.model.entity.UserRole;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.service.RegistrationService;
import com.inc.qualle.service.dao.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public void register(UserRegistrationDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();

        Credentials credentials = Credentials.builder()
                .login(dto.getLogin())
                .password(encoder.encode(dto.getPassword()))
                .role(UserRole.USER)
                .user(user)
                .build();

        user.setCredentials(credentials);
        userService.save(user);
    }
}
