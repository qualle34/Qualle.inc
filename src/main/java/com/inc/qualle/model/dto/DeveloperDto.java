package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDto {

    private long id;
    private String title;
    private String description;
    private String contacts;
    private String address;
    private long metadataId;

    public DeveloperDto(long id) {
        this.id = id;
    }
}
