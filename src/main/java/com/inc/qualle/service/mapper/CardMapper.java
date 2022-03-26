package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.CardDto;
import com.inc.qualle.model.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends BaseMapper<Card, CardDto> {
}