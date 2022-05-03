package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private long id;
    private String text;
    private int score;
    private MetadataDto metadata;
}