package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto {

    private long id;
    private String title;
    private String description;
    private MetadataDto metadata;
}
