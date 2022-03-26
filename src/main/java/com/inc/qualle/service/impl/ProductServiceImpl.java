package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.ProductDto;
import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.entity.Product;
import com.inc.qualle.repository.ProductRepository;
import com.inc.qualle.service.ProductService;
import com.inc.qualle.service.UserService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.ProductMapper;
import com.inc.qualle.service.mapper.SimpleProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractService<Product, ProductDto, Long> implements ProductService {

    private final ProductRepository repository;
    private final UserService userService;

    private final ProductMapper mapper;
    private final SimpleProductMapper simpleMapper;

    @Override
    protected CrudRepository<Product, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Product, ProductDto> getMapper() {
        return mapper;
    }

    @Override
    public Collection<SimpleProductDto> getAllWithCategory() {
        return simpleMapper.toDto(repository.findAllWithCategory());
    }

    @Override
    public Collection<ProductDto> getByUser(long id) {
        return mapper.toDto(repository.findByUserId(id));
    }

    @Override
    public Collection<ProductDto> getByUser(String login) {
        return getByUser(userService.getIdByLogin(login));
    }

    @Override
    public Collection<ProductDto> getByCart(long cartId) {
        return mapper.toDto(repository.findByCartId(cartId));
    }

    @Override
    public Collection<ProductDto> getByTitle(String title) {
        return mapper.toDto(repository.findByName("%" + title + "%"));
    }
}
