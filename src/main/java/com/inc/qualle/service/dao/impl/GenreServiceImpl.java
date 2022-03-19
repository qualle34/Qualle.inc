package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Genre;
import com.inc.qualle.repository.GenreRepository;
import com.inc.qualle.service.dao.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends AbstractService<Genre, Long> implements GenreService {

    private final GenreRepository repository;

    @Override
    protected CrudRepository<Genre, Long> getRepository() {
        return repository;
    }
}
