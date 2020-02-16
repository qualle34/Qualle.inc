package com.qualle.service;

import com.qualle.model.dto.ContactDto;
import com.qualle.model.entity.Summary;

import java.util.Map;

public interface ExtraService {

    void add(Summary summary);

    void add(ContactDto dto);

    void add(String vote);

    public Map<String, Integer> getVotes();
}
