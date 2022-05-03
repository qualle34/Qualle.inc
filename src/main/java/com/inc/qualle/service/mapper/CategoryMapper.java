package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.CategoryDto;
import com.inc.qualle.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
}