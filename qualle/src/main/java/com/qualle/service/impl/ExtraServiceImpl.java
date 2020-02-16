package com.qualle.service.impl;

import com.qualle.model.dto.ContactDto;
import com.qualle.model.entity.Summary;
import com.qualle.repository.ContactRepository;
import com.qualle.service.ExtraService;
import com.qualle.service.util.FilesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExtraServiceImpl implements ExtraService {

    @Autowired
    ContactRepository contactRepository;

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

    private Summary toSummary(ContactDto dto){
        return new Summary(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getMessage());
    }
}
