package com.infobell.one_stop.service;

import com.infobell.one_stop.model.ProductDetails;

public interface ProductDetailsService {
    /**
     * Retrieves the product details by ID.
     *
     * @param id The ID of the product details to retrieve.
     * @return The product details with the specified ID.
     */
    ProductDetails getProductDetailsById(int id);

    /**
     * Creates a new product details.
     *
     * @param productDetails The product details to create.
     * @return The created product details.
     */
    ProductDetails createProductDetails(ProductDetails productDetails);

    /**
     * Updates an existing product details.
     *
     * @param id             The ID of the product details to update.
     * @param productDetails The updated product details.
     * @return The updated product details.
     */
    ProductDetails updateProductDetails(int id, ProductDetails productDetails);

    /**
     * Deletes the product details by ID.
     *
     * @param id The ID of the product details to delete.
     * @return A message indicating the result of the deletion.
     */
    String deleteProductDetails(int id);
}
