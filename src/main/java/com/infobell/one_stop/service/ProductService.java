package com.infobell.one_stop.service;

import java.util.List;

import com.infobell.one_stop.model.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Product addProduct(Product product);

	public Product getProductById(String id);

	public Product updateProduct(Product product);
	
	public String deleteById(int id);
}
