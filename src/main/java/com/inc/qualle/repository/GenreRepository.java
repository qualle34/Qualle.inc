package com.inc.qualle.repository;

import com.inc.qualle.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository  extends CrudRepository<Genre, Long> {
}
