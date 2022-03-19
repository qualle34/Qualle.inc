package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.entity.Image;
import com.inc.qualle.repository.ImageRepository;
import com.inc.qualle.service.dao.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl extends AbstractService<Image, Long> implements ImageService {

    private final ImageRepository repository;

    @Override
    protected CrudRepository<Image, Long> getRepository() {
        return repository;
    }
}
