package com.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.entities.Category;
import com.emart.entities.Customer;
import com.emart.entities.ProductDetails;

/**
 * Repository interface for managing ProductDetails entities.
 * @author  Madhavi
 * @version 3.9.10
 * @since   24-05-2023
 */
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

    /**
     * Retrieve a list of product details for a given product ID.
     *
     * @param product The product ID.
     * @return A list of product details.
     */
    @Modifying
    @Query("from ProductDetails pd where pd.product.p_Id = :product")
    List<ProductDetails> getDetails(@Param("product") int product);

    
}
