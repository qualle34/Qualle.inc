package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.FeedbackDto;
import com.inc.qualle.model.entity.Feedback;
import com.inc.qualle.repository.FeedbackRepository;
import com.inc.qualle.service.FeedbackService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.FeedbackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl extends AbstractService<Feedback, FeedbackDto, Long> implements FeedbackService {

    private final FeedbackRepository repository;
    private final FeedbackMapper mapper;

    @Override
    protected CrudRepository<Feedback, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Feedback, FeedbackDto> getMapper() {
        return mapper;
    }
}
