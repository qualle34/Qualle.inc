package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.RegistrationDto;
import com.inc.qualle.model.dto.UserDto;
import com.inc.qualle.model.entity.Credentials;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.model.entity.UserRole;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {

    default User toEntity(RegistrationDto dto) {
        Credentials credentials = Credentials.builder()
                .login(dto.getLogin())
                .role(UserRole.USER)
                .build();

        User user = User.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .birthday(LocalDate.parse(dto.getBirthday()))
                .credentials(credentials)
                .build();
        credentials.setUser(user);

        return user;
    }
}