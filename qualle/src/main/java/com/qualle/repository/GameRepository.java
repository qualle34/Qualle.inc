package com.qualle.repository;

import com.qualle.model.entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAll();

    @Query("FROM Game g JOIN FETCH g.category c")
    List<Game> findAllWithCategory();

    @Query("FROM Game g WHERE g.name LIKE :name")
    List<Game> findByName(@Param("name") String name);

    @Query("FROM Game g WHERE (SELECT u FROM User u WHERE :id = u.id) MEMBER OF g.users")
    List<Game> findByUserId(@Param("id") long id);

    @Query("FROM Game g WHERE (SELECT c FROM Cart c WHERE :id = c.id) MEMBER OF g.carts")
    List<Game> findByCartId(@Param("id") long id);
}
