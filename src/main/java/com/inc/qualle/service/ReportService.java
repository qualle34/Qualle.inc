package com.inc.qualle.service;

import com.inc.qualle.model.dto.ProductDto;

import java.util.Collection;

public interface ReportService {

    void generate(Collection<ProductDto> dto);
}
