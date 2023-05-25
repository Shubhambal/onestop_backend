package com.infobell.one_stop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping("/pro")
	public List<Product> getProduct(){
		return this.productservice.getProduct();
	}
	
	@PostMapping("/savepro")
	public Product addProduct( @RequestBody Product product) {
		return this.productservice.addProduct(product);
	}
	
	@GetMapping("/pro/{id}")
	public Product getProductById( @PathVariable String id) {
		return this.productservice.getProductById(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct( @RequestBody Product product ) {
		return this.productservice.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{masterId}")
	public String deleteById( @PathVariable int masterId) {
		return this.productservice.deleteById(masterId);
	}
}
