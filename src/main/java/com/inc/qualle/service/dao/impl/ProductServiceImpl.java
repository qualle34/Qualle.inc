package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Product;
import com.inc.qualle.repository.ProductRepository;
import com.inc.qualle.service.dao.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractService<Product, Long> implements ProductService {

    private final ProductRepository repository;

    @Override
    protected CrudRepository<Product, Long> getRepository() {
        return repository;
    }
}
