package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private String login;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String birthday;
    private String password;
}
