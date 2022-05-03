package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.VacancyDto;
import com.inc.qualle.model.entity.Vacancy;
import com.inc.qualle.repository.VacancyRepository;
import com.inc.qualle.service.VacancyService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.VacancyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl extends AbstractService<Vacancy, VacancyDto, Long> implements VacancyService {

    private final VacancyRepository repository;
    private final VacancyMapper mapper;

    @Override
    protected CrudRepository<Vacancy, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Vacancy, VacancyDto> getMapper() {
        return mapper;
    }
}
