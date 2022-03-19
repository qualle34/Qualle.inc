package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Review;
import com.inc.qualle.repository.ReviewRepository;
import com.inc.qualle.service.dao.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends AbstractService<Review, Long> implements ReviewService {

    private final ReviewRepository repository;

    @Override
    protected CrudRepository<Review, Long> getRepository() {
        return repository;
    }
}
