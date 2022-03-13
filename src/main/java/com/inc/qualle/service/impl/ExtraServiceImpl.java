package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.CategoryDto;
import com.inc.qualle.model.dto.SummaryDto;
import com.inc.qualle.model.entity.Feedback;
import com.inc.qualle.repository.CategoryRepository;
import com.inc.qualle.repository.DeveloperRepository;
import com.inc.qualle.repository.SummaryRepository;
import com.inc.qualle.model.dto.DeveloperDto;
import com.inc.qualle.model.entity.Category;
import com.inc.qualle.model.entity.Developer;
import com.inc.qualle.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtraServiceImpl implements ExtraService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<CategoryDto> getAllCategoriesDto() {
        return ((List<Category>) categoryRepository.findAll()).stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public CategoryDto getCategoryDtoById(long id) {
        return toDto(categoryRepository.findById(id).get());
    }

    @Override
    public List<DeveloperDto> getAllDeveloperDto() {
        return ((List<Developer>) developerRepository.findAll()).stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public DeveloperDto getDeveloperDtoById(long id) {
        return toDto(developerRepository.findById(id).get());
    }

    @Override
    public List<SummaryDto> getAllSummariesDto() {
        return ((List<Feedback>) summaryRepository.findAll()).stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public SummaryDto getSummaryDtoById(long id) {
        return toDto(summaryRepository.findById(id).get());
    }

    @Override
    public void add(CategoryDto dto) {
        Category category = new Category(dto.getTitle());
        category.setLocalTitle(dto.getTitle());
        categoryRepository.save(category);
    }

    @Override
    public void add(DeveloperDto dto) {
        developerRepository.save(new Developer(dto.getTitle(), dto.getDescription(), dto.getContacts(), dto.getAddress()));
    }

    @Override
    public void add(Feedback feedback) {
        summaryRepository.save(feedback);
    }

    @Override
    public void add(SummaryDto dto) {
        add(fromDto(dto));
    }

    @Override
    public SummaryDto toDto(Feedback feedback) {
        SummaryDto dto = new SummaryDto(feedback.getName(), feedback.getEmail(), feedback.getPhone(), feedback.getMessage());
        dto.setId(feedback.getId());
        return dto;
    }

    @Override
    public CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto(category.getTitle(), category.getLocalTitle());
        dto.setId(category.getId());
        return dto;
    }

    @Override
    public DeveloperDto toDto(Developer developer) {
        DeveloperDto dto = new DeveloperDto(developer.getTitle(), developer.getDescription(), developer.getContacts(), developer.getAddress());
        dto.setId(developer.getId());
        return dto;
    }

    private Feedback fromDto(SummaryDto dto) {
        return new Feedback(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getMessage());
    }
}