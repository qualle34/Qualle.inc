package com.inc.qualle.service;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.dto.SimpleProductDto;

import java.util.Collection;

public interface ProductService extends BaseService<ProductDto, Long> {

    Collection<SimpleProductDto> getAllWithCategory();

    Collection<ProductDto> getByUser(long id);

    Collection<ProductDto> getByUser(String login);

    Collection<ProductDto> getByCart(long cartId);

    Collection<ProductDto> getByTitle(String title);
}
