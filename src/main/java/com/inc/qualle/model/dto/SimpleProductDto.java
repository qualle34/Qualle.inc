package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleProductDto {

    private long id;
    private String title;
    private double price;
    private String type;
    private CategoryDto category;
    private ImageDto image;
}
