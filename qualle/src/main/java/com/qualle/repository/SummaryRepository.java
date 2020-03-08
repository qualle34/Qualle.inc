package com.qualle.repository;

import com.qualle.model.entity.Summary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends CrudRepository<Summary, Long> {
}
