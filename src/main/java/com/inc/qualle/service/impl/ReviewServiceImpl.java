package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.ReviewDto;
import com.inc.qualle.model.entity.Review;
import com.inc.qualle.repository.ReviewRepository;
import com.inc.qualle.service.ReviewService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends AbstractService<Review, ReviewDto, Long> implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    @Override
    protected CrudRepository<Review, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Review, ReviewDto> getMapper() {
        return mapper;
    }
}
