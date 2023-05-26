package com.infobell.one_stop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * The ProductController class handles HTTP requests related to products.
 * It provides endpoints for retrieving, adding, updating, and deleting products.
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;

	/**
	 * Retrieves all products.
	 *
	 * @return a list of Product objects
	 */
	@GetMapping("/getproduct")
	public List<Product> getProduct() {
		return this.productservice.getProduct();
	}

	/**
	 * Adds a new product.
	 *
	 * @param product the Product object to be added
	 * @return the ResponseEntity containing the result of the operation
	 */
	@PostMapping("/saveproduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return ResponseEntity.status(200).body(productservice.addProduct(product));
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id the ID of the product
	 * @return the ResponseEntity containing the requested product or an error message
	 */
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable String id) {
		return ResponseEntity.status(200).body(productservice.getProductById(id));
	}

	/**
	 * Updates an existing product.
	 *
	 * @param product the updated Product object
	 * @return the ResponseEntity containing the result of the operation
	 */
	@PutMapping("/updateproduct")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		return ResponseEntity.status(200).body(productservice.updateProduct(product));
	}

	/**
	 * Deletes a product by its master ID.
	 *
	 * @param masterId the master ID of the product
	 * @return the ResponseEntity containing the result of the operation
	 */
	@DeleteMapping("/delete/{masterId}")
	public ResponseEntity<?> deleteById(@PathVariable int masterId) {
		return ResponseEntity.status(200).body(productservice.deleteById(masterId));
	}
}
