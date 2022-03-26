package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.CategoryDto;
import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.entity.Category;
import com.inc.qualle.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
}
//    private ProductSimpleDto toSimpleDto(Product product) {
//        ProductSimpleDto dto = new ProductSimpleDto(product.getTitle(), product.getPrice(), product.getImage().getLink());
//        dto.setId(product.getId());
//        return dto;
//    }
//
//    private Product fromDto(ProductDto dto) {
//        Product product =  Product.builder()
//                .title(dto.getName())
//                .description(dto.getDescription())
//                .price(dto.getPrice())
//                .build();
//        product.setId(dto.getId());
//        product.setImage(Image.builder().link(dto.getImg()).build());
//        product.setCategory(categoryRepository.findById(dto.getCategoryId()).get());
//        product.setDeveloper(developerRepository.findById(dto.getDeveloperId()).get());
//        return product;
//    }