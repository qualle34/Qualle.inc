package com.inc.qualle.service;

import com.inc.qualle.model.dto.CategoryDto;
import com.inc.qualle.model.dto.DeveloperDto;
import com.inc.qualle.model.dto.SummaryDto;
import com.inc.qualle.model.entity.Category;
import com.inc.qualle.model.entity.Developer;
import com.inc.qualle.model.entity.Feedback;

import java.util.List;

public interface ExtraService {

    List<CategoryDto> getAllCategoriesDto();

    CategoryDto getCategoryDtoById(long id);

    List<DeveloperDto> getAllDeveloperDto();

    DeveloperDto getDeveloperDtoById(long id);

    List<SummaryDto> getAllSummariesDto();

    SummaryDto getSummaryDtoById(long id);

    void add(CategoryDto dto);

    void add(DeveloperDto dto);

    void add(Feedback feedback);

    void add(SummaryDto dto);

    SummaryDto toDto(Feedback feedback);

    CategoryDto toDto(Category category);

    DeveloperDto toDto(Developer developer);
}
