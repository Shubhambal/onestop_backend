package com.infobell.one_stop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.repository.ProductRepository;
import com.infobell.one_stop.model.Product;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public List<Product> getProduct() {
		return productrepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		productrepository.save(product);
		return product;
	}

	@Override
	public Product getProductById(String id) {
		Product product = productrepository.findByProductId(id);
		if (product == null) {
			throw new ResourceNotFoundException("Product", "id", id);
		}
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		if(productrepository.existsById(product.getProductId())) {
			Product updatedProduct = productrepository.save(product);
			return updatedProduct;
		}
		else {
			throw new ResourceNotFoundException("Product", "id", Integer.toString(product.getProductId()));
		}
	}

	@Override
	public String deleteById(int id) {
		if (productrepository.existsById(id)) {
			productrepository.deleteById(id);
			return "Deleted.";
		}
		throw new ResourceNotFoundException("Product", "id", Integer.toString(id));
	}
}