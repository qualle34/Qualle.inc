package com.inc.qualle.model.dto;

import com.inc.qualle.model.entity.ProductType;
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
    private ProductType type;
    private CategoryDto category;
    private ImageDto image;
}
