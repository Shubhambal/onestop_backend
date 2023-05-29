package com.infobell.one_stop.service;

import java.util.List;
import com.infobell.one_stop.model.Product;

public interface ProductService {

    /**
     * Retrieves all products.
     *
     * @return A list of products.
     */
    public List<Product> getProduct();

    /**
     * Adds a new product.
     *
     * @param product The product to add.
     * @return The added product.
     */
    public Product addProduct(Product product);

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product, or null if not found.
     */
    public Product getProductById(String id);

    /**
     * Updates an existing product.
     *
     * @param product The product to update.
     * @return The updated product, or null if not found.
     */
    public Product updateProduct(Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return A status message indicating the result of the delete operation.
     */
    public String deleteById(int id);
}
