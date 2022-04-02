package com.inc.qualle.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    private long id;
    private String value;

    public GenreDto(long id) {
        this.id = id;
    }
}
