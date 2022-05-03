package com.inc.qualle.service.impl;

import com.inc.qualle.service.BaseService;
import com.inc.qualle.service.mapper.BaseMapper;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public abstract class AbstractService<T, DTO, ID> implements BaseService<DTO, ID> {

    @Override
    public Collection<DTO> getAll() {
        List<T> result = new ArrayList<>();
        getRepository().findAll().forEach(result::add);
        return getMapper().toDto(result);
    }

    @Override
    public DTO getById(ID id) {
        return getMapper().toDto(getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    @Override
    public DTO save(DTO dto) {
        return getMapper().toDto(getRepository().save(getMapper().toEntity(dto)));
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    protected abstract CrudRepository<T, ID> getRepository();

    protected abstract BaseMapper<T, DTO> getMapper();
}
