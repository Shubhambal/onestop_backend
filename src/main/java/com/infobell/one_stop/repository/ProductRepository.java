package com.infobell.one_stop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobell.one_stop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByProductId(String i);
}
