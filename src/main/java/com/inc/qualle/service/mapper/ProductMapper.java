package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    @Override
    default Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}