package com.qualle.repository;

import com.qualle.model.entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findByName(String name);

    @Query("FROM Game g WHERE (SELECT u FROM User u WHERE :id = u.id) MEMBER OF g.users")
    List<Game> findByUserId(@Param("id") long id);
}
