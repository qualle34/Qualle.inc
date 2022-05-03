package com.inc.qualle.model.dto;

import lombok.*;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    UserDto user;
    Collection<SimpleProductDto> purchases;
    Collection<SimpleProductDto> cart;
    Collection<CardDto> cards;
}
