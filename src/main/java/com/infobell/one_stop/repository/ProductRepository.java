package com.infobell.one_stop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infobell.one_stop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByProductId(String id);
}
