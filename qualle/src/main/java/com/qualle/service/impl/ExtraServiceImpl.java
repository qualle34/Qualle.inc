package com.qualle.service.impl;

import com.qualle.model.dto.CategoryDto;
import com.qualle.model.dto.SummaryDto;
import com.qualle.model.dto.DeveloperDto;
import com.qualle.model.entity.Category;
import com.qualle.model.entity.Developer;
import com.qualle.model.entity.Summary;
import com.qualle.repository.CategoryRepository;
import com.qualle.repository.DeveloperRepository;
import com.qualle.repository.SummaryRepository;
import com.qualle.service.ExtraService;
import com.qualle.service.util.FilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        return ((List<Summary>) summaryRepository.findAll()).stream().map(this::toDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public SummaryDto getSummaryDtoById(long id) {
        return toDto(summaryRepository.findById(id).get());
    }

    @Override
    public void add(CategoryDto dto) {

    }

    @Override
    public void add(Summary summary) {
        summaryRepository.save(summary);
    }

    @Override
    public void add(SummaryDto dto) {
        add(fromDto(dto));
    }

    @Override
    public void add(String vote) {
        FilesUtil.write(vote);
    }

    @Override
    public Map<String, Integer> getVotes() {
        return FilesUtil.read();
    }

    @Override
    public SummaryDto toDto(Summary summary) {
        SummaryDto dto = new SummaryDto(summary.getName(), summary.getEmail(), summary.getPhone(), summary.getMessage());
        dto.setId(summary.getId());
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

    private Summary fromDto(SummaryDto dto) {
        return new Summary(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getMessage());
    }
}
