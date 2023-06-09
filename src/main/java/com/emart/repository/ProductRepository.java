package com.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emart.entities.Category;
import com.emart.entities.Product;

/**
 * Repository interface for managing Product entities.
  * @author  Devesh
  * @version 3.9.10
  * @since   24-05-2023
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Retrieve a list of products for a given category ID.
     *
     * @param category_Id The category ID.
     * @return A list of products.
     */
//    @Modifying
//    @Query("from Product p where p.cat_Id = :category_Id")
////    List<Product> getProducts(@Param("category_Id") int category_Id);
////
////    /**
////     * Retrieve a list of products matching a search keyword.
////     *
////     * @param search The search keyword.
////     * @return A list of products.
////     */
    @Modifying
    @Query("from Product p where p.p_Name like %:search%")
    List<Product> getProductsBySearch(@Param("search") String search);

    /**
     * Retrieve a list of products with promotion.
     *
     * @return A list of products.
     */
    @Modifying
    @Query("from Product p where p.p_Promotion = true")
    List<Product> getProductsByPromotion();


}
