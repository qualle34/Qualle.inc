package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Category;
import com.inc.qualle.repository.CategoryRepository;
import com.inc.qualle.service.dao.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends AbstractService<Category, Long> implements CategoryService {

    private final CategoryRepository repository;

    @Override
    protected CrudRepository<Category, Long> getRepository() {
        return repository;
    }
}
