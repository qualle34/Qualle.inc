package com.qualle.service;

import com.qualle.model.dto.CategoryDto;
import com.qualle.model.dto.ContactDto;
import com.qualle.model.entity.Category;
import com.qualle.model.entity.Summary;

import java.util.List;
import java.util.Map;

public interface ExtraService {

    List<CategoryDto> getAllCategoriesDto();

    List<ContactDto> getAllSummariesDto();

    void add(Summary summary);

    void add(ContactDto dto);

    void add(String vote);

    Map<String, Integer> getVotes();

    ContactDto toSummaryDto(Summary summary);

    CategoryDto toCategoryDto(Category category);
}
