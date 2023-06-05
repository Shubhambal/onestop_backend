package com.emart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emart.entities.Category;
import com.emart.entities.Product;
import com.emart.exception.ProductNotFoundException;
import com.emart.services.CategoryManager;
import com.emart.services.ProductManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ProductController class handles the API endpoints related to Product operations.
 * 
 * Author: Devesh
 * Version: 3.9.10
 * Date: 24-05-2023
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    ProductManager manager;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    /**
     * Get all products
     *
     * @return List of products
     */
    @GetMapping(value = "api/products")
    public List<Product> showProducts() {
        logger.info("GET /api/products");

        return manager.getProducts();
    }

    /**
     * Get product by ID
     *
     * @param pid Product ID
     * @return Optional of Product
     * @throws ProductNotFoundException if product is not found
     */
    @GetMapping(value = "api/productsById/{pid}")
    public Optional<Product> getProduct(@PathVariable int pid) {
        logger.info("GET /api/productsById/{}", pid);

        Optional<Product> product = manager.getProduct(pid);
        if (product.isPresent()) {
            return product;
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + pid);
        }
    }

    /**
     * Remove product by ID
     *
     * @param pid Product ID
     * @throws ProductNotFoundException if product is not found
     */
    @DeleteMapping(value = "api/products/{pid}")
    public void removeProduct(@PathVariable int pid) {
//        if (!manager.exists(pid)) {
//            throw new ProductNotFoundException("Product not found with ID: " + pid);
//        }
        manager.delete(pid);
    }

    /**
     * Add a new product
     *
     * @param product Product object
     */
    @PostMapping(value = "api/products")
    public void addProduct(@RequestBody Product product) {
        logger.info("POST /api/products");
        logger.info("Product: {}", product);

        manager.addProduct(product);
    }

    /**
     * Get products by category ID
     *
     * @param cat_Id Category ID
     * @return List of products
     * @throws ProductNotFoundException if no products found for the specified category
     */
//    @GetMapping(value = "api/productsByCat/{cat_Id}")
//    public List<Product> getProductsByCategory(@PathVariable int cat_Id) {
//        List<Product> products = manager.getProductsBySearch(cat_Id);
//        if (products.isEmpty()) {
//            throw new ProductNotFoundException("No products found for category ID: " + cat_Id);
//        }
//        return products;
//    }

    /**
     * Search products by keyword
     *
     * @param search Search keyword
     * @return List of products
     * @throws ProductNotFoundException if no products found for the specified keyword
     */
    @GetMapping(value = "api/search/{search}")
    public List<Product> searchProducts(@PathVariable String search) {
        logger.info("GET /api/search/{}", search);

        List<Product> products = manager.searchProducts(search);
//        if (products.isEmpty()) {
//            throw new ProductNotFoundException("No products found for search keyword: " + search);
//        }
        return products;
    }

    /**
     * Get products by promotion
     *
     * @return List of products
     * @throws ProductNotFoundException if no products found with promotion
     */
//    @GetMapping(value = "api/promotion")
//    public List<Product> getProductsByPromotion() {
//        List<Product> products = manager.getProductsByPromotion();
//        if (products.isEmpty()) {
//            throw new ProductNotFoundException("No products found with promotion");
//        }
//        return products;
//    }
}
