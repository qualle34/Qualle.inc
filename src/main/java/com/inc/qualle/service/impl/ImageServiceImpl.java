package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.ImageDto;
import com.inc.qualle.model.entity.Image;
import com.inc.qualle.repository.ImageRepository;
import com.inc.qualle.service.ImageService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl extends AbstractService<Image, ImageDto, Long> implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper mapper;

    @Override
    protected CrudRepository<Image, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Image, ImageDto> getMapper() {
        return mapper;
    }
}
