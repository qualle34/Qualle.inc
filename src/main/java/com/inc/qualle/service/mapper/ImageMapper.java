package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.ImageDto;
import com.inc.qualle.model.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends BaseMapper<Image, ImageDto> {
}