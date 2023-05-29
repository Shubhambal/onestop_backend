package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.ProductDetails;
import com.infobell.one_stop.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private final ProductDetailsRepository productDetailsRepository;

    @Autowired
    public ProductDetailsServiceImpl(ProductDetailsRepository productDetailsRepository) {
        this.productDetailsRepository = productDetailsRepository;
    }

    @Override
    public ProductDetails getProductDetailsById(int id) {
        // Retrieve product details by ID from the repository
        return productDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Details", "id", String.valueOf(id)));
    }

    @Override
    public ProductDetails createProductDetails(ProductDetails productDetails) {
        // Save new product details to the repository
        return productDetailsRepository.save(productDetails);
    }

    @Override
    public ProductDetails updateProductDetails(int id, ProductDetails productDetails) {
        // Retrieve existing product details by ID from the repository
        ProductDetails existingProductDetails = getProductDetailsById(id);
        // Update the properties of the existing product details
        existingProductDetails.setDiscount(productDetails.getDiscount());
        existingProductDetails.setSpecification(productDetails.getSpecification());
        existingProductDetails.setProduct(productDetails.getProduct());

        // Save the updated product details to the repository
        return productDetailsRepository.save(existingProductDetails);
    }

    @Override
    public String deleteProductDetails(int id) {
        if (productDetailsRepository.existsById(id)) {
            // Delete product details by ID from the repository
            productDetailsRepository.deleteById(id);
            return "Product Details with ID " + id + " deleted.";
        } else {
            throw new ResourceNotFoundException("Product Details", "id", String.valueOf(id));
        }
    }
}
