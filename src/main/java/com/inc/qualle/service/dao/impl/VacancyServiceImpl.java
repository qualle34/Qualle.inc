package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Vacancy;
import com.inc.qualle.repository.VacancyRepository;
import com.inc.qualle.service.dao.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl extends AbstractService<Vacancy, Long> implements VacancyService {

    private final VacancyRepository repository;

    @Override
    protected CrudRepository<Vacancy, Long> getRepository() {
        return repository;
    }
}
