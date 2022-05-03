package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.MetadataDto;
import com.inc.qualle.model.entity.Metadata;
import com.inc.qualle.repository.MetadataRepository;
import com.inc.qualle.service.MetadataService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.MetadataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataServiceImpl extends AbstractService<Metadata, MetadataDto, Long> implements MetadataService {

    private final MetadataRepository repository;
    private final MetadataMapper mapper;

    @Override
    protected CrudRepository<Metadata, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Metadata, MetadataDto> getMapper() {
        return mapper;
    }
}
