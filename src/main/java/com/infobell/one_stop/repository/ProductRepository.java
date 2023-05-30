package com.infobell.one_stop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infobell.one_stop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByProductId(String i);
    
    @Modifying
	@Query("from Product where product_name like :search")
	List<Product> getProductsBySearch(@Param("search")String search );
}
