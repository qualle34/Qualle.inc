package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

    private long id;
    private String title;
    private String description;
    private UserDto user;
    private MetadataDto metadata;
}
