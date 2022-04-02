package com.inc.qualle.model.dto;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveProductDto {

    private long id;
    private String title;
    private String description;
    private double price;
    private long developerId;
    private long categoryId;
    private long genreId;
    private String image;
    private MetadataDto metadata;
    private Collection<ReviewDto> reviews;
}
