package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String lastname;
    private String login;
    private String phone;
    private String email;
    private String birthday;
    private CredentialsDto credentials;
}
