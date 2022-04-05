package com.inc.qualle.repository;

import com.inc.qualle.model.entity.Session;
import com.inc.qualle.model.entity.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
}