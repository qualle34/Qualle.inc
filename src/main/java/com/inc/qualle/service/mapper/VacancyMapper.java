package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.VacancyDto;
import com.inc.qualle.model.entity.Vacancy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacancyMapper extends BaseMapper<Vacancy, VacancyDto> {
}