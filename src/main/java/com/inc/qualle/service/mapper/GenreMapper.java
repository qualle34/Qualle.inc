package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.GenreDto;
import com.inc.qualle.model.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper extends BaseMapper<Genre, GenreDto> {
}