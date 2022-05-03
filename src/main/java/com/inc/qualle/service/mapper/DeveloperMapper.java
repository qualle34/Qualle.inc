package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.DeveloperDto;
import com.inc.qualle.model.entity.Developer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeveloperMapper extends BaseMapper<Developer, DeveloperDto> {
}
