package com.qualle.repository;

import com.qualle.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("FROM User u JOIN FETCH u.creds c WHERE c.login = :login")
    Optional<User> findByLoginFetchCreds(@Param("login") String login);

    @Query("SELECT c.id FROM Creds c WHERE c.login = :login")
    Optional<Long> findIdByLogin(@Param("login") String login);
}
