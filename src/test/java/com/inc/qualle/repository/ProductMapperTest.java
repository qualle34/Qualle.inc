package com.inc.qualle.repository;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.entity.*;
import com.inc.qualle.service.mapper.ProductMapper;
import com.inc.qualle.service.mapper.SimpleProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private SimpleProductMapper simpleProductMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testWhenConvertDtoThanSuccess(){
        Product product = getProduct();

        ProductDto dto = productMapper.toDto(product);

        assertEquals(1, dto.getId());
        assertEquals("Test", dto.getTitle());
        assertEquals("For Test", dto.getDescription());
        assertEquals(10, dto.getPrice());
        assertEquals(ProductType.GAME, dto.getType());
        assertEquals(1, dto.getCategory().getId());
        assertEquals("Test category", dto.getCategory().getValue());
        assertEquals(1, dto.getDeveloper().getId());
        assertEquals("Test developer", dto.getDeveloper().getTitle());
        assertEquals("Description", dto.getDeveloper().getDescription());
        assertEquals(1, dto.getGenre().getId());
        assertEquals("Test genre", dto.getGenre().getValue());
        assertEquals(1, dto.getImage().getId());
        assertEquals("Test link", dto.getImage().getLink());
        assertEquals(1, dto.getMetadata().getId());
        assertEquals("User", dto.getMetadata().getCreatedBy());
    }

    @Test
    public Product getProduct() {
        return Product.builder()
                .id(1)
                .title("Test")
                .description("For Test")
                .price(10)
                .type(ProductType.GAME)
                .category(Category.builder().id(1).value("Test category").build())
                .developer(Developer.builder().id(1).title("Test developer").description("Description").build())
                .genre(Genre.builder().id(1).value("Test genre").build())
                .image(Image.builder().id(1).link("Test link").build())
                .metadata(Metadata.builder().id(1).createdAt(LocalDateTime.now()).createdBy("User").build())
                .build();
    }

    @Test
    public void testWhenConvertSimpleDtoThanSuccess(){
        Product product = getProduct();

        SimpleProductDto dto = simpleProductMapper.toDto(product);

        assertEquals(1, dto.getId());
        assertEquals("Test", dto.getTitle());
        assertEquals(10, dto.getPrice());
        assertEquals(ProductType.GAME, dto.getType());
        assertEquals(1, dto.getCategory().getId());
        assertEquals("Test category", dto.getCategory().getValue());
        assertEquals(1, dto.getImage().getId());
        assertEquals("Test link", dto.getImage().getLink());
    }

}
