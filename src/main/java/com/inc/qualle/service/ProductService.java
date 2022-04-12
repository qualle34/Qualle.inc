package com.inc.qualle.service;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.dto.SaveProductDto;
import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.entity.Product;

import java.util.Collection;

public interface ProductService extends BaseService<ProductDto, Long> {

    Collection<SimpleProductDto> getAllSimple();

    Collection<SimpleProductDto> getAllWithCategory();

    Collection<ProductDto> getByUser(long id);

    Collection<ProductDto> getByUser(String login);

    Collection<ProductDto> getByCart(long cartId);

    Collection<SimpleProductDto> getByTitle(String title);

    Collection<SimpleProductDto> getByTitleAndCategoryAndGenre(String title, Collection<Long> categories, Collection<Long> genres);

    Collection<SimpleProductDto> getByTitleOrderBy(String title, String order);

    void save(SaveProductDto dto);
}
