package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Feedback;
import com.inc.qualle.repository.FeedbackRepository;
import com.inc.qualle.service.dao.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl extends AbstractService<Feedback, Long> implements FeedbackService {

    private final FeedbackRepository repository;

    @Override
    protected CrudRepository<Feedback, Long> getRepository() {
        return repository;
    }
}
