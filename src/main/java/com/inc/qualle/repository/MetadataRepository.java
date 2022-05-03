package com.inc.qualle.repository;

import com.inc.qualle.model.entity.Metadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends CrudRepository<Metadata, Long> {
}
