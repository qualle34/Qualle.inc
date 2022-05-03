package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.DeveloperDto;
import com.inc.qualle.model.entity.Developer;
import com.inc.qualle.repository.DeveloperRepository;
import com.inc.qualle.service.DeveloperService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.DeveloperMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl extends AbstractService<Developer, DeveloperDto, Long> implements DeveloperService {

    private final DeveloperRepository repository;
    private final DeveloperMapper mapper;

    @Override
    protected CrudRepository<Developer, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Developer, DeveloperDto> getMapper() {
        return mapper;
    }
}
