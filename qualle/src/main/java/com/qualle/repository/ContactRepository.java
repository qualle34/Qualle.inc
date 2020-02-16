package com.qualle.repository;

import com.qualle.model.entity.Summary;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Summary, Long> {
}
