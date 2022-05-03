package com.inc.qualle.service.mapper;

import java.util.Collection;

public interface BaseMapper<T, DTO> {

    DTO toDto(T entity);

    Collection<DTO> toDto(Collection<T> entity);

    T toEntity(DTO dto);
}