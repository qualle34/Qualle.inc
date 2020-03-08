package com.qualle.service.impl;

import com.qualle.model.dto.CategoryDto;
import com.qualle.model.dto.ContactDto;
import com.qualle.model.entity.Category;
import com.qualle.model.entity.Summary;
import com.qualle.repository.CategoryRepository;
import com.qualle.repository.ContactRepository;
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
    private ContactRepository contactRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public List<CategoryDto> getAllCategoriesDto() {
        return ((List<Category>) categoryRepository.findAll()).stream().map(this::toCategoryDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<ContactDto> getAllSummariesDto() {
        return ((List<Summary>) summaryRepository.findAll()).stream().map(this::toSummaryDto).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void add(Summary summary) {
        contactRepository.save(summary);
    }

    @Override
    public void add(ContactDto dto) {
        add(toSummary(dto));
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
    public CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto(category.getTitle(), category.getLocalTitle());
        dto.setId(category.getId());
        return dto;
    }

    @Override
    public ContactDto toSummaryDto(Summary summary) {
        ContactDto dto = new ContactDto(summary.getName(), summary.getEmail(), summary.getPhone(), summary.getMessage());
        dto.setId(summary.getId());
        return dto;
    }

    private Summary toSummary(ContactDto dto) {
        return new Summary(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getMessage());
    }
}
