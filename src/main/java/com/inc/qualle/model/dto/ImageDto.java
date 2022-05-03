package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private long id;
    private String name;
    private String link;
}
