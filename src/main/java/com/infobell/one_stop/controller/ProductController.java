package com.infobell.one_stop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infobell.one_stop.model.Product;
import com.infobell.one_stop.service.ProductService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/pro")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> products = productService.getProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Add a new product
    @PostMapping("/savepro")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    // Get product by ID
    @GetMapping("/pro/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a product
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a product by ID
    @DeleteMapping("/delete/{masterId}")
    public ResponseEntity<String> deleteById(@PathVariable int masterId) {
        String result = productService.deleteById(masterId);
        if (result.equals("success")) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value="/{search}")
    public List<Product> getProductsBySearch(@PathVariable String search)
	 {
		 return productService.getProductsBySearch(search);
	 }
}
