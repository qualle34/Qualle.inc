package com.inc.qualle.service.mapper;

import com.inc.qualle.model.dto.FeedbackDto;
import com.inc.qualle.model.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper extends BaseMapper<Feedback, FeedbackDto> {
}