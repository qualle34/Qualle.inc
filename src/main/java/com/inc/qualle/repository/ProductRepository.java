package com.inc.qualle.repository;

import com.inc.qualle.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    @Query("FROM Product g JOIN FETCH g.category c")
    List<Product> findAllWithCategory();

    @Query("FROM Product g WHERE g.name LIKE :name")
    List<Product> findByName(@Param("name") String name);

    @Query("FROM Product g WHERE (SELECT u FROM User u WHERE :id = u.id) MEMBER OF g.users")
    List<Product> findByUserId(@Param("id") long id);

    @Query("FROM Product g WHERE (SELECT c FROM Cart c WHERE :id = c.id) MEMBER OF g.carts")
    List<Product> findByCartId(@Param("id") long id);
}
