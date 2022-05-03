package com.inc.qualle.repository;

import com.inc.qualle.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT c.id FROM Credentials c WHERE c.login = :login")
    Optional<Long> findIdByLogin(@Param("login") String login);

    @Query("SELECT u FROM User u JOIN FETCH u.credentials c WHERE c.login = :login")
    Optional<User> findWithCredentialsByLogin(@Param("login") String login);

    @Query("SELECT u FROM User u JOIN FETCH u.credentials cr LEFT JOIN FETCH u.purchases p LEFT JOIN FETCH u.cards cd LEFT JOIN FETCH u.cart ct WHERE cr.login = :login")
    Optional<User> findWithAllByLogin(@Param("login") String login);
}
