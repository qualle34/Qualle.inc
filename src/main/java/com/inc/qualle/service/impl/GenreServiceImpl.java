package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.GenreDto;
import com.inc.qualle.model.entity.Genre;
import com.inc.qualle.repository.GenreRepository;
import com.inc.qualle.service.GenreService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends AbstractService<Genre, GenreDto, Long> implements GenreService {

    private final GenreRepository repository;
    private final GenreMapper mapper;

    @Override
    protected CrudRepository<Genre, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Genre, GenreDto> getMapper() {
        return mapper;
    }
}
