package com.inc.qualle.repository;

import com.inc.qualle.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("FROM Product g JOIN FETCH g.category c")
    Collection<Product> findAllWithCategory();

    @Query("FROM Product g JOIN FETCH g.category c JOIN FETCH g.image i")
    Collection<Product> findAllWithCategoryAndImage();

    Collection<Product> findByTitleContaining(String title);

    @Query("FROM Product g WHERE (SELECT u FROM User u WHERE :id = u.id) MEMBER OF g.purchases")
    Collection<Product> findByUserId(@Param("id") long id);

    @Query("FROM Product g WHERE (SELECT c FROM User c WHERE :id = c.id) MEMBER OF g.carts")
    Collection<Product> findByCartId(@Param("id") long id);

    Collection<Product> findAllByTitleContainingOrderByPriceDesc(String title);

    Collection<Product> findAllByTitleContainingOrderByPrice(String title);

    Collection<Product> findAllByTitleContainingOrderByTitle(String title);

    @Query("FROM Product g JOIN FETCH g.metadata AS m WHERE g.title like %:title% ORDER BY m.createdBy")
    Collection<Product> findAllByTitleContainingOrderByMetadata(@Param("title") String title);

    @Query("FROM Product g WHERE g.title like %:title% and g.category in (SELECT c FROM Category c WHERE c.id in :categories)")
    Collection<Product> findByTitleContainingAndCategoryIn(@Param("title") String title, @Param("categories") Collection<Long> categories);

    @Query("FROM Product g WHERE g.title like %:title% and g.genre in (SELECT g FROM Genre g WHERE g.id in :genres)")
    Collection<Product> findByTitleContainingAndGenreIn(@Param("title") String title, @Param("genres") Collection<Long> genres);

    @Query("FROM Product g WHERE g.title like %:title% and g.category in (SELECT c FROM Category c WHERE c.id in :categories) and g.genre in (SELECT g FROM Genre g WHERE g.id in :genres)")
    Collection<Product> findByTitleContainingAndCategoryInAndGenreIn(@Param("title") String title, @Param("categories") Collection<Long> categories, @Param("genres") Collection<Long> genres);


}
