package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.CategoryDto;
import com.inc.qualle.model.entity.Category;
import com.inc.qualle.repository.CategoryRepository;
import com.inc.qualle.service.CategoryService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends AbstractService<Category, CategoryDto, Long> implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    protected CrudRepository<Category, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Category, CategoryDto> getMapper() {
        return mapper;
    }
}
