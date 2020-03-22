package com.qualle.service;

import com.qualle.model.dto.CategoryDto;
import com.qualle.model.dto.SummaryDto;
import com.qualle.model.dto.DeveloperDto;
import com.qualle.model.entity.Category;
import com.qualle.model.entity.Developer;
import com.qualle.model.entity.Summary;

import java.util.List;
import java.util.Map;

public interface ExtraService {

    List<CategoryDto> getAllCategoriesDto();

    CategoryDto getCategoryDtoById(long id);

    List<DeveloperDto> getAllDeveloperDto();

    DeveloperDto getDeveloperDtoById(long id);

    List<SummaryDto> getAllSummariesDto();

    SummaryDto getSummaryDtoById(long id);

    void add(CategoryDto dto);

    void add(DeveloperDto dto);

    void add(Summary summary);

    void add(SummaryDto dto);

    void add(String vote);

    Map<String, Integer> getVotes();

    SummaryDto toDto(Summary summary);

    CategoryDto toDto(Category category);

    DeveloperDto toDto(Developer developer);
}
