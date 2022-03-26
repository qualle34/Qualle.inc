package com.inc.qualle.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private long id;
    private String number;
    private String date;
    private long userId;
    private long metadataId;
}
