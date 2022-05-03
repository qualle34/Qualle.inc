package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.ReviewDto;
import com.inc.qualle.model.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends BaseMapper<Review, ReviewDto> {
}