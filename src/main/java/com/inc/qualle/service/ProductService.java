package com.inc.qualle.service;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.dto.SaveProductDto;

import java.util.Collection;

public interface ProductService extends BaseService<ProductDto, Long> {

    Collection<SimpleProductDto> getAllSimple();

    Collection<SimpleProductDto> getAllWithCategory();

    Collection<ProductDto> getByUser(long id);

    Collection<ProductDto> getByUser(String login);

    Collection<ProductDto> getByCart(long cartId);

    Collection<SimpleProductDto> getByTitle(String title);

    void save(SaveProductDto dto);
}
