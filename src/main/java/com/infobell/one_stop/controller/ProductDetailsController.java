package com.infobell.one_stop.controller;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.ProductDetails;
import com.infobell.one_stop.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-details")
public class ProductDetailsController {

    private final ProductDetailsService productDetailsService;

    @Autowired
    public ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    // Get product details by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetails> getProductDetailsById(@PathVariable int id) {
        try {
            ProductDetails productDetails = productDetailsService.getProductDetailsById(id);
            return new ResponseEntity<>(productDetails, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create product details
    @PostMapping("/create")
    public ResponseEntity<ProductDetails> createProductDetails(@RequestBody ProductDetails productDetails) {
        ProductDetails createdProductDetails = productDetailsService.createProductDetails(productDetails);
        return new ResponseEntity<>(createdProductDetails, HttpStatus.CREATED);
    }

    // Update product details
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetails> updateProductDetails(@PathVariable int id, @RequestBody ProductDetails productDetails) {
        try {
            ProductDetails updatedProductDetails = productDetailsService.updateProductDetails(id, productDetails);
            return new ResponseEntity<>(updatedProductDetails, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete product details by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductDetails(@PathVariable int id) {
        try {
            String result = productDetailsService.deleteProductDetails(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
