package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleProductMapper extends BaseMapper<Product, SimpleProductDto> {
}