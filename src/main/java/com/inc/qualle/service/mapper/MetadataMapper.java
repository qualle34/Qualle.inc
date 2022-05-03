package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.MetadataDto;
import com.inc.qualle.model.entity.Metadata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetadataMapper extends BaseMapper<Metadata, MetadataDto> {
}