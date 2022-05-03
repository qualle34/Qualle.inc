package com.inc.qualle.model.dto;

import com.inc.qualle.model.entity.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDto {

    private long id;
    private String login;
    private String password;
    private UserRole role;
}
