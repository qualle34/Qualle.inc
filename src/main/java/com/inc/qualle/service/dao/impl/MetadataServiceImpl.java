package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Metadata;
import com.inc.qualle.repository.MetadataRepository;
import com.inc.qualle.service.dao.MetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetadataServiceImpl extends AbstractService<Metadata, Long> implements MetadataService {

    private final MetadataRepository repository;

    @Override
    protected CrudRepository<Metadata, Long> getRepository() {
        return repository;
    }
}
