package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Developer;
import com.inc.qualle.repository.DeveloperRepository;
import com.inc.qualle.service.dao.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl extends AbstractService<Developer, Long> implements DeveloperService {

    private final DeveloperRepository repository;

    @Override
    protected CrudRepository<Developer, Long> getRepository() {
        return repository;
    }
}
